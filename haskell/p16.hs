-- P16 Drop every N'th element from a list.

-- Recursion with a counter
f1 :: Int -> [a] -> [a]
f1 n = f n
    where f _ [] = []
          f 1 (_:xs) = f n xs
          f k (x:xs) = x : f (pred k) xs

-- Tail recursion
f2 :: Int -> [a] -> [a]
f2 n = f n []
    where f _ acc [] = reverse acc
          f 1 acc (_:xs) = f n acc xs
          f k acc (x:xs) = f (pred k) (x : acc) xs

-- Recursion with "take" and "drop"
f3 :: Int -> [a] -> [a]
f3 _ [] = []
f3 n xs = take (pred n) xs ++ (f2 n $ drop n xs)

-- Zip with cycle, filter, map
f4 :: Int -> [a] -> [a]
f4 n = map snd . filter ((< n) . fst) . zip (cycle [1..n])

-- Using list comprehensions
f5 :: Int -> [a] -> [a]
f5 n xs = [x | (x, k) <- zip xs $ cycle [1..n], k < n]