-- P23 Extract a given number of randomly selected elements from a list.

import System.Random

-- Building a target list while removing items from the source (recursively)
-- Time complexity is O(n^2) in worst and average cases, O(n) - in best case
f1 :: RandomGen g => g -> Int -> [a] -> [a]
f1 _ 0 _ = []
f1 g n xs = let (i, g') = randomR (0, length xs - 1) g
                (xs', x) = rm i xs
            in x : f1 g' (pred n) xs'

-- Helper function
rm :: Int -> [a] -> ([a], a)
rm n xs = let (a, x:b) = splitAt (pred n) xs in (a ++ b, x)