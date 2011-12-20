// P04 Find the number of elements of a list.

import core.List;

import static core.List.*;

class P04 {
    // "Predefined" function
    <T> int f0(List<T> list) {
        return list.length();
    }

    // Recursion
    <T> int f1(List<T> list) {
        return list.isEmpty() ? 0 : 1 + f1(list.tail());  
    }

    // Tail recursion
    <T> int f2(List<T> list) {
        return f2_inner(list, 0);
    }

    private <T> int f2_inner(List<T> list, int n) {
        return list.isEmpty() ? n : f2_inner(list.tail(), n + 1);
    }

    // Iteration
    <T> int f3(List<T> list) {
        int n = 0;
        for (T x : list) n++;
        return n;
    }
}