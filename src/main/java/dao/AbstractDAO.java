package dao;

import connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that uses generics and the reflection technique to define the common operations for accessing a table: Insert, Update, Delete,
 * FindById, FindAll
 *
 * @param <T> generic type ( T can be any Java Model Class that is mapped to the database)
 */
public abstract class  AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * @return
     */
    public List<T> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = createSimpleSelectQuery().toString();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            return createObjects(result);

        } catch (SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * method used to find an object in the database based on a specific id
     *
     * @param id id of object ro be found
     * @return object T if found else null
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSimpleSelectQuery().append(" WHERE id =?").toString();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * method used to find an object in the database based on a field.
     * For a Client query, the field id 'cnp' and for Product the field is 'product_name'
     *
     * @param field value used to execute the search in database
     * @return object T
     */
    public T findByField(String field) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSimpleSelectQuery().append(" WHERE " + type.getDeclaredFields()[1].getName() + " =?").toString();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, field);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method for inserting a new object in a database table
     *
     * @param object object to be inserted
     * @return number of rows affected
     */
    public int insert(T object){
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(type.getSimpleName().toLowerCase()).append("(");

        StringBuilder columns = new StringBuilder();
        StringBuilder queryValues = new StringBuilder();
        List<Object> values = new ArrayList<>();

        try {
            for(Field field:type.getDeclaredFields()){
                String fieldName = field.getName();
                if(!fieldName.equals("id")){
                    columns.append(fieldName).append(", ");
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getReadMethod();
                    values.add(formatToString(method.invoke(object)));
                    queryValues.append("?, ");
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        columns.setLength(columns.length() - 2);
        queryValues.setLength(queryValues.length() - 2);
        query.append(columns).append(") VALUES (").append(queryValues).append(")");

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query.toString());
            for(int i = 0; i<values.size(); i++){
                statement.setObject(i+1, values.get(i));
            }
            result = statement.executeUpdate();

            return result;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }

    /**
     * Method for updating an object from a database table
     * @param object object to be updated
     * @param fieldID field that identifies the object
     * @return the number of rows affected
     */
    public int update(T object, String fieldID){
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ").append(type.getSimpleName().toLowerCase()).append(" SET ");
        List<Object> values = new ArrayList<>();

        try {
            for(Field field:type.getDeclaredFields()){
                String fieldName = field.getName();
                if(!fieldName.equals("id")){
                    query.append(fieldName).append(" =?, ");
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getReadMethod();
                    values.add(formatToString(method.invoke(object)));
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // delete trailing ", "
        query.setLength(query.length() - 2);
        query.append(" WHERE ").append( type.getDeclaredFields()[1].getName().toLowerCase()).append(" =?");

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query.toString());
            for(int i = 0; i<values.size(); i++){
                statement.setObject(i+1, values.get(i));
            }
            statement.setString(values.size()+1, fieldID);
            result = statement.executeUpdate();

            return result;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }

    /**
     * Method for deleting an object from a database table
     * @param field field that identifies the object to be deleted
     * @return the number of rows affected
     */
    public int delete(String field){
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM ").append(type.getSimpleName().toLowerCase()).append(" WHERE ");
        query.append( type.getDeclaredFields()[1].getName().toLowerCase()).append(" =?");

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.setString(1, field);
            result = statement.executeUpdate();

            return result;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }

    /**
     * Method that creates a select query
     *
     * @return
     */
    private StringBuilder createSimpleSelectQuery(){
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append(" * ");
        query.append(" FROM ");
        query.append(type.getSimpleName().toLowerCase());
        return query;
    }

    /**
     * Method that constructs a list of objects from a returned result set
     *
     * @param resultSet result set
     * @return a list of generic objects
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] constructors = type.getDeclaredConstructors();
        Constructor emptyConstructor = null;

        // getting the empty constructor
        for (int i = 0; i < constructors.length; i++) {
            emptyConstructor = constructors[i];
            if (emptyConstructor.getGenericParameterTypes().length == 0)
                break;
        }

        try {
            while (resultSet.next()) {
                emptyConstructor.setAccessible(true);
                T instance = (T)emptyConstructor.newInstance();

                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String formatToString(Object o){
        String objectType = o.getClass().getSimpleName();
        String formattedValue = "NULL";
        if(o != null){
            if(objectType.equals("String")){
                formattedValue = String.valueOf(o);
            }
            else if(objectType.equals("Double")){
                formattedValue = String.valueOf(o);
            }
            else if(objectType.equals("Integer")){
                formattedValue = String.valueOf(o);
            }
        }
        return formattedValue;
    }
}