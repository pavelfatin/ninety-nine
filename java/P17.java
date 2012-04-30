// P17 Split a list into two parts; the length of the first part is given.

import core.List;
import core.Pair;

import static core.List.*;
import static core.Pair.pair;

class P17 {
    // Using 'predefined' function
    <T> Pair<List<T>, List<T>> f1(int n, List<T> list) {
        return list.splitAt(n);
    }

    // Using "take" and "drop"
    <T> Pair<List<T>, List<T>> f2(int n, List<T> list) {
        return pair(list.take(n), list.drop(n));
    }

    // Recursion with a counter
    <T> Pair<List<T>, List<T>> f3(int n, List<T> list) {
        if (list.isEmpty())
            return pair(List.<T>nil(), List.<T>nil());

        if (n == 0)
            return pair(List.<T>nil(), list);

        Pair<List<T>, List<T>> p = f3(n - 1, list.tail());

        return pair(cons(list.head(), p.getA()), p.getB());
    }

    // Tail recursion with a counter
    <T> Pair<List<T>, List<T>> f4(int n, List<T> list) {
        return f4_inner(List.<T>nil(), n, list);
    }

    private <T> Pair<List<T>, List<T>> f4_inner(List<T> acc, int n, List<T> list) {
        return list.isEmpty()
                ? pair(acc.reverse(), List.<T>nil())
                : n == 0 ? pair(acc.reverse(), list) : f4_inner(cons(list.head(), acc), n - 1, list.tail());
    }
}