// P10 Run-length encoding of a list.

// Mapping
def f1[T](list: List[List[T]]): List[(Int, T)] =
  list.map(l => (l.length, l.head))

// Mapping with "zip"
def f2[T](list: List[List[T]]): List[(Int, T)] =
  list.map(_.length).zip(list.map(_.head))

// Folding (underlying implementation is recursive)
def f3[T](list: List[List[T]]): List[(Int, T)] =
  list.foldRight(Nil: List[(Int, T)])((x, acc) => (x.length, x.head) :: acc)

// Folding (underlying implementation is iterative)
def f4[T](list: List[List[T]]): List[(Int, T)] =
  list.reverse.foldLeft(Nil: List[(Int, T)])((acc, x) => (x.length, x.head) :: acc)

// Recursion
def f5[T](list: List[List[T]]): List[(Int, T)] = list match {
  case Nil => Nil
  case h :: t => (h.length, h.head) :: f5(t)
}

// Tail recursion
@annotation.tailrec
def f6[T](list: List[List[T]], acc: List[(Int, T)] = Nil): List[(Int, T)] = list match {
  case Nil => acc.reverse
  case h :: t => f6(t,  (h.length, h.head) :: acc)
}