package adressbook.model;

public class Contact {
    public void setId(int id) {
        this.id = id;
    }
    private int id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String home;
    private final String email;
    private final String homepage;
    private final String byear;
    private final String bmonth;
    private final String bday;
    private String new_group;
    private final String address2;
    private final String phone2;
    private final String notes;

    public Contact(int id, String firstname, String lastname, String address, String home, String email, String homepage, String byear, String bmonth, String bday, String new_group, String address2, String phone2, String notes) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.email = email;
        this.homepage = homepage;
        this.byear = byear;
        this.bmonth = bmonth;
        this.bday = bday;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }
    public Contact(String firstname, String lastname, String address, String home, String email, String homepage, String byear, String bmonth, String bday, String new_group, String address2, String phone2, String notes) {
        this.id=Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.email = email;
        this.homepage = homepage;
        this.byear = byear;
        this.bmonth = bmonth;
        this.bday = bday;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (firstname != null ? !firstname.equals(contact.firstname) : contact.firstname != null) return false;
        return lastname != null ? lastname.equals(contact.lastname) : contact.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() { return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getByear() {
        return byear;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getBday() {
        return bday;
    }

    public String getGroup() {
        return new_group;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }

    public int getId() {
        return id;
    }
}
