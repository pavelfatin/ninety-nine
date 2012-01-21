-- P12 Decode a run-length encoded list.

data Entry a = Value a | Sequence Int a deriving Show

-- Using concatMap
f1 :: [Entry a] -> [a]
f1 = concatMap toItems
    where toItems (Value v) = [v]
          toItems (Sequence n v) = replicate n v

-- Recursion
f2 :: [Entry a] -> [a]
f2 [] = []
f2 ((Value v) : xs) = v : f2 xs
f2 ((Sequence n v) : xs) = replicate n v ++ f2 xs