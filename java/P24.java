// P24 Lotto: Draw N different random numbers from the set 1..M.

import core.List;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static core.List.*;

class P24 {
    private final Random random = new Random();

    // The obvious answer is P23.f1(n, range(1, m))
    // Let's use a Set with distinct values for a different solution
    List<Integer> f1(int n, int m) {
        List<Integer> result = nil();

        Set<Integer> buffer = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            int x;
            do {
                x = 1 + random.nextInt(m);
            } while (buffer.contains(x));

            buffer.add(x);
            result = cons(x, result);
        }

        return result;
    }
}