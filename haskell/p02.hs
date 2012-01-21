-- P02 Find the last but one element of a list.

-- Recursion
f1 :: [a] -> a
f1 [] = error "empty list"
f1 [_] = error "singleton list"
f1 [x,_] = x
f1 (_:xs) = f1 xs

-- Function application
f2 :: [a] -> a
f2 xs = last $ init xs

-- Function composition
f3 :: [a] -> a
f3 = last . init

-- Folding
f4 :: [a] -> a
f4 = foldr1 (const id) . init

-- Using index
f5 :: [a] -> a
f5 x = reverse x !! 1