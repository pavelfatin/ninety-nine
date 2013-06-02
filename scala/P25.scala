// P25 Generate a random permutation of the elements of a list.

import util.Random

// The obvious answer is P23.f1(list.length, list)
// Let's directly select a random permutation for a different implementation
def f1[T](list: List[T]): List[T] = {
  val all = list.permutations.toList
  all(Random.nextInt(all.length))
}