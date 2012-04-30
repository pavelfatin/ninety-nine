// P19 Rotate a list N places to the left.

// Using "splitAt"
def f1[T](list: List[T], n: Int): List[T] = {
  val l = list.size
  val i = if (list.nonEmpty) n % l else 0
  val (a, b) = list.splitAt(if (i < 0) l + i else i)
  b ::: a
}

// Tail recursion
@annotation.tailrec
def f2[T](list: List[T], n: Int): List[T] = (list, n) match {
  case (Nil, _) => Nil
  case (xs, 0) => xs
  case (xs, n) =>
    if (n > 0)
      f2(xs.tail ::: List(xs.head), n - 1)
    else
      f2(xs.last :: xs.init, n + 1)
}