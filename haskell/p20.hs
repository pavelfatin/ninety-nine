-- Remove the K'th element from a list.

-- Using "splitAt"
f1 :: Int -> [a] -> ([a], a)
f1 n xs = let (a, x:b) = splitAt (pred n) xs in (a ++ b, x)

-- By index (inefficient)
f2 :: Int -> [a] -> ([a], a)
f2 n xs = (take (pred n) xs ++ drop n xs, xs !! (pred n))

-- Recursion
f3 :: Int -> [a] -> ([a], a)
f3 n (x:xs)
 | n > 1 = let (a, b) = f3 (pred n) xs in (x : a, b)
 | otherwise = (xs, x)

-- Tail recursion
f4 :: Int -> [a] -> ([a], a)
f4 = f []
    where f acc n (x:xs)
            | n > 1 = f (x : acc) (pred n) xs
            | otherwise = (reverse acc ++ xs, x)