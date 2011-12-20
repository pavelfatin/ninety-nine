-- P05 Reverse a list.

module P05 where

-- Predefined function
f0 :: [a] -> [a]
f0 = reverse

-- Recursion (inefficient)
f1 :: [a] -> [a]
f1 [] = []
f1 (x:xs) = f1 xs ++ [x]

-- Tail recursion
f2 :: [a] -> [a]
f2 xs = f2' xs []
 where f2' :: [a] -> [a] -> [a]
       f2' [] acc = acc
       f2' (x:xs) acc = f2' xs (x:acc)

-- Folding
f3 :: [a] -> [a]
f3 = foldl (flip (:)) []