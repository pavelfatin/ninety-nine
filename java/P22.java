// P22 Create a list containing all integers within a given range.

import core.List;

import static core.List.cons;
import static core.List.nil;

class P22 {
    // Recursion
    List<Integer> f1(int a, int b) {
        return a <= b ? cons(a, f1(a + 1, b)) : List.<Integer>nil();
    }

    // Tail recursion
    List<Integer> f2(int a, int b) {
        return f2_inner(a, b, List.<Integer>nil());
    }

    private List<Integer> f2_inner(int a, int b, List<Integer> acc) {
        return b >= a ? f2_inner(a, b - 1, cons(b, acc)) : acc;
    }

    // Imperative
    List<Integer> f3(int a, int b) {
        int i = b;
        List<Integer> result = nil();
        while (i >= a) {
            result = cons(i, result);
            i--;
        }
        return result;
    }
}