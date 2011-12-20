-- P03 Find the Kth element of a list.

module P03 where

-- Tail recursion
f1 :: [a] -> Int -> a
f1 [] _ = error "Index out of bound"
f1 (x:_) 1 = x
f1 (_:xs) n
    | n < 1 = error "Index out of bound"
    | otherwise = f1 xs (n - 1)

-- Function application
f2 :: [a] -> Int -> a
f2 xs n = head $ drop (n - 1) xs

-- Function composition
f3 :: [a] -> Int -> a
f3 xs n = last . take n $ xs

-- Using index
f4 :: [a] -> Int -> a
f4 xs n = xs !! (n - 1)