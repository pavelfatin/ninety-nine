// P07 Flatten a nested list structure.

// flatMap with recursion, unchecked
def f1(list: List[Any]): List[Any] = list flatMap {
  case xs: List[_] => f1(xs)
  case v => List(v)
}

// With custom data
abstract sealed class NestedList[T]
case class Value[T](v: T) extends NestedList[T]
case class Sequence[T](list: List[NestedList[T]]) extends NestedList[T]

def f2[T]: NestedList[T] => List[T] = {
  case Value(v) => List(v)
  case Sequence(list) => list.flatMap(f2)
}