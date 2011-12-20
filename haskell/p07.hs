-- P07 Flatten a nested list structure.

module P07 where

data NestedList a = Value a | List [NestedList a]

-- Recursion
f1 :: NestedList a -> [a]
f1 (Value a) = [a]
f1 (List []) = []
f1 (List (x:xs)) = (f1 x) ++ f1(List xs)

-- Using concatMap
f2 :: NestedList a -> [a]
f2 (Value a) = [a]
f2 (List xs) = concatMap f2 xs