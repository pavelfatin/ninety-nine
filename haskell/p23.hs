-- P23 Extract a given number of randomly selected elements from a list.

import System.Random

-- Building a target list while removing items from the source (recursively)
-- Time complexity is O(n^2) in worst and average cases, O(n) - in best case
f1 :: RandomGen g => Int -> [a] -> g -> [a]
f1 0 _ _ = []
f1 n xs g = let (i, g') = randomR (0, length xs - 1) g
                (xs', x) = rm i xs
            in x : f1 (pred n) xs' g'

-- Helper function
rm :: Int -> [a] -> ([a], a)
rm n xs = let (a, x:b) = splitAt n xs in (a ++ b, x)