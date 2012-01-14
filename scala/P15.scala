// P15 Replicate the elements of a list a given number of times.

// Flat map with replication
def f1[T](n: Int, list: List[T]) = 
  list.flatMap(List.fill(n)(_))

// One-pass concatenation
def f2[T](n: Int, list: List[T]) =
  list.foldRight(Nil: List[T])(prepend(n, _, _))

def prepend[T](n: Int, x: T, xs: List[T]): List[T] =
  if (n == 0) xs else x :: prepend(n - 1, x, xs)