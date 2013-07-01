
import java.io.Serializable;

// Person domain class
public class Person implements Serializable {

    // Id field
    private int id;
    private String name;

    // No arg constructor
    protected Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter method of id field
    public int getId() {
        return id;
    }

    // Setter method of id field
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
