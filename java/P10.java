// P10 Run-length encoding of a list.

import core.List;
import core.Pair;

import static core.List.*;
import static core.Pair.pair;

class P10 {
    // Recursion
    <T> List<Pair<Integer, T>> f1(List<List<T>> list) {
        if (list.isEmpty()) {
            return nil();
        } else {
            List<T> h = list.head();
            return cons(pair(h.length(), h.head()), f1(list.tail()));
        }
    }

    // Tail recursion
    <T> List<Pair<Integer, T>> f2(List<List<T>> list) {
        return f2_inner(List.<Pair<Integer, T>>nil(), list);
    }

    private <T> List<Pair<Integer, T>> f2_inner(List<Pair<Integer, T>> acc, List<List<T>> list) {
        if (list.isEmpty()) {
            return acc.reverse();
        } else {
            List<T> h = list.head();
            return f2_inner(cons(pair(h.length(), h.head()), acc), list.tail());
        }
    }

    // Imperative
    <T> List<Pair<Integer, T>> f3(List<List<T>> list) {
        List<Pair<Integer, T>> result = nil();
        for (List<T> each : list.reverse())
            result = cons(pair(each.length(), each.head()), result);
        return result;
    }
}