package ru.academits.kuzmin.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return from <= number && number <= to;
    }

    public Range getIntervalsIntersection(Range diapason1, Range diapason2) {
        double resultFrom;
        double resultTo;

        if (diapason1.isInside(diapason2.getFrom())) {
            resultFrom = diapason2.getFrom();
        } else if (diapason2.isInside(diapason1.getFrom())) {
            resultFrom = diapason1.getFrom();
        } else {
            return null;
        }

        if (diapason1.isInside(diapason2.getTo())) {
            resultTo = diapason2.getTo();
        } else {
            resultTo = diapason1.getTo();
        }

        return new Range(resultFrom, resultTo);
    }

    public Range[] getIntervalsMerge(Range diapason1, Range diapason2) {
        double resultFrom;
        double resultTo;

        if (diapason1.isInside(diapason2.getFrom())) {
            resultFrom = diapason1.getFrom();
        } else if (diapason2.isInside(diapason1.getFrom())) {
            resultFrom = diapason2.getFrom();
        } else {
            Range[] ranges = new Range[2];

            ranges[0] = new Range(diapason1.getFrom(), diapason1.getTo());
            ranges[1] = new Range(diapason2.getFrom(), diapason2.getTo());
            return ranges;
        }

        if (diapason1.isInside(diapason2.getTo())) {
            resultTo = diapason1.getTo();
        } else {
            resultTo = diapason2.getTo();
        }

        Range[] result = new Range[1];

        result[0] = new Range(resultFrom, resultTo);

        return result;
    }

    public Range[] getIntervalsDifference(Range diapason1, Range diapason2) {
        if (diapason2.getFrom() >= diapason1.getTo() || diapason2.getTo() >= diapason1.getTo()) {
            Range[] ranges = new Range[1];

            if (diapason2.getFrom() >= diapason1.getTo()) {
                ranges[0] = new Range(diapason1.getFrom(), diapason1.getTo());
            } else {
                ranges[0] = new Range(diapason1.getFrom(), diapason2.getFrom());
            }

            return ranges;
        } else {
            Range[] ranges = new Range[2];

            ranges[0] = new Range(diapason1.getFrom(), diapason2.getFrom());
            ranges[1] = new Range(diapason2.getTo(), diapason1.getTo());

            return ranges;
        }
    }
}
