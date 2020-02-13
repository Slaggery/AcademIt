package ru.academits.kuzmin.range_main;

import ru.academits.kuzmin.range.Range;

public class Main {
    public static void main(String[] args) {
        Range diapason = new Range(1, 10);

        double inspectionNumber = 7;

        if (diapason.isInside(inspectionNumber)) {
            System.out.printf("Число %.2f входит в диапазон от %.2f до %.2f%n", inspectionNumber, diapason.getFrom(), diapason.getTo());
        } else {
            System.out.printf("Число %.2f не входит в диапазон от %.2f до %.2f%n", inspectionNumber, diapason.getFrom(), diapason.getTo());
        }

        Range diapason1 = new Range(1, 12);
        Range diapason2 = new Range(6, 9);

        Range intervalsIntersection = new Range(0, 0).getIntervalsIntersection(diapason1, diapason2);

        if (intervalsIntersection == null) {
            System.out.println("Диапазона пересечения нет");
        } else {
            System.out.printf("Новый диапазон пересечения от %.2f до %.2f%n", intervalsIntersection.getFrom(), intervalsIntersection.getTo());
        }

        Range[] intervalsMerge = new Range(0, 0).getIntervalsMerge(diapason1, diapason2);

        for (Range range : intervalsMerge) {
            System.out.printf("Новый диапазон объединения от %.2f до %.2f%n", range.getFrom(), range.getTo());
        }

        Range[] intervalsDifference = new Range(0, 0).getIntervalsDifference(diapason1, diapason2);

        for (Range range : intervalsDifference) {
            System.out.printf("Новый диапазон разности от %.2f до %.2f%n", range.getFrom(), range.getTo());
        }
    }
}
