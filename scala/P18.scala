// P18 Extract a slice from a list.

// Using "take" and "drop"
def f1[T](list: List[T], i: Int, k: Int): List[T] =
  list.take(k).drop(i - 1)

// Using "splitAt"
def f2[T](list: List[T], i: Int, k: Int): List[T] =
  list.splitAt(k)._1.splitAt(i - 1)._2

// Recursion
def f3[T](list: List[T], i: Int, k: Int): List[T] = {
  list match {
    case Nil => Nil
    case x :: xs =>
      if (i > 1)
        f3(xs, i - 1, k - 1)
      else if (k > 0)
        x :: f3(xs, 1, k - 1)
      else Nil
  }
}

// Tail recursion
@annotation.tailrec
def f4[T](list: List[T], i: Int, k: Int, acc: List[T] = Nil): List[T] = {
  list match {
    case Nil => acc.reverse
    case x :: xs =>
      if (i > 1)
        f4(xs, i - 1, k - 1, acc)
      else if (k > 0)
        f4(xs, 1, k - 1, x :: acc)
      else acc.reverse
  }
}

// Filter by index
def f5[T](list: List[T], i: Int, k: Int): List[T] =
  list.zip(1 to k).filter(_._2 >= i).unzip._1

// Using for comprehension
def f6[T](list: List[T], i: Int, k: Int): List[T] =
  for ((x, n) <- list.zip(1 to k) if n >= i) yield x

// Folding
def f7[T](list: List[T], i: Int, k: Int): List[T] = {
  list.zip(1 to k).foldRight(Nil: List[T]) {
    case ((x, n), acc) => if (n >= i) x :: acc else acc
  }
}