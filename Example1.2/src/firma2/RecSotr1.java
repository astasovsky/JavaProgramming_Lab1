package firma2;

import java.util.Scanner;

class Sotrudnik {
    String fam, im, otch, doljnost;
    int kolDet;
    Rebenok[] reb = null;
}

class Rebenok {
    String imaR;
    int vozrastR;
}

public class RecSotr1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество сотрудников => ");
        int kol = sc.nextInt();
        sc.nextLine(); // очистка буфера

        Sotrudnik[] sotr = new Sotrudnik[kol];
        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i] = new Sotrudnik();
            System.out.print("Введите фамилию " + (i + 1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();
            System.out.print("Введите его имя => ");
            sotr[i].im = sc.nextLine();
            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();
            System.out.print("Введите его должность => ");
            sotr[i].doljnost = sc.nextLine();
            System.out.print("Введите количество детей => ");
            sotr[i].kolDet = sc.nextInt();
            sc.nextLine(); // очистка буфера

            sotr[i].reb = new Rebenok[sotr[i].kolDet];
            if (sotr[i].kolDet != 0) {
                System.out.println("Дети => ");
                for (int j = 0; j < sotr[i].reb.length; j++) {
                    sotr[i].reb[j] = new Rebenok();
                    System.out.print("Введите имя " + (i + 1) + " ребенка => ");
                    sotr[i].reb[j].imaR = sc.nextLine();
                    System.out.print("Введите его возраст => ");
                    sotr[i].reb[j].vozrastR = sc.nextInt();
                    sc.nextLine(); // очистка буфера
                }
            }
        }

        // ВЫВОД ИНФОРМАЦИИ О СОТРУДНИКАХ
        System.out.println("\nСотрудники фирмы \n фам \t имя \t отч \t должность");
        for (Sotrudnik s : sotr) {
            System.out.print(s.fam + "\t" + s.im + "\t" + s.otch + "\t " + s.doljnost);
            System.out.println("\n Дети: ");
            for (Rebenok r : s.reb)
                System.out.println("\t\t\t" + r.imaR + "\t\t" + r.vozrastR);
            System.out.println("");
        }
    }
}