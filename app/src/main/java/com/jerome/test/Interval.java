package com.jerome.test;

class IntervalBadParameters extends IllegalArgumentException {
    IntervalBadParameters() {
        super("inf greater than sup!");
    }
}

class Interval {
    private int inf;
    private int sup;

    Interval(int inf, int sup) {
        if (inf <= sup) {
            this.inf = inf;
            this.sup = sup;
        } else {
            this.inf = sup;
            this.sup = inf;
            throw new IntervalBadParameters();
        }
    }

    public int getBorneInf() {
        return getInf();
    }

    public int getBorneSup() {
        return getSup();
    }

    public boolean contient(int x) {
        return (x >= inf) && (x <= sup);
    }

    public boolean contient(Interval I) {
        return (I.getInf() >= inf) && (I.getSup() <= sup);
    }

    public boolean estDisjointDe(Interval I) {
        return (I.getSup() < inf) || (I.getInf() > sup);
    }

    public boolean intersecte(Interval I) {
        return !estDisjointDe(I);
    }

    public Interval intersection(Interval I) {
        if (intersecte(I)) {
            Interval result = new Interval(0, 0);
            if (inf < I.getInf()) {
                result.setInf(I.getInf());
            } else {
                result.setInf(inf);
            }
            if (sup < I.getSup()) {
                result.setSup(sup);
            } else {
                result.setSup(I.getSup());
            }
            return (result);
        } else {
            return null;
        }
    }

    public Interval union(Interval I) {
        if (intersecte(I)) {
            Interval result = new Interval(0, 0);
            if (inf < I.getInf()) {
                result.setInf(inf);
            } else {
                result.setInf(I.getInf());
            }
            if (sup < I.getSup()) {
                result.setSup(I.getSup());
            } else {
                result.setSup(sup);
            }
            return (result);
        } else {
            return null;
        }
    }

    public boolean equals(Interval I) {
        return (inf == I.getInf()) && (sup == I.getSup());
    }

    public String toString() {

        return "[" + inf + ", " + sup + "]";
    }

    public int getInf() {
        return inf;
    }

    public void setInf(int inf) {
        this.inf = inf;
    }

    public int getSup() {
        return sup;
    }

    public void setSup(int sup) {
        this.sup = sup;
    }
}
