// P04 Find the number of elements of a list.

// Predefined function
def f0[T](list: List[T]): Int = list.length

// Recursion
def f1[T](list: List[T]): Int = list match {
  case Nil => 0
  case _ :: t => 1 + f1(t)
}

// Tail recursion
@annotation.tailrec
def f2[T](list: List[T], n: Int = 0): Int = list match {
  case Nil => n
  case _ :: t => f2(t, n + 1)
}

// Folding
def f3[T](list: List[T]): Int = list.foldLeft(0)((a, _) => a + 1)

// Using build-in 'sum'
def f4[T](list: List[T]): Int = list.map(_ => 1).sum

// With 'view' to avoid the creation of a temporary list
def f5[T](list: List[T]): Int = list.view.map(_ => 1).sum