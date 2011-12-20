// P06 Find out whether a list is a palindrome.
//     A palindrome can be read forward or backward; e.g. (x a m a x).

import core.List;

import static core.List.*;

class P06 {
    // Builtin functions
    <T> boolean f1(List<T> list) {
        return list.equals(list.reverse());
    }

    // Recursion (inefficient)
    <T> boolean f2(List<T> list) {
        return list.isEmpty() || list.tail().isEmpty() ||
                (list.head() == list.last() && f2(list.tail().init()));
    }
}