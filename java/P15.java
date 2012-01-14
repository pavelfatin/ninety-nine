// P15 Replicate the elements of a list a given number of times.

import core.List;

import static core.List.*;

class P15 {
    // Recursion, one-pass concatenation
    <T> List<T> f1(int n, List<T> list) {
        return list.isEmpty()
                ? List.<T>nil()
                : prepend(n, list.head(), f1(n, list.tail()));
    }

    <T> List<T> prepend(int n, T x, List<T> list) {
        return n == 0 ? list : cons(x, prepend(n - 1, x, list));
    }

    // Imperative
    <T> List<T> f2(int n, List<T> list) {
        List<T> acc = nil();
        for (T each : list)
            for (int i = 0; i < n; i++)
                acc = cons(each, acc);
        return acc.reverse();
    }
}