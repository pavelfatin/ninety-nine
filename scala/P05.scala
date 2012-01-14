// P05 Reverse a list.

// Predefined function
def f0[T](list: List[T]): List[T] = list.reverse

// Recursion (inefficient)
def f1[T]: List[T] => List[T] = {
  case Nil => Nil
  case h :: t => f1(t) ::: h :: Nil
}

// Tail recursion
@annotation.tailrec
def f2[T](list: List[T], acc: List[T] = Nil): List[T] = list match {
  case Nil => acc
  case h :: t => f2(t, h :: acc)
}

// Folding
def f3[T](list: List[T]): List[T] =
  list.foldLeft(Nil: List[T])((a, b) => b :: a)