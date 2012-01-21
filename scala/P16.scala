// P16 Drop every N'th element from a list.

// Recursion
def f1[T](n: Int, list: List[T]): List[T] = {
  def f[T]: (Int, List[T]) => List[T] = {
    case (_, Nil) => Nil
    case (1, _ :: xs) => f(n, xs)
    case (k, x :: xs) => x :: f(k - 1, xs)
  }
  f(n, list)
}

// Tail recursion
def f2[T](n: Int, list: List[T]): List[T] = {
  @annotation.tailrec
  def f[T](k: Int, acc: List[T], l: List[T]): List[T] = (k, l) match {
    case (_, Nil) => acc.reverse
    case (1, _ :: xs) => f(n, acc, xs)
    case (k, x :: xs) => f(k - 1, x :: acc, xs)
  }
  f(n, Nil, list)
}

// Recursion with "take" and "drop"
def f3[T](n: Int, list: List[T]): List[T] =
  if (list.nonEmpty) list.take(n - 1) ::: f3(n, list.drop(n)) else Nil

// Zip with cycle, filter, map
def f4[T](n: Int, list: List[T]): List[T] = {
  val cycle = Stream.iterate(1)(it => if (it < n) it + 1 else 1)
  list.zip(cycle).filter(_._2 < n).map(_._1)
}

// Using "for comprehensions"
def f5[T](n: Int, list: List[T]): List[T] = {
  val cycle = Stream.iterate(1)(it => if (it < n) it + 1 else 1)
  for((x, k) <- list.zip(cycle) if k < n) yield x
}

// ZipWithIndex and modulo
def f6[T](n: Int, list: List[T]): List[T] =
  list.zipWithIndex.filter(it => (it._2 + 1) % n > 0).map(_._1)

// Imperative
def f7[T](n: Int, list: List[T]): List[T] = {
  var acc: List[T] = Nil
  var k = 1
  for (it <- list) {
    if (k < n) { 
      acc ::= it
      k += 1
    } else {
      k = 1
    }
  }
  acc.reverse
}