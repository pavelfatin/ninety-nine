// P02 Find the last but one element of a list.

import core.List;

import java.util.NoSuchElementException;

import static core.List.*;

class P02 {
    // "Build-in" methods ;)
    <T> T f1(List<T> list) {
        return list.init().last();
    }

    // Tail-recursive "pattern matching" without pattern matching
    <T> T f2(List<T> list) {
        if (list.isEmpty()) throw new NoSuchElementException("List is empty");
        List<T> tail = list.tail();
        if (tail.isEmpty()) throw new NoSuchElementException("Singleton list");
        if (tail.tail().isEmpty()) return list.head();
        return f2(tail);
    }

    // Imperative approach with two variables
    <T> T f3(List<T> list) {
        if (list.isEmpty()) throw new NoSuchElementException("List is empty");
        T a = null;
        T b = null;
        for (T each : list) {
            b = a;
            a = each;
        }
        if (b == null) throw new NoSuchElementException("Singleton list");
        return b;
    }

    // "Build-in" methods with index
    <T> T f4(List<T> list) {
        return list.reverse().get(1);
    }
}