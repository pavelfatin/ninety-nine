// P14 Duplicate the elements of a list.

// Recursion
def f1[T]: List[T] => List[T] = {
  case Nil => Nil
  case x :: xs => x :: x :: f1(xs)
}

// Direct tail recursion (inefficient)
@annotation.tailrec
def f2[T](list: List[T], acc: List[T] = Nil): List[T] = list match {
  case Nil => acc
  case x :: xs => f2(xs, acc ::: List(x, x))
}

// Tail recursion with "reverse"
@annotation.tailrec
def f3[T](list: List[T], acc: List[T] = Nil): List[T] = list match {
  case Nil => acc.reverse
  case x :: xs => f3(xs, x :: x :: acc)
}

// Right folding
def f4[T](list: List[T]): List[T] =
  list.foldRight(Nil: List[T])((x, xs) => x :: x :: xs)

// Direct left folding (inefficient)
def f5[T](list: List[T]): List[T] =
  list.foldLeft(Nil: List[T])((xs, x) => xs ::: List(x, x))

// Left folding with reverse
def f6[T](list: List[T]): List[T] =
  list.foldLeft(Nil: List[T])((xs, x) => x :: x :: xs).reverse

// Map then flatten
def f7[T](list: List[T]): List[T] =
  list.map(List.fill(2)(_)).flatten

// Using flatMap
def f8[T](list: List[T]): List[T] =
  list.flatMap(List.fill(2)(_))