-- P15 Replicate the elements of a list a given number of times.

-- Using concatMap and replicate
f1 :: Int -> [a] -> [a]
f1 n xs = concatMap (replicate n) xs

-- With function composition
f2 :: Int -> [a] -> [a]
f2 = concatMap . replicate

-- Without "replicate" (folding with concatenation)
f3 :: Int -> [a] -> [a]
f3 n = foldr ((++).(rep n)) []
    where rep 0 _ = []
          rep n x = x : rep (pred n) x

-- More efficient version (one-pass concatenation)
f4 :: Int -> [a] -> [a]
f4 n = foldr (prepend n) []
    where prepend 0 _ xs = xs
          prepend n x xs = x : prepend (pred n) x xs