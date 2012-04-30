// P08 Eliminate consecutive duplicates of list elements.

// Recursion with "dropWhile"
def f1[T]: List[T] => List[T] = {
  case Nil => Nil
  case h :: t => h :: f1(t.dropWhile(h ==))
}

// Tail recursion with "dropWhile"
@annotation.tailrec
def f2[T](list: List[T], acc: List[T] = Nil): List[T] = list match {
  case Nil => acc.reverse
  case h :: t => f2(t.dropWhile(h ==), h :: acc)
}

// Recursion with pattern matching
def f3[T]: List[T] => List[T] = {
  case a :: (bs@(b :: _)) => if (a == b) f3(bs) else a :: f3(bs)
  case xs => xs
}

// Folding
def f4[T]: List[T] => List[T] = {
  case Nil => Nil
  case l => l.foldRight(List(l.last))((b, a) => if (a.head == b) a else b :: a)
}

// Using "zip"
def f5[T]: List[T] => List[T] = {
  case Nil => Nil
  case xs@(x :: _) => x :: xs.zip(xs.tail).filter(p => p._1 != p._2).map(_._2)
}