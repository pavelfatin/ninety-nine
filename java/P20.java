// P20 Remove the K'th element from a list.

import core.List;
import core.Pair;

import static core.List.*;
import static core.Pair.pair;

class P20 {
    // Using "splitAt"
    <T> Pair<List<T>, T> f1(List<T> list, int n) {
        Pair<List<T>, List<T>> p = list.splitAt(n - 1);
        List<T> a = p.getA();
        List<T> b = p.getB();
        return pair(concat(a, b.tail()), b.head());
    }

    // By index (inefficient)
    <T> Pair<List<T>, T> f2(List<T> list, int n) {
        return pair(concat(list.take(n - 1), list.drop(n)), list.get(n - 1));
    }

    // Recursion
    <T> Pair<List<T>, T> f3(List<T> list, int n) {
        T h = list.head();
        List<T> t = list.tail();
        if (n > 1) {
            Pair<List<T>, T> p = f3(t, n - 1);
            return pair(cons(h, p.getA()), p.getB());
        } else {
            return pair(t, h);
        }
    }

    // Tail recursion
    <T> Pair<List<T>, T> f4(List<T> list, int n) {
        return f4_inner(list, n, List.<T>nil());
    }

    private <T> Pair<List<T>, T> f4_inner(List<T> list, int n, List<T> acc) {
        T h = list.head();
        List<T> t = list.tail();
        if (n > 1) {
            return f4_inner(t, n - 1, cons(h, acc));
        } else {
            return pair(concat(acc.reverse(), t), h);
        }
    }

    // Imperative
    <T> Pair<List<T>, T> f5(List<T> list, int n) {
        List<T> xs = nil();
        T x = null;
        int i = 0;
        for (T each : list) {
            i++;
            if (i == n)
                x = each;
            else
                xs = cons(each, xs);
        }
        return pair(xs.reverse(), x);
    }
}