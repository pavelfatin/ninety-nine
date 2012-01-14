// P11 Modified run-length encoding.

import core.List;
import core.Pair;

import static core.List.*;
import static core.Pair.*;

class P11 {
    // Recursion, list of objects
    @SuppressWarnings("unchecked")
    <T> List f1(List<Pair<Integer, T>> list) {
        if (list.isEmpty()) return nil();
        Pair<Integer, T> h = list.head();
        return cons(h.getA().equals(1) ? h.getB() : h, f1(list.tail()));
    }

    // Imperative, list of objects
    @SuppressWarnings("unchecked")
    <T> List f2(List<Pair<Integer, T>> list) {
        List acc = nil();
        for (Pair<Integer, T> each : list)
            acc = cons(each.getA().equals(1) ? each.getB() : each, acc);
        return acc.reverse();
    }
}