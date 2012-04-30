// P19 Rotate a list N places to the left.

import core.List;
import core.Pair;

import static core.List.*;

class P19 {
    // Using "splitAt"
    <T> List<T> f1(List<T> list, int n) {
        int l = list.length();
        int i = list.nonEmpty() ? n % l : 0;
        Pair<List<T>, List<T>> p = list.splitAt(i < 0 ? l + i : i);
        return concat(p.getB(), p.getA());
    }

    // Tail recursion
    <T> List<T> f2(List<T> list, int n) {
        if (list.isEmpty()) return nil();
        if (n == 0) return list;
        return n > 0 ? f2(concat(list.tail(), singleton(list.head())), n - 1) :
                f2(cons(list.last(), list.init()), n + 1);
    }
}