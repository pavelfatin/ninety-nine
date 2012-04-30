// P20 Remove the K'th element from a list.

// Using "splitAt"
def f1[T](list: List[T], n: Int): (List[T], T) = {
  val (a, x :: b) = list.splitAt(n - 1)
  (a ::: b, x)
}

// By index (inefficient)
def f2[T](list: List[T], n: Int): (List[T], T) =
  (list.take(n - 1) ::: list.drop(n), list(n - 1))

// Recursion
def f3[T](list: List[T], n: Int): (List[T], T) = {
  val h :: t = list
  if (n > 1) {
    val (a, b) = f3(t, n - 1)
    (h :: a, b)
  } else {
    (t, h)
  }
}

// Tail recursion
@annotation.tailrec
def f4[T](list: List[T], n: Int, acc: List[T] = Nil): (List[T], T) = {
  val h :: t = list
  if (n > 1) f4(t, n - 1, h :: acc) else (acc.reverse ::: t, h)
}