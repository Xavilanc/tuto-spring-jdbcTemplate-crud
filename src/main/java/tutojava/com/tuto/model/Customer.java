package tutojava.com.tuto.model;

public class Customer {
    private long id;
    private String firstName, lastName;

    public Customer(long id, String firstname, String lastname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

}
