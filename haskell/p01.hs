-- P01 Find the last element of a list.

-- Predefined function
f0 :: [a] -> a
f0 = last

-- Recursion
f1 :: [a] -> a
f1 [] = error "empty list"
f1 [x] = x
f1 (_:xs) = f1 xs

-- Function application
f2 :: [a] -> a
f2 xs = head $ reverse xs

-- Function composition
f3 :: [a] -> a
f3 = head . reverse

-- Folding
f4 :: [a] -> a
f4 = foldl (curry snd) (error "empty list")

f5 :: [a] -> a
f5 = foldr1 (flip const)

f6 :: [a] -> a
f6 = foldr1 (const id)

f7 :: [a] -> a
f7 = foldr1 (\_ y -> y)