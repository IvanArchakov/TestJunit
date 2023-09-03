package ru.netology_tax;

import java.util.Scanner;

public class Main {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = (earnings) * 6 / 100;
        return tax;
    }


    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String expenseStr = scanner.nextLine();
                    int expense = Integer.parseInt(expenseStr);
                    spendings += expense;
                    break;
                case 3:
                    int stsExpense = taxEarnings(earnings);
                    int stsEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);
                    if (stsExpense - stsEarningsMinusSpendings < 0) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + stsExpense + " рублей");
                        System.out.println("Налог на другой системе: " + stsEarningsMinusSpendings + " рублей");
                        System.out.println("Экономия: " + (stsEarningsMinusSpendings - stsExpense) + " рублей");
                    } else if (stsExpense - stsEarningsMinusSpendings > 0) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + stsEarningsMinusSpendings + " рублей");
                        System.out.println("Налог на другой системе: " + stsExpense + " рублей");
                        System.out.println("Экономия: " + (stsExpense - stsEarningsMinusSpendings) + " рублей");
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                        System.out.println("Ваш налог составит: " + stsExpense + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}


