package core;

// Immutable Tuple2
public class Pair<A, B> {
    private A a;
    private B b;

    private Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public static <A, B> Pair<A, B> pair(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Pair && a.equals(((Pair) o).a) && b.equals(((Pair) o).b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", a.toString(), b.toString());
    }
}