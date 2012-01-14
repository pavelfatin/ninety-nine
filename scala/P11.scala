// P11 Modified run-length encoding.

// List of objects
def f1[T](list: List[(Int, T)]): List[Any] = list.map {
  case (1, x) => x
  case it => it
}

// With custom data
abstract sealed class Entry[T]
case class Value[T](v: T) extends Entry[T]
case class Sequence[T](n: Int, v: T) extends Entry[T]

def f2[T](list: List[(Int, T)]): List[Entry[T]] = list.map {
  case (1, x) => Value(x)
  case (n, x) => Sequence(n, x)
}