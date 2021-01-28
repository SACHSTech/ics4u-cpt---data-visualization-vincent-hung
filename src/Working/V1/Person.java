package CPT;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
 
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty emailxx;
 
    public Person(String first, String last, String email) {
        this.firstName = new SimpleStringProperty(first);
        this.lastName = new SimpleStringProperty(last);
        this.emailxx = new SimpleStringProperty(email);
    }
 
    public StringProperty firstNameProperty() {
        return firstName;
    }
 
    public StringProperty lastNameProperty() {
        return lastName;
    }
 
    public StringProperty emailxxProperty() {
        return emailxx;
    }
}
