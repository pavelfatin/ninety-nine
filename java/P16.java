// P16 Drop every N'th element from a list.

import core.List;

import static core.List.*;

class P16 {
    // Recursion with a counter
    <T> List<T> f1(int n, List<T> list) {
        return f1_inner(n, n, list);
    }

    private <T> List<T> f1_inner(int n, int k, List<T> list) {
        return list.isEmpty() ? List.<T>nil() : k == 1
                ? f1_inner(n, n, list.tail())
                : cons(list.head(), f1_inner(n, k - 1, list.tail()));
    }

    // Tail recursion
    <T> List<T> f2(int n, List<T> list) {
        return f2_inner(n, n, List.<T>nil(), list);
    }

    private <T> List<T> f2_inner(int n, int k, List<T> acc, List<T> list) {
        return list.isEmpty() ? acc.reverse() : k == 1
                ? f2_inner(n, n, acc, list.tail())
                : f2_inner(n, k - 1, cons(list.head(), acc), list.tail());
    }

    // Recursion with "take" and "drop"
    <T> List<T> f3(int n, List<T> list) {
        return list.isEmpty()
                ? List.<T>nil()
                : concat(list.take(n - 1), f3(n, list.drop(n)));
    }

    // Imperative
    <T> List<T> f4(int n, List<T> list) {
        List<T> acc = nil();
        int k = 1;
        for (T it : list) {
            if (k < n) {
                acc = cons(it, acc);
                k++;
            } else {
                k = 1;
            }
        }
        return acc.reverse();
    }
}