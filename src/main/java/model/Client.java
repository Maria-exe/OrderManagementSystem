package model;

/**
 * Class that models the Client table from the database
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class Client {
    private Integer id;
    private String cnp;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String email;

    public Client(Integer id, String cnp, String firstName, String lastName, Integer age, String phone, String email) {
        this.id = id;
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Client(String cnp, String firstName, String lastName, Integer age, String phone, String email) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Client() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName+ ", age=" + age + ", email=" + email
                + ", phone=" +phone + "]";
    }

}
