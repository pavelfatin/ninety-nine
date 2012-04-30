// P21 Insert an element at a given position into a list.

import core.List;
import core.Pair;

import static core.List.*;

class P21 {
    // Using "splitAt"
    <T> List<T> f1(List<T> list, int n, T x) {
        Pair<List<T>, List<T>> p = list.splitAt(n - 1);
        List<T> a = p.getA();
        List<T> b = p.getB();
        return concat(a, cons(x, b));
    }

    // By index (inefficient)
    <T> List<T> f2(List<T> list, int n, T x) {
        return concat(list.take(n - 1), cons(x, list.drop(n - 1)));
    }

    // Recursion
    <T> List<T> f3(List<T> list, int n, T x) {
        return n == 1 ? cons(x, list) : cons(list.head(), f2(list.tail(), n - 1, x));
    }

    // Tail recursion
    <T> List<T> f4(List<T> list, int n, T x) {
        return f4_inner(list, n, x, List.<T>nil());
    }

    private <T> List<T> f4_inner(List<T> list, int n, T x, List<T> acc) {
        return n == 1
                ? concat(acc.reverse(), cons(x, list))
                : f4_inner(list.tail(), n - 1, x, cons(list.head(), acc));
    }

    // Imperative
    <T> List<T> f5(List<T> list, int n, T x) {
        List<T> result = nil();
        int i = 0;
        for (T each : list) {
            i++;
            result = i == 1 ? cons(x, cons(each, result)) : cons(each, result);
        }
        return result.reverse();
    }
}