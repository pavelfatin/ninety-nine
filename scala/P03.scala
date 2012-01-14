// P03 Find the Kth element of a list.

// Tail recursion
@annotation.tailrec
def f1[T](list: List[T], n: Int): T = list match {
  case Nil => throw new IndexOutOfBoundsException()
  case h :: t =>
    if (n < 1) throw new IndexOutOfBoundsException()
    if (n == 1) h else f1(t, n - 1)
}

// Calls chain
def f2[T](list: List[T], n: Int): T = list.drop(n - 1).head

// Using index
def f3[T](list: List[T], n: Int): T = list(n - 1)

// With error reporting
def f4[T](list: List[T], n: Int): T = list.lift(n - 1).getOrElse(throw new IndexOutOfBoundsException())