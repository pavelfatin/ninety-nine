-- P11 Modified run-length encoding.

module P11 where

data Entry a = Value a | Sequence Int a deriving Show

f1 :: [(Int, a)] -> [Entry a]
f1 = map toEntry
    where toEntry (1, x) = Value x
          toEntry (n, x) = Sequence n x