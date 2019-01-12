package ru.stqa.pft.adressbook.generators;

import ru.stqa.pft.adressbook.model.Contact;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<Contact> contacts = generateContact(count);
        if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {

            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<Contact> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }


    private void saveAsXml(List<Contact> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("group", Contact.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private List<Contact> generateContact(int count) {
        List<Contact> contacts = new ArrayList<Contact>();
        for (int i = 0; i < count; i++) {

            contacts.add(new Contact().withFirstname("Max").withLastname("Nemchenko").withAdress("Evropeyscii prosperct" +" "+ i).withHome("798168971"+i).withEmail("maxen_9"+i+"@mail.ru").
                    withHomepage("https://vk.com/"+i).withByear("199"+i).withBmonth("December").withBday("2"+i).withGroup("test1").withAddress2("Saint Peterburg").withPhone2(""+i).withNotes("mt"+i));
        }
            return contacts;


        }
    }



