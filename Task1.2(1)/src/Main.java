import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ввод информации о людях
        System.out.print("Введите количество людей: ");
        int n = scanner.nextInt(); // количество людей
        Person[] people = new Person[n];
        scanner.nextLine(); // очистка буфера
        System.out.println("Введите информацию о людях.");
        for (int i = 0; i < n; i++) {
            people[i] = new Person();
            System.out.println("\nИнформация о " + (i + 1) + "-м человеке:");
            System.out.print("Фамилия: ");
            people[i].surname = scanner.nextLine();

            System.out.print("Имя: ");
            people[i].name = scanner.nextLine();

            System.out.print("Год рождения: ");
            people[i].birthYear = scanner.nextInt();

            System.out.print("Месяц рождения: ");
            scanner.nextLine();
            people[i].birthMonth = scanner.nextLine();
        }

        //Вывод информации о людях
        System.out.println("\nИнформация о людях.");
        for (Person person : people) {
            System.out.println(person.surname + " " + person.name + ". Дата рождения: " + person.birthYear + " " + person.birthMonth);
        }

        //Определение самого старого человека
        Person oldestPerson = people[0];
        for (Person person : people) {
            if (person.birthYear > oldestPerson.birthYear) {
                oldestPerson = person;
            }
        }
        System.out.println("\nСамый старый человек: " + oldestPerson.surname + " " + oldestPerson.name);

        //Определение среднего возраста и людей старше среднего возраст
        double averageBirthYear = 0;
        for (Person person : people) {
            averageBirthYear += person.birthYear;
        }
        averageBirthYear /= people.length;
        System.out.println("\nСредний возраст: " + (Year.now().getValue() - averageBirthYear));
        System.out.println("Люди старше среднего возраста:");
        for (Person person : people) {
            if (person.birthYear < averageBirthYear) {
                System.out.println(person.surname + " " + person.name);
            }
        }

        //Упорядочить массив по фамилиям в порядке, обратном алфавитному
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].surname.compareToIgnoreCase(people[j + 1].surname) < 0) {
                    Person temp = people[j]; // temp – рабочая переменная для перестановки
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
        System.out.println("\nОтсортированный по фамилии список людей: ");
        for (Person person : people) {
            System.out.println(person.surname + " " + person.name);
        }

        // Поиск по фамилии
        System.out.println("Введите фамилию искомого человека: ");
        String name = scanner.nextLine();
        int nom = -1; // -1 – человек с искомым названием отсутствует
        for (int i = 0; i < people.length; i++) {
            if (name.equalsIgnoreCase(people[i].name)) {
                nom = i;
            }
        }
        if (nom != -1) {
            System.out.println("Такой человек есть в списке. Это" + people[nom].surname + " " + people[nom].name +
                    "." + " Дата рождения: " + people[nom].birthYear + " " + people[nom].birthMonth);
        } else System.out.println("Такого человека нет в списке");
    }
}
