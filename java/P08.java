// P08 Eliminate consecutive duplicates of list elements.

import core.List;

import static core.List.*;

class P08 {
    // Recursion
    <T> List<T> f1(List<T> list) {
        if (list.nonEmpty() && list.tail().nonEmpty()) {
            T a = list.head();
            T b = list.tail().head();
            List<T> t = list.tail();
            return a == b ? f1(t) : cons(a, f1(t));
        } else {
            return list;
        }
    }
    
    // Iteration
    <T> List<T> f2(List<T> list) {
        List<T> result = nil();
        T previous = null;
        boolean first = true;
        for (T each : list) {
            if (first) {
                result = cons(each, result);
                first = false;
            } else if (each != previous) {
                result = cons(each, result);
            }
            previous = each;
        }

        return result.reverse();
    }
}