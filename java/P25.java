// P25 Generate a random permutation of the elements of a list.

import core.List;
import core.Pair;

import java.util.Random;

import static core.Pair.*;
import static core.List.*;

class P25 {
    private final Random random = new Random();

    // The obvious answer is P23.f1(list.length(), list)
    // Let's directly select a random permutation for a different implementation
    <T> List<T> f1(List<T> list) {
        List<List<T>> all = permutations(list);
        return all.get(random.nextInt(all.length()));
    }

    private <T> List<List<T>> permutations(List<T> list) {
        if (list.isEmpty()) return singleton(List.<T>nil());

        List<List<T>> result = nil();

        for (int i = 0; i < list.length(); i++) {
            Pair<List<T>, T> p = removeAt(list, i);

            for (List<T> permutation : permutations(p.getA())) {
                result = cons(cons(p.getB(), permutation), result);
            }
        }

        return result;
    }

    private <T> Pair<List<T>, T> removeAt(List<T> list, int n) {
        Pair<List<T>, List<T>> p = list.splitAt(n);
        List<T> a = p.getA();
        List<T> b = p.getB();
        return pair(concat(a, b.tail()), b.head());
    }
}