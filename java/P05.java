// P05 Reverse a list.

import core.List;

import static core.List.*;

class P05 {
    // "Predefined" function
    <T> List<T> f0(List<T> list) {
        return list.reverse();
    }

    // Recursion (inefficient)
    <T> List<T> f1(List<T> list) {
        return list.isEmpty()
                ? List.<T>nil()
                : concat(f1(list.tail()), singleton(list.head()));
    }
    
    // Tail recursion 
    <T> List<T> f2(List<T> list) {
        return f2_inner(list, List.<T>nil());
    }
    
    private <T> List<T> f2_inner(List<T> list, List<T> acc) {
        return list.isEmpty() 
                ? acc
                : f2_inner(list.tail(), cons(list.head(), acc));
    }
    
    // Imperative
    <T> List<T> f3(List<T> list) {
        List<T> acc = nil();
        for (T each : list) acc = cons(each, acc);
        return acc;
    }
}