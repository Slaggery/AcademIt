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

    public Range getIntersection(Range range) {
        double resultFrom;
        double resultTo;

        resultFrom = Math.max(this.from, from);
        resultTo = Math.min(this.to, to);

        return new Range(resultFrom, resultTo);
    }

    public Range[] getUnion(Range range1, Range rang2) {
        double resultFrom;
        double resultTo;

        if (range1.isInside(rang2.getFrom())) {
            resultFrom = range1.getFrom();
        } else if (rang2.isInside(range1.getFrom())) {
            resultFrom = rang2.getFrom();
        } else {
            Range[] ranges = new Range[2];

            ranges[0] = new Range(range1.getFrom(), range1.getTo());
            ranges[1] = new Range(rang2.getFrom(), rang2.getTo());
            return ranges;
        }

        if (range1.isInside(rang2.getTo())) {
            resultTo = range1.getTo();
        } else {
            resultTo = rang2.getTo();
        }

        Range[] result = new Range[1];

        result[0] = new Range(resultFrom, resultTo);

        return result;
    }

    public Range[] getDifference(Range range1, Range range2) {
        if (range2.getFrom() >= range1.getTo() || range2.getTo() >= range1.getTo()) {
            Range[] ranges = new Range[1];

            if (range2.getFrom() >= range1.getTo()) {
                ranges[0] = new Range(range1.getFrom(), range1.getTo());
            } else {
                ranges[0] = new Range(range1.getFrom(), range2.getFrom());
            }

            return ranges;
        } else {
            Range[] ranges = new Range[2];

            ranges[0] = new Range(range1.getFrom(), range2.getFrom());
            ranges[1] = new Range(range2.getTo(), range1.getTo());

            return ranges;
        }
    }

    public void print () {
        System.out.printf("(%.2f; %.2f)", from, to);
    }
}
