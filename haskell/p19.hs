-- P19 Rotate a list N places to the left.

-- Using "splitAt"
f1 :: Int -> [a] -> [a]
f1 _ [] = []
f1 n xs = let (a, b) = splitAt (mod n $ length xs) xs in b ++ a

-- Without using "let"
f2 :: Int -> [a] -> [a]
f2 _ [] = []
f2 n xs = uncurry (flip (++)) $ splitAt (mod n $ length xs) xs

-- Tail recursion
f3 :: Int -> [a] -> [a]
f3 _ [] = []
f3 0 xs = xs
f3 n xs
    | n > 0 = f3 (pred n) (tail xs ++ [head xs])
    | otherwise = f3 (succ n) (last xs : init xs)