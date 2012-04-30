-- P22 Create a list containing all integers within a given range.

import Data.List

-- Predefined function
f1 :: Int -> Int -> [Int]
f1 = enumFromTo

-- Range syntax
f2 :: Int -> Int -> [Int]
f2 a b = [a..b]

-- A part of an infinite list
f3 :: Int -> Int -> [Int]
f3 a b = take (succ b - a) $ iterate succ a

-- Unfolding
f4 :: Int -> Int -> [Int]
f4 a b = unfoldr (\n -> if (n <= b) then Just (n, succ (n)) else Nothing) a

-- As a sum
f5 :: Int -> Int -> [Int]
f5 a b = scanl (+) a $ replicate (b - a) 1

-- Recursion
f6 :: Int -> Int -> [Int]
f6 a b
 | a <= b = a : f6 (succ a) b
 | otherwise = []

-- Tail recursion
f7 :: Int -> Int -> [Int]
f7 = f []
    where f acc a b
            | b >= a = f (b : acc) a (pred b)
            | otherwise = acc