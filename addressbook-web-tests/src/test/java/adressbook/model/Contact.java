package adressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;

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

    public String getLastname() {
        return lastname;
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


    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
        return email3;
    }
    public String getAllPhones() {
        return allPhones;
    }
    public String getAllEmails() {
        return allEmails;
    }

    public int getId() {
        return id;
    }

    public String getMobilePhone() {
        return mobile;
    }


    public String getWorkPhone() {
        return work;
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

    public Contact WithMobilePhone(String mobile) {
     this.mobile = mobile;
     return this;
    }
    public Contact WithWorkPhone(String work) {
     this.work = work;
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
        this.bmonth = bmonth;
        return this;
    }

    public Contact withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public Contact withGroup(String new_group) {
        this.new_group = new_group;
        return this;
    }

    public Contact withAddress2(String address2) {
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

        public Contact withEmail2(String email2) {
            this.email2 = email2;
            return this;
        }

        public Contact withEmail3(String email3) {
            this.email3 = email3;
            return this;
        }

        public Contact withEmail(String email) {
            this.email = email; return this;
        }
        public Contact withAllPhones(String allPhones) {
            this.allPhones = allPhones; return this;
        }
        public Contact withAllEmails(String allEmails) {
            this.allEmails = allEmails; return this;
        }



    private int id = Integer.MAX_VALUE;

    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String address;
    @Expose
    private String home;
    @Expose
    private String email;
    @Expose
    private String homepage;
    @Expose
    private String byear;
    @Expose
    private String bmonth;
    @Expose
    private String bday;
    @Expose
    private String new_group;
    @Expose
    private String address2;
    @Expose
    private String phone2;
    @Expose
    private String notes;
    private String mobile;
    private String work;
    private String email2;
    private String email3;
    private String allPhones;
    private String allEmails;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public Contact withPhoto(File photo) {
        this.photo = photo;
        return this;
    }




}

