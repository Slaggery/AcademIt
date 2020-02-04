package ru.academits.kuzmin.range_main;

import ru.academits.kuzmin.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите чило начала диапазона:");
        double from = scanner.nextDouble();

        System.out.println("Введите число окончания диапазона:");
        double to = scanner.nextDouble();

        System.out.println("Введите число для проверки принадлежности диапазону:");
        double number = scanner.nextDouble();

        Range range = new Range(from, to);

        if (range.isInside(number)) {
            System.out.printf("Число %.2f входит в диапазон от %.2f до %.2f", number, from, to);
        } else {
            System.out.printf("Число %.2f не входит в диапазон от %.2f до %.2f", number, from, to);
        }
    }
}
