-- P04 Find the number of elements of a list.

module P04 where

-- Predefined function
f0 :: [a] -> Int
f0 = length

-- Recursion
f1 :: [a] -> Int
f1 [] = 0
f1 (_:xs) = 1 + f1 xs

-- Tail recursion
f2 :: [a] -> Int
f2 = f2' 0
    where f2' :: Int -> [a] -> Int
          f2' n [] = n
          f2' n (_:xs) = f2' (n + 1) xs

-- Folding
f3 :: [a] -> Int
f3 xs = foldl (\a _ -> a + 1) 0 xs

-- Folding with function composition
f4 :: [a] -> Int
f4 = foldr (const (+1)) 0

-- Using build-in 'sum'
f5 :: [a] -> Int
f5 = sum . map (const 1)