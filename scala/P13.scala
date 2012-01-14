// P13 Run-length encoding of a list (direct solution).

// Values factory
def makeValue[T](n: Int, x: T): Any =
  if (n == 1) x else (n, x)

// A simple solution, but there's still some kind of sublists
def f1: List[Any] => List[Any] = {
  case Nil => Nil
  case x :: xs =>
    val (a, b) = xs.span(x ==)
    makeValue(a.length + 1, x) :: f1(b)
}

// Recursion, "look-behind"
def f2: List[Any] => List[Any] = {
  case Nil => Nil
  case x :: xs => toValues(1, x, xs)
}

def toValues(n: Int, x: Any, l: List[Any]): List[Any] = l match {
  case Nil => List(makeValue(n, x))
  case y :: ys => if (y == x) toValues(n + 1, y, ys) else makeValue(n, x) :: toValues(1, y, ys)
}

// With custom data
abstract sealed class Entry[T]
case class Value[T](v: T) extends Entry[T]
case class Sequence[T](n: Int, v: T) extends Entry[T]

// Entries factory
def makeEntry[T](n: Int, x: T): Entry[T] =
  if (n == 1) Value(x) else Sequence(n, x)

// Using "span" 
def f3[T]: List[T] => List[Entry[T]] = {
  case Nil => Nil
  case x :: xs =>
    val (a, b) = xs.span(x ==)
    makeEntry(a.length + 1, x) :: f3(b)
}

// Direct method using custom data
def f4[T]: List[T] => List[Entry[T]] = {
  case Nil => Nil
  case x :: xs => toEntries(1, x, xs)
}

def toEntries[T](n: Int, x: T, l: List[T]): List[Entry[T]] = l match {
  case Nil => List(makeEntry(n, x))
  case y :: ys => if (y == x) toEntries(n + 1, y, ys) else makeEntry(n, x) :: toEntries(1, y, ys)
}