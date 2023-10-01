package org.example;

// проверка корректности введенных данных
public class DataValidator {
    public static void validateData(Person person) throws InvalidDataException {
        if (!isValidName(person.getLastName())) {
            throw new InvalidDataException("eror_2: Неверный формат фамилии");
        }
        if (!isValidName(person.getFirstName())) {
            throw new InvalidDataException("eror_3: Неверный формат имени");
        }
        if (!isValidName(person.getMiddleName())) {
            throw new InvalidDataException("eror_4: Неверный формат отчества");
        }
        if (!isValidDate(person.getBirthDate())) {
            throw new InvalidDataException("eror_5: Неверный формат даты рождения");
        }
        if (!isValidPhoneNumber(person.getPhoneNumber())) {
            throw new InvalidDataException("eror_6: Неверный формат номера телефона");
        }
        if (!isValidGender(person.getGender())) {
            throw new InvalidDataException("eror_7: Неверный формат пола");
        }
    }

    private static boolean isValidName(String name) {
        return name.matches("[а-яА-Я]+");
    }

    private static boolean isValidDate(String date) {
        return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(\\+?7|8)?\\d{10}$");
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("ж") || gender.equals("м");
    }
}