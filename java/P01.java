// P01 Find the last element of a list.

import core.List;
import static core.List.*;

import java.util.NoSuchElementException;

class P01 {
    // "Predefined" function
    <T> T f0(List<T> list) {
        return list.last();
    }    
    
    // The fastest (but verbose) version
    <T> T f1(List<T> list) {
        if (list.isEmpty()) throw new NoSuchElementException("List is empty");
        List<T> elements = list.tail();
        List<T> result = list;
        while (elements.nonEmpty()) {
            result = elements;
            elements = elements.tail();
        }
        return result.head();
    }

    // Instantiates an iterator to enumerate elements (CPU and GC overhead)
    <T> T f2(List<T> list) {
        if (list.isEmpty()) throw new NoSuchElementException("List is empty");
        T result = null;
        for (T each : list)
            result = each;
        return result;
    }

    // Uses (tail) recursion (can produce stack overflow errors in Java)
    <T> T f3(List<T> list) {
        if (list.isEmpty()) throw new NoSuchElementException("List is empty");
        return f3_inner(list);
    }

    private <T> T f3_inner(List<T> list) {
        List<T> tail = list.tail();
        return tail.isEmpty() ? list.head() : f3(tail);
    }
}