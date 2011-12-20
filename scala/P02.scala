// P02 Find the last but one element of a list.

// Tail recursion
@annotation.tailrec
def f1[T](list: List[T]): T = list match {
  case Nil => throw new NoSuchElementException("List is empty")
  case List(_) => throw new NoSuchElementException("Sigleton list")
  case List(x, _) => x
  case _ :: xs => f1(xs)
}

// Function application
def f2[T](list: List[T]): T = list.init.last

// With errors check
def f3[T](list: List[T]): T = list.init.lastOption.getOrElse(throw new NoSuchElementException())

// Function composition
def f4[T] = ((_: List[T]).last).compose((_: List[T]).init)

// Using index
def f5[T](list: List[T]): T = list.reverse(1)

// With partial function lifting
def f6[T](list: List[T]): T = list.reverse.lift(1).getOrElse(throw new NoSuchElementException())