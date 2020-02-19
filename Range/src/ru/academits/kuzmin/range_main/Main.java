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

        Range range1 = new Range(1, 12);
        Range range2 = new Range(6, 9);

        /*Range rangesIntersection = new Range(0, 0).getIntersection(range1, range2);

        if (rangesIntersection == null) {
            System.out.println("Диапазона пересечения нет");
        } else {
            System.out.printf("Новый диапазон пересечения от %.2f до %.2f%n", rangesIntersection.getFrom(), rangesIntersection.getTo());
        }

        Range[] intervalsMerge = new Range(0, 0).getUnion(range1, range2);

        for (Range range3 : intervalsMerge) {
            System.out.printf("Новый диапазон объединения от %.2f до %.2f%n", range3.getFrom(), range3.getTo());
        }

        Range[] rangesDifference = new Range(0, 0).getDifference(range1, range2);

        for (Range range4 : rangesDifference) {
            System.out.printf("Новый диапазон разности от %.2f до %.2f%n", range4.getFrom(), range4.getTo());
        }*/

        Range intersection = range1;

        intersection.getIntersection(range2);

        intersection.print();
    }
}
