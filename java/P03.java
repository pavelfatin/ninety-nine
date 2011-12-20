// P03 Find the Kth element of a list.

import core.List;

import static core.List.*;

class P03 {
    // Recursion
    <T> T f1(List<T> list, int n) {
        if (list.isEmpty()) throw new IndexOutOfBoundsException();
        if (n < 1) throw new IndexOutOfBoundsException();
        return n == 1 ? list.head() : f1(list.tail(), n - 1);
    }

    // Calls chain
    <T> T f2(List<T> list, int n) {
        return list.drop(n - 1).head();
    }

    // Using index
    <T> T f3(List<T> list, int n) {
        return list.get(n - 1);
    }
}