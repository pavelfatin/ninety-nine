// P07 Flatten a nested list structure.

import core.List;

import static core.List.*;

class P07 {
    // Recursion, unchecked
    @SuppressWarnings("unchecked")
    List f1(List list) {
        if (list.isEmpty()) return nil();
        Object h = list.head();
        List t = list.tail();
        return h instanceof List ? concat(f1((List) h), f1(t)) : cons(h, f1(t));
    }
}