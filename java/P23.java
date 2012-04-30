// P23 Extract a given number of randomly selected elements from a list.

import core.List;
import core.Pair;

import java.util.Random;

import static core.List.*;
import static core.Pair.pair;

class P23 {
    private final Random random = new Random();

    // Building a target list while removing items from the source (recursively)
    // Time complexity is O(n^2) in worst and average cases, O(n) - in best case
    <T> List<T> f1(int n, List<T> list) {
        if (n > 0) {
            int i = random.nextInt(list.length());
            Pair<List<T>, T> p = removeAt(list, i);
            return cons(p.getB(), f1(n - 1, p.getA()));
        } else {
            return nil();
        }
    }

    // Imperative, time complexity is the same as above
    <T> List<T> f2(int n, List<T> list) {
        List<T> acc = nil();
        while (n > 0) {
            int i = random.nextInt(list.length());
            Pair<List<T>, T> p = removeAt(list, i);
            acc = cons(p.getB(), acc);
            list = p.getA();
            n--;
        }
        return acc;
    }

    // Helper function
    private <T> Pair<List<T>, T> removeAt(List<T> list, int n) {
        Pair<List<T>, List<T>> p = list.splitAt(n - 1);
        List<T> a = p.getA();
        List<T> b = p.getB();
        return pair(concat(a, b.tail()), b.head());
    }
}