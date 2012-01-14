-- P13 Run-length encoding of a list (direct solution).

module P13 where

data Entry a = Value a | Sequence Int a deriving Show

-- Factory function
makeEntry :: Int -> a -> Entry a
makeEntry 1 a = Value a
makeEntry n a = Sequence n a

-- A simple solution, but there's still some kind of sublists
f1 :: Eq a => [a] -> [Entry a]
f1 [] = []
f1 (x:xs) = let (a, b) = span (== x) xs in
            makeEntry (succ $ length a) x : f1 b

-- Recursion, "look-ahead"
f2 :: Eq a => [a] -> [Entry a]
f2 [] = []
f2 xs = f 1 xs
    where f n [x] = [makeEntry n x]
          f n (a:bs@(b:_)) = if a == b then f (succ n) bs else makeEntry n a : f 1 bs

-- Recursion, "look-behind"
f3 :: Eq a => [a] -> [Entry a]
f3 [] = []
f3 (x:xs) = f 1 x xs
    where f n x [] = [makeEntry n x]
          f n x (y:ys) = if y == x then f (succ n) y ys else makeEntry n x : f 1 y ys