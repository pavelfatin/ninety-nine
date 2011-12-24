-- P08 Eliminate consecutive duplicates of list elements.

module P08 where

import Data.List

-- Built-in functions composition
f1 :: Eq a => [a] -> [a]
f1 = map head . group

-- Recursion with dropWhile
f2 :: Eq a => [a] -> [a]
f2 [] = []
f2 (x:xs) = x : (f2 $ dropWhile (== x) xs)

-- Recursion with pattern matching (look-ahead)
f3 :: Eq a => [a] -> [a]
f3 (a:(bs@(b:_)))
    | a == b = f3 bs
    | otherwise = a : f3 bs
f3 xs = xs

-- Tail recursion (look-behind)
f4 :: Eq a => [a] -> [a]
f4 = f4' []
    where f4' acc [] = reverse acc
          f4' [] (x:xs) = f4' [x] xs
          f4' ys@(y:_) (x:xs) = if y == x then f4' ys xs else f4' (x : ys) xs

-- List folding
f5 :: Eq a => [a] -> [a]
f5 [] = []
f5 xs = foldr (\a b -> if a == (head b) then b else a : b) [last xs] xs

-- Using "zip"
f6 :: Eq a => [a] -> [a]
f6 [] = []
f6 xs@(x:_) = x : map snd (filter (uncurry (/=)) (zip xs (tail xs)))