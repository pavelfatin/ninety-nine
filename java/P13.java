// P13 Run-length encoding of a list (direct solution).

import core.List;

import static core.List.*;
import static core.Pair.*;

class P13 {
    // Imperative, list of objects
    @SuppressWarnings("unchecked")
    List f1(List list) {
        if (list.isEmpty()) return nil();

        List acc = nil();
        Object x = list.head();
        int n = 1;

        for (Object each : list.tail()) {
            if (each.equals(x)) {
                n++;
            } else {
                acc = cons(makeValue(n, x), acc);
                x = each;
                n = 1;
            }
        }

        acc = cons(makeValue(n, x), acc);

        return acc.reverse();
    }

    // Factory method
    private Object makeValue(int n, Object x) {
        return n == 1 ? x : pair(n, x);
    }
}