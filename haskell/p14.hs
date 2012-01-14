-- P14 Duplicate the elements of a list.

-- Recursion
f1 :: [a] -> [a]
f1 [] = []
f1 (x:xs) = x : x : f1 xs

-- Direct tail recursion (inefficient)
f2 :: [a] -> [a]
f2 = f []
    where f acc [] = acc
          f acc (x:xs) = f (acc ++ [x, x]) xs

-- Tail recursion with "reverse"
f3 :: [a] -> [a]
f3 = reverse . f []
    where f acc [] = acc
          f acc (x:xs) = f (x : x : acc) xs

-- Right folding
f4 :: [a] -> [a]
f4 = foldr (\x xs -> x : x : xs) []

-- Direct left folding (inefficient)
f5 :: [a] -> [a]
f5 = foldl (\xs x -> xs ++ [x, x]) []

-- Left folding with reverse
f6 :: [a] -> [a]
f6 = reverse . foldl (\xs x -> x : x : xs) []

-- Map with "replicate" then concatenate
f7 :: [a] -> [a]
f7 = concat . map (replicate 2)

-- Using concatMap
f8 :: [a] -> [a]
f8 = concatMap (\x -> [x, x])

-- Using concatMap with "replicate"
f9 :: [a] -> [a]
f9 = concatMap (replicate 2)