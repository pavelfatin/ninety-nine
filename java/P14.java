// P14 Duplicate the elements of a list.

import core.List;

import static core.List.*;

class P14 {
    // Recursion
    <T> List<T> f1(List<T> list) {
        return list.isEmpty() 
                ? List.<T>nil()
                : cons(list.head(), cons(list.head(), f1(list.tail())));
    }
    
    // Direct tail recursion (inefficient)
    <T> List<T> f2(List<T> list) {
        return f2_inner(List.<T>nil(), list);
    }
    
    private <T> List<T> f2_inner(List<T> acc, List<T> list) {
        return list.isEmpty() 
                ? acc
                : f2_inner(concat(acc, replicate(2, list.head())), list.tail());
    }

    // Tail recursion with "reverse"
    <T> List<T> f3(List<T> list) {
        return f3_inner(List.<T>nil(), list);
    }

    private <T> List<T> f3_inner(List<T> acc, List<T> list) {
        return list.isEmpty()
                ? acc.reverse()
                : f3_inner(cons(list.head(), cons(list.head(), acc)), list.tail());
    }

    // Imperative
    <T> List<T> f4(List<T> list) {
        List<T> acc = nil();
        for (T each : list) acc = cons(each, cons(each, acc));
        return acc.reverse();
    }
}