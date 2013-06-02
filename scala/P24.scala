// P24 Lotto: Draw N different random numbers from the set 1..M.

import util.Random

// The obvious answer is P23.f1(n, (1 to m).toList)
// Let's use "distinct" for a different solution
def f1[T](n: Int, m: Int): List[Int] =
  Stream.continually(1 + Random.nextInt(m)).distinct.take(n).toList