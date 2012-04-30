-- P21 Insert an element at a given position into a list.

-- Using "splitAt"
f1 :: Int -> a -> [a] -> [a]
f1 n x ys = let (a, b) = splitAt (pred n) ys in a ++ x : b

-- By index (inefficient)
f2 :: Int -> a -> [a] -> [a]
f2 n x ys = take (pred n) ys ++ x : drop (pred n) ys

-- Recursion
f3 :: Int -> a -> [a] -> [a]
f3 1 x ys = x : ys
f3 n x (y:ys) = y : f3 (pred n) x ys

-- Tail recursion
f4 :: Int -> a -> [a] -> [a]
f4 = f []
    where f acc 1 x ys = reverse acc ++ x : ys
          f acc n x (y:ys) = f (y:acc) (pred n) x ys