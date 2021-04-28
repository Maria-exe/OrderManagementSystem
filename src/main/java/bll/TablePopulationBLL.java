package bll;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements methods for populating the JTable components in UI, using the  reflection technique
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */

public class TablePopulationBLL
{
    /**
     * Method that uses the reflection technique to generate the table headers for the JTable components declared in the View class
     *
     * @param object an instance of a class that models a database table
     * @return a list with all the column names for the table header
     */
    public static List<String> getTableHeader(Object object) {
        List<String> header = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields())
        {
            field.setAccessible(true);
            header.add(field.getName());
        }
        return header;
    }

    /**
     * Method that uses the reflection technique to generate the table rows for the JTable components declared in the View class
     *
     * @param object  an instance of a class that models a database table
     * @return a list containing the values of a table row from the database
     */
    public static List<String> getTableRow(Object object) {
        List<String> tableRowContents = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                tableRowContents.add(String.valueOf(value));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return tableRowContents;
    }


}