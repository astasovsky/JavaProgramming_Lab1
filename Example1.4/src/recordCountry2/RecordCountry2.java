package recordCountry2;

import java.util.Scanner;

class Strana {
    String name;
    double square;
}

public class RecordCountry2 {
    // МЕТОДЫ ДЛЯ ВСЕХ ПОДЗАДАЧ для работы с объектами класса Strana
    public static Strana[] setCountryArr(int k) { // ВВОД МАССИВА СТРАН
        Scanner sc = new Scanner(System.in);
        Strana country[] = new Strana[k];
        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana();
            System.out.print("Название " + (i + 1) + "-й страны => "); // Россия--США--Индия--Австралия

            country[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й страны => "); // 17--9,8--3,2--7,7 млн кв. км (2010 г.)

            country[i].square = sc.nextDouble();
            sc.nextLine(); // очистка буфера
        }
        return country;
    }

    public static void showArray(Strana[] cntr) { // ВЫВОД МАССИВА
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + " \t" + cntr[i].square + " млн кв. км");
        }
    }

    // ИНФОРМАЦИЯ ОБ ОДНОЙ СТРАНЕ
    public static void showCountry(Strana cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.square + " млн кв. км");
    }

    // НОМЕР СТРАНЫ С МАКС. ПЛОЩАДЬЮ
    public static int NomMax(Strana[] st) {
        int nommax = 0; // номер элемента страны с макс. площадью

        // (начальное значение)
        double max = st[nommax].square; // макс. площадь (начальное значение)
        for (int i = 0; i < st.length; i++)
            if (st[i].square > max) {
                max = st[i].square;
                nommax = i;
            }
        return nommax;
    }

    // СОРТИРОВКА СТРАН ПО ПЛОЩАДИ
    public static void sortSquare(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].square > cntr[j + 1].square) {
                    Strana rab = cntr[j]; // rab – рабочая переменная для перестановки
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }

    }

    // СОРТИРОВКА СТРАН ПО НАЗВАНИЮ
    public static void sortName(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Strana rab = cntr[j]; // rab – рабочая переменная для перестановки
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static double avgSquare(Strana[] cntr) { // СРЕДНЯЯ ПЛОЩАДЬ
        double s = 0; // суммарная площадь
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].square;

        double sr = s / cntr.length; // средняя площадь
        return sr;
    }

    // СТРАНЫ С ПЛОЩАДЬЮ БОЛЬШЕ СРЕДНЕЙ
    public static Strana[] Bigger(Strana cntr[]) {
        double sred = avgSquare(cntr);
        int kol = 0; // количество стран
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square > sred) ++kol;
        }
        if (kol != 0) {
            Strana[] bigCountry = new Strana[kol];
            int n = -1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].square > sred) {
                    bigCountry[++n] = cntr[i];
                }
            return bigCountry;
        } else return null;
    }

    // ПОИСК ПО НАЗВАНИЮ
    public static Strana findForName(Strana cntr[], String name) {
        int n = -1; // -1 – страна с искомым названием отсутствует
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name)) n = i;
        if (n != -1) {
            return cntr[n];
        } else return null;
    }

    public static void main(String[] args) { // ГЛАВНЫЙ КЛАСС С МЕТОДАМИ
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество стран=> ");
        int n = sc.nextInt(); // количество стран

        Strana country[] = setCountryArr(n); // ввод информации о странах
        System.out.println("\nХарактеристики стран:");
        showArray(country); // вывод полученной информации

        // страна с максимальной площадью
        int nommax = NomMax(country);
        System.out.println("\nСтрана с максимальной площадью:");
        showCountry(country[nommax]);

        // сортировка стран по площади
        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);
        // сортировка стран по названию
        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);
        // cредняя площадь
        System.out.println("Средняя площадь =" + avgSquare(country));
        // площадь больше средней
        System.out.println("\nСтраны, с площадью больше средней");
        Strana[] larger = Bigger(country);
        showArray(larger);
        // поиск страны
        System.out.println("\nПОИСК СТРАНЫ \n Введите название страны => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Strana sfind = findForName(country, sname);
        if (sfind != null) {
            showCountry(sfind);
        } else {
            System.out.println("Такой страны нет в списке!");
        }
    }
}