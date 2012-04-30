-- P18 Extract a slice from a list.

-- Using "take" and "drop"
f1 :: [a] -> Int -> Int -> [a]
f1 xs i k = drop (pred i) $ take k xs

-- Using "splitAt"
f2 :: [a] -> Int -> Int -> [a]
f2 xs i k = snd $ splitAt (pred i) $ fst $ splitAt k xs

-- Recursion
f3 :: [a] -> Int -> Int -> [a]
f3 [] _ _ = []
f3 (x:xs) i k
    | i > 1 = f3 xs (pred i) (pred k)
    | k > 0 = x : f3 xs 1 (pred k)
    | otherwise = []

-- Tail recursion
f4 :: [a] -> Int -> Int -> [a]
f4 xs i k = reverse $ f [] xs i k
    where f acc [] _ _ = acc
          f acc (x : xs) i k
            | i > 1 = f acc xs (pred i) (pred k)
            | k > 0 = f (x : acc) xs 1 (pred k)
            | otherwise = acc

-- Filter by index
f5 :: [a] -> Int -> Int -> [a]
f5 xs i k = fst $ unzip $ filter ((>=i) . snd) $ zip xs [1..k]

-- List comprehension
f6 :: [a] -> Int -> Int -> [a]
f6 xs i k = [x | (x, n) <- zip xs [1..k], n >= i]

-- Folding
f7 :: [a] -> Int -> Int -> [a]
f7 xs i k = foldr f [] $ zip xs [1..k]
    where f (x, n) acc
            | n >=i = x : acc
            | otherwise = acc