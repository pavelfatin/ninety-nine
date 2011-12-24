// P09 Pack consecutive duplicates of list elements into sublists.

import core.List;

import static core.List.*;

class P09 {
    // Iteration
    <T> List<List<T>> f1(List<T> list) {
        if (list.isEmpty()) return nil();

        List<List<T>> result = nil();
        List<T> value = nil();
        for (T each : list) {
            if (value.isEmpty() || value.head() == each) {
                value = cons(each, value);
            } else {
                result = cons(value, result);
                value = singleton(each);
            }
        }
        
        return result.reverse();
    }
}