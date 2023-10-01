package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class FileWriterUtil {
    private static final String PHONE_NUMBER_REGEX = "^(\\+?7|8)?[-.\\s]?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2}$";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }
    public static void saveToFile(Person person) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(person.getLastName() + ".txt"), true));
        writer.write(person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName() + " " + person.getBirthDate() + " " + person.getPhoneNumber() + " " + person.getGender() + "\n");
        writer.close();
    }
}