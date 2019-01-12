package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class Contact {


    public void setId(int id) {
        this.id = id;
    }


    public Contact withId(int id) {
        this.id = id;
        return this;
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


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", home='" + home + '\'' +
                ", email='" + email + '\'' +
                ", homepage='" + homepage + '\'' +
                ", address2='" + address2 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name="firstname")

    private String firstname="" ;

    @Expose
    @Column(name="lastname")
    //@Type(type= "text")
    private String lastname="" ;

    //@Expose
    @Transient
    //Column(name="photo")
    //@Type(type= "text")
    private String photo;


    @Expose
    @Column(name="address")
    @Type(type= "text")
    private String address="";

    @Expose
    @Column(name="home")
    @Type(type= "text")
    private String home="";

    @Expose
    @Column(name="email")
    @Type(type= "text")
    private String email="" ;

    @Expose
    @Column(name="homepage")
    @Type(type= "text")
    private String homepage="" ;

    @Transient
    //@Expose
   // @Column(name="byear")
    //@Type(type= "text")
    private String byear="";

    @Transient
    //@Expose
    //@Column(name="bmonth")
  //  @Type(type= "text")
    private String bmonth;

    @Transient
    //@Expose
   // @Column(name="bday")
   // @Type(type= "text")
    private String bday ;

    //@Expose
    @Transient
    private String new_group;

    @Expose
    @Column(name="address2")
    @Type(type= "text")
    private String address2="";
    @Expose
    @Column(name="phone2")
    @Type(type= "text")
    private String phone2="";
    @Expose
    @Column(name="notes")
    @Type(type= "text")
    private String notes="";
    @Transient
    private String mobile;
    @Transient
    private String work;
    @Transient
   private String email2;
    @Transient
   private String email3;
   @Transient
   private String allPhones;
    @Transient
    private String allEmails;


    public File getPhoto() {
        return new File (photo);
    }

    public Contact withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                Objects.equals(firstname, contact.firstname) &&
                Objects.equals(lastname, contact.lastname) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(home, contact.home) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(homepage, contact.homepage) &&
                Objects.equals(address2, contact.address2) &&
                Objects.equals(phone2, contact.phone2) &&
                Objects.equals(notes, contact.notes) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, home, email, homepage, address2, phone2, notes);
    }
}

