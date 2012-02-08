// P17 Split a list into two parts; the length of the first part is given.

// Using predefined function
def f1[T](n: Int, xs: List[T]): (List[T], List[T]) =
  xs.splitAt(n)

// Using "take" and "drop"
def f2[T](n: Int, xs: List[T]): (List[T], List[T]) =
  (xs.take(n), xs.drop(n))

// Recursion with a counter
def f3[T]: (Int, List[T]) => (List[T], List[T]) = {
  case (_, Nil) => (Nil, Nil)
  case (0, xs) => (Nil, xs)
  case (n, x :: xs) =>
    val (a, b) = f3(n - 1, xs)
    (x :: a, b)
}

// Tail recursion with a counter
@annotation.tailrec
def f4[T](n: Int, xs: List[T], acc: List[T] = Nil): (List[T], List[T]) = (n, xs) match {
  case (_, Nil) => (acc.reverse, Nil)
  case (0, xs) => (acc.reverse, xs)
  case (n, x :: xs) => f4(n - 1, xs, x :: acc)
}