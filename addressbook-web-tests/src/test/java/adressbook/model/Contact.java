package adressbook.model;

public class Contact {
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

    public Contact(String firstname, String lastname, String address, String home, String email, String homepage, String byear, String bmonth, String bday, String new_group, String address2, String phone2, String notes) {
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


}
