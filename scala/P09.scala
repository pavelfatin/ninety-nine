// P09 Pack consecutive duplicates of list elements into sublists.

// Recursion with "span"
def f1[T](list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case h :: t =>
    val (a, b) = t.span(h ==)
    (h :: a) :: f1(b)
}