-- P09 Pack consecutive duplicates of list elements into sublists.

module P09 where

import Data.List

-- Built-in function
f0 :: Eq a => [a] -> [[a]]
f0 = group

-- Recursion with "span"
f1 :: Eq a => [a] -> [[a]]
f1 [] = []
f1 (x:xs) = let (a, b) = span (== x) xs in (x : a) : f1 b