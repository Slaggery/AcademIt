package ru.academits.kuzmin.range_main;

import ru.academits.kuzmin.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 10);

        double inspectionNumber = 7;

        if (range.isInside(inspectionNumber)) {
            System.out.printf("Число %.2f входит в диапазон от %.2f до %.2f%n", inspectionNumber, range.getFrom(), range.getTo());
        } else {
            System.out.printf("Число %.2f не входит в диапазон от %.2f до %.2f%n", inspectionNumber, range.getFrom(), range.getTo());
        }

        Range range1 = new Range(1, 10);
        Range range2 = new Range(3, 12);

        Range intersection = range1.getIntersection(range2);

        if (intersection !=null) {
            intersection.print();
        }
    }
}
