package adressbook.model;

public class Contact {


    public void setId(int id) {
        this.id = id;
    }




    public Contact withId(int id) {
        this.id = id;
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (firstname != null ? !firstname.equals(contact.firstname) : contact.firstname != null) return false;
        return lastname != null ? lastname.equals(contact.lastname) : contact.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
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





    public Contact withFirstname(String firstname) {
        this.firstname = firstname;
        return this;

    }

    public Contact withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Contact withAdress(String address) {
        this.address = address;
        return this;
    }
    public Contact withHome(String home) {
        this.home = home;
        return this;

    }
    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }
        public Contact withHomepage(String homepage) {
            this.homepage = homepage;
            return this;
        }
    public Contact withByear(String byear) {
        this.byear = byear;
        return this;
    }
    public Contact withBmonth(String bmonth) {
        this.bmonth =bmonth;
        return this;
    }

    public Contact withBday(String bday) {
        this.bday =bday;
        return this;
    }

    public Contact withGroup(String  new_group) {
        this.new_group = new_group;
        return this;
    }
    public Contact withAddress2(String  address2) {
        this.address2 = address2;
        return this;
    }
    public Contact withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;

    }
    public Contact withNotes(String notes) {
        this.notes = notes;
        return this;
    }
    private int id=Integer.MAX_VALUE;;
    private String firstname;
    private String lastname;
    private String address;
    private String home;
    private String email;
    private String homepage;
    private String byear;
    private String bmonth;
    private String bday;
    private String new_group;
    private String address2;
    private String phone2;
    private String notes;



}
