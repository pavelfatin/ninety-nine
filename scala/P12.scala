// P12 Decode a run-length encoded list.

// List of objects
def f1(list: List[Any]): List[Any] = list.flatMap {
  case (n: Int, x) => List.fill(n)(x)
  case x => x :: Nil
}

// With custom data
abstract sealed class Entry[T]
case class Value[T](v: T) extends Entry[T]
case class Sequence[T](n: Int, v: T) extends Entry[T]

def f2[T](list: List[Entry[T]]): List[T] = list.flatMap {
  case Value(v) => v :: Nil
  case Sequence(n, v) => List.fill(n)(v)
}