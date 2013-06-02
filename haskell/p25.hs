-- P25 Generate a random permutation of the elements of a list.

import System.Random
import Data.List

-- The obvious answer is P23.f1 (length xs) xs
-- Let's directly select a random permutation for a different implementation
f1 :: RandomGen g => [a] -> g -> [a]
f1 g xs = let (i, _) = randomR (0, total - 1) g in permutations xs !! i
	      where fact n = product [1..n]
	            total = fact $ length xs