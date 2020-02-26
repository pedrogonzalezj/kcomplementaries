package com.devo.kcomplentary;

public class Pair {

    private int a;

    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[" + a + "," + b + "]";
    }

    @Override
    public int hashCode() {
        return a + b;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair)obj;
        if(a == other.a && b == other.b) {
            return true;
        }
        if(a == other.b && b == other.a) {
            return true;
        }
        return false;
    }
}
