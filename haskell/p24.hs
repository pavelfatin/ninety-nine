-- P24 Lotto: Draw N different random numbers from the set 1..M.

import System.Random
import Data.List

-- The obvious answer is P23.f1 n [1..m]
-- Let's use "nub" for a different solution
f1 :: RandomGen g => Int -> Int -> g -> [Int]
f1 n m = take n . nub . randomRs (1, m)