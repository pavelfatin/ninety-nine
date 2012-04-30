// P22 Create a list containing all integers within a given range.

// Through predefined "Range"
def f1(a: Int, b: Int): List[Int] =
  (a to b).toList

// A part of an infinite list
def f2(a: Int, b: Int): List[Int] =
  Stream.iterate(a)(1 +).take(b - a + 1).toList

// As a sum
def f3(a: Int, b: Int): List[Int] =
  List.fill(b - a)(1).scan(a)(_ + _)

// Recursion
def f4(a: Int, b: Int): List[Int] =
  if (a <= b) a :: f4(a + 1, b) else Nil

// Tail recursion
@annotation.tailrec
def f5(a: Int, b: Int, acc: List[Int] = Nil): List[Int] =
  if (b >= a) f5(a, b - 1, b :: acc) else acc

// Imperative
def f6(a: Int, b: Int): List[Int] = {
  var i = b
  var result: List[Int] = Nil
  while (i >= a) {
    result ::= i
    i -= 1
  }
  result
}