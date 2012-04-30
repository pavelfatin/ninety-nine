// P06 Find out whether a list is a palindrome.
//     A palindrome can be read forward or backward; e.g. (x a m a x).

// Recursion (inefficient)
def f1[T]: List[T] => Boolean = {
  case Nil => true
  case _ :: Nil => true
  case xs => xs.head == xs.last && f1(xs.tail.init)
}

// Builtin functions
def f2[T](list: List[T]): Boolean = list == list.reverse

// Zip
def f3[T](list: List[T]): Boolean =
  list.zip(list.reverse).forall{case (a, b) => a == b}

// Zip again
def f4[T](list: List[T]): Boolean =
  list.zip(list.reverse).forall(((_: T) == (_: T)).tupled)

// Zip with folding
def f5[T](list: List[T]): Boolean =
  list.zip(list.reverse)
    .map{case (a, b) => a == b}
    .foldLeft(true)(_ && _)