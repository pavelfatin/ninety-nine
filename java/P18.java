// P18 Extract a slice from a list.

import core.List;

import static core.List.cons;
import static core.List.listOfChars;
import static core.List.nil;

class P18 {
    // Using "take" and "drop"
    <T> List<T> f1(List<T> list, int i, int k) {
        return list.take(k).drop(i - 1);
    }

    // Using "splitAt"
    <T> List<T> f2(List<T> list, int i, int k) {
        return list.splitAt(k).getA().splitAt(i - 1).getB();
    }

    // Recursion
    <T> List<T> f3(List<T> list, int i, int k) {
        if (list.isEmpty()) {
            return nil();
        } else {
            if (i > 1) {
                return f3(list.tail(), i - 1, k - 1);
            } else {
                if (k > 0) {
                    return cons(list.head(), f3(list.tail(), 1, k - 1));
                } else {
                    return nil();
                }
            }
        }
    }

    // Tail recursion
    <T> List<T> f4(List<T> list, int i, int k) {
        return f4_inner(list, i, k, List.<T>nil()).reverse();
    }

    private <T> List<T> f4_inner(List<T> list, int i, int k, List<T> acc) {
        if (list.isEmpty()) {
            return acc;
        } else {
            if (i > 1) {
                return f4_inner(list.tail(), i - 1, k - 1, acc);
            } else {
                if (k > 0) {
                    return f4_inner(list.tail(), 1, k - 1, cons(list.head(), acc));
                } else {
                    return acc;
                }
            }
        }
    }

    // Filter by index (imperative style)
    <T> List<T> f5(List<T> list, int i, int k) {
        int n = 1;
        List<T> result = nil();
        for (T each : list) {
            if (n > k) break;
            if (n >= i) result = cons(each, result);
            n++;
        }
        return result.reverse();
    }
}