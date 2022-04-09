package recordcountry;

import java.util.Scanner;

class Strana {
    String name; // название страны
    double square; // площадь страны
}

public class RecordCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ВВОД ИНФОРМАЦИИ О СТРАНАХ
        System.out.println("Введите количество стран=> ");
        int n = sc.nextInt(); // количество стран
        Strana country[] = new Strana[n];
        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            sc.nextLine(); // очистка буфера
            country[i] = new Strana();
            System.out.print("Название " + (i + 1) + "-й страны => ");
            country[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й страны =>");
            country[i].square = sc.nextDouble();
        }
        // ВЫВОД ПОЛУЧЕННОЙ ИНФОРМАЦИИ
        System.out.println("\nХарактеристики стран:");
        for (int i = 0; i < country.length; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + " млн кв. км");
        }

        // СТРАНА С МАКСИМАЛЬНОЙ ПЛОЩАДЬЮ
        int nommax = 0; // номер элемента для страны с максимальной площадью (начальное значение)

        double max = country[nommax].square; // максимальная площадь (начальное значение) ИЛИ другая запись цикла
        for (Strana str : country) {
            System.out.println(" " + str.name + "\t" + str.square + " млн кв. км");
        }

        for (int i = 0; i < country.length; i++) {
            if (country[i].square > max) {
                max = country[i].square;
                nommax = i;
            }
        }
        System.out.println("\nСтрана с максимальной площадью :");
        System.out.println("" + country[nommax].name + "\t" + country[nommax].square + "млн кв. км");
        // СОРТИРОВКА СТРАН ПО ПЛОЩАДИ
        for (int i = 0; i < country.length - 1; i++) {
            for (int j = 0; j < country.length - 1 - i; j++) {
                if (country[j].square > country[j + 1].square) {
                    Strana rab = country[j]; // rab – рабочая переменная для перестановки
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
            }
        }
        System.out.println("\nОтсортированный список по площади:");
        for (int i = 0; i < country.length; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + "млн кв. км");
        }
        // СОРТИРОВКА СТРАН ПО НАЗВАНИЮ
        for (int i = 0; i < country.length - 1; i++) {
            for (int j = 0; j < country.length - i - 1; j++) {
                if (country[j].name.compareTo(country[i + 1].name) > 0) {
                    Strana rab = country[j]; //rab – рабочая переменная для перестановки
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
            }
        }
        System.out.println("\nОтсортированный список по названиям:");
        for (int i = 0; i < country.length; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + " млн кв. км");
        }
        // ПЛОЩАДЬ БОЛЬШЕ СРЕДНЕЙ
        double s = 0; // суммарная площадь
        for (int i = 0; i < country.length; i++) {
            s += country[i].square;
        }
        double sr = s / country.length; // средняя площадь
        System.out.println("Средняя площадь =" + sr);
        System.out.println("\nСтраны, с площадью больше средней");
        for (int i = 0; i < country.length; i++) {
            if (country[i].square > sr) {
                System.out.println(country[i].name + "\t" + country[i].square + " млн кв. км");
            }
        }
        // ПОИСК ПО НАЗВАНИЮ
        sc.nextLine(); // очистка буфера
        System.out.println("Введите название искомой страны=> ");
        String name = sc.nextLine();
        int nom = -1; // -1 – страна с искомым названием отсутствует
        for (int i = 0; i < country.length; i++) {
            if (name.equalsIgnoreCase(country[i].name)) {
                nom = i;
            }
        }
        if (nom != -1) {
            System.out.println("Такая страна есть в списке. Это" + country[nom].name + " " + country[nom].square + " млн кв. км");
        } else System.out.println("Такой страны нет в списке");
    }
}