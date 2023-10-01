package org.example;

import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в следующем порядке: Фамилия Имя Отчество дата рождения (в формате dd.mm.yyyy) номер телефона пол (ж/м)");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("eror_1: Неверное количество данных");
            return;
        }
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        try {
            Person person = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            DataValidator.validateData(person);
            FileWriterUtil.saveToFile(person);
            System.out.println("Данные успешно сохранены в файл " + lastName + ".txt");
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}