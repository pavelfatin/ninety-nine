-- P17 Split a list into two parts; the length of the first part is given.

-- Using predefined function
f1 :: Int -> [a] -> ([a], [a])
f1 = splitAt

-- Using "take" and "drop"
f2 :: Int -> [a] -> ([a], [a])
f2 n xs = (take n xs, drop n xs)

-- Recursion with a counter
f3 :: Int -> [a] -> ([a], [a])
f3 _ [] = ([], [])
f3 0 xs = ([], xs)
f3 n (x:xs) = let (a, b) = f3 (pred n) xs in (x : a, b)

-- Tail recursion with a counter
f4 :: Int -> [a] -> ([a], [a])
f4 = f []
    where f acc _ [] = (reverse acc, [])
          f acc 0 xs = (reverse acc, xs)
          f acc n (x:xs) = f (x : acc) (pred n) xs