-- P06 Find out whether a list is a palindrome.
--     A palindrome can be read forward or backward; e.g. (x a m a x).

-- Recursion (inefficient)
f1 :: (Eq a) => [a] -> Bool
f1 []  = True
f1 [_] = True
f1 xs  = (head xs) == (last xs) && (f1 $ init $ tail xs)

-- Using "reverse" function
f2 :: (Eq a) => [a] -> Bool
f2 xs = xs == reverse xs

-- Zip
f3 :: (Eq a) => [a] -> Bool
f3 xs = all (uncurry (==)) $ zip xs (reverse xs)

-- ZipWith
f4 :: (Eq a) => [a] -> Bool
f4 xs = all id $ zipWith (==) xs (reverse xs)

-- ZipWith plus folding
f5 :: (Eq a) => [a] -> Bool
f5 xs = foldr (&&) True $ zipWith (==) xs (reverse xs)