// P01 Find the last element of a list.

// Predefined function
def f0[T](list: List[T]): T = list.last

// Tail recursion
@annotation.tailrec
def f1[T](list: List[T]): T = list match {
  case h :: Nil => h
  case _ :: t => f1(t)
  case _ => throw new NoSuchElementException("List is empty")
}

// Chained calls
def f2[T](list: List[T]): T = list.reverse.head

// Haskell-like function composition, point-free style (looks strange with Scala syntax and OO model)
def f3[T] = ((_: List[T]).head).compose((_: List[T]).reverse)

// Reversed function composition
def f4[T] = ((_: List[T]).reverse).andThen((_: List[T]).head)

// Java-like implementation with side effects
def f5[T](list: List[T]): T = {
  var result: Option[T] = None
  for (each <- list) result = Some(each)
  result.getOrElse(throw new NoSuchElementException("List is empty"))
}

// Folding
def f6[T](list: List[T]): T = if (list.nonEmpty) list.reduce((a, b) => b) else
  throw new NoSuchElementException("List is empty")