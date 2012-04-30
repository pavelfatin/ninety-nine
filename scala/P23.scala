import util.Random

// P23 Extract a given number of randomly selected elements from a list.

// Building a target list while removing items from the source (recursively)
// Time complexity is O(n^2) in worst and average cases, O(n) - in best case
def f1[T](n: Int, list: List[T]): List[T] = {
  if (n > 0) {
    val (xs, x) = removeAt(list, Random.nextInt(list.size))
    x :: f1(n - 1, xs)
  } else {
    Nil
  }
}

// Helper function
def removeAt[T](list: List[T], n: Int): (List[T], T) = {
  val (a, x :: b) = list.splitAt(n - 1)
  (a ::: b, x)
}