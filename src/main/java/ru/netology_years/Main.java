package ru.netology_years;

import java.util.Scanner;

class Main {

    public static int daysInYear(int years) {
        int daysTrue = 0;
        if (years % 400 == 0) {
            daysTrue = 366;
        } else if (years % 100 != 0 && years % 4 == 0) {
            daysTrue = 366;
        } else {
            daysTrue = 365;
        }
        return daysTrue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int point = 0;

        while (true) {
            System.out.println("Введите год: ");
            int year = scanner.nextInt();
            System.out.println("Введите количество дней: ");
            int days = scanner.nextInt();

            int daysCompare = daysInYear(year);

            if (days == daysCompare) {
                point ++;
                continue;
            } else {
                System.out.println("Неправильно! В этом году " + daysCompare + " дней!");
                break;
            }
        }
        System.out.println("Набрано очков: " + point);
    }
}
