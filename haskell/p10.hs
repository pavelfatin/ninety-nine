-- P10 Run-length encoding of a list.

module P10 where

-- Mapping
f1 :: [[a]] -> [(Int, a)]
f1 = map (\x -> (length x, head x))

-- Mapping with "zip"
f2 :: [[a]] -> [(Int, a)]
f2 xs = zip (map length xs) (map head xs)

-- Folding
f3 :: [[a]] -> [(Int, a)]
f3 = foldr (\x acc -> (length x, head x) : acc) []

-- Recursion
f4 :: [[a]] -> [(Int, a)]
f4 [] = []
f4 (x:xs) = (length x, head x) : f4 xs

-- Tail recursion
f5 :: [[a]] -> [(Int, a)]
f5 = f5' []
    where f5' acc [] = reverse acc
          f5' acc (x:xs) = f5' ((length x, head x) : acc) xs