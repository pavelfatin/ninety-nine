// P21 Insert an element at a given position into a list.

// Using "splitAt"
def f1[T](list: List[T], n: Int, x: T): List[T] = {
  val (a, b) = list.splitAt(n - 1)
  (a ::: x :: b)
}

// By index (inefficient)
def f2[T](list: List[T], n: Int, x: T): List[T] =
  list.take(n - 1) ::: x :: list.drop(n - 1)

// Recursion
def f3[T](list: List[T], n: Int, x: T): List[T] =
  if (n == 1) x :: list else list.head :: f3(list.tail, n - 1, x)

// Tail recursion
@annotation.tailrec
def f4[T](list: List[T], n: Int, x: T, acc: List[T] = Nil): List[T] =
  if (n == 1) acc.reverse ::: x :: list else f4(list.tail, n - 1, x, list.head :: acc)

// Imperative
def f5[T](list: List[T], n: Int, x: T, acc: List[T] = Nil): List[T] = {
  var result: List[T] = Nil
  var i = 0
  for (each <- list) {
    i += 1
    result = if (i == 1) x :: each :: result else each :: result
  }
  result.reverse
}