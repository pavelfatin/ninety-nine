; P23 Extract a given number of randomly selected elements from a list.

; Helper function
(defn remove-at [n l]
  (let [[a [x & b]] (split-at n l)]
    [(concat a b) x]))

; Building a target list while removing items from the source (recursively)
; Time complexity is O(n^2) in worst and average cases, O(n) - in best case
(defn f1 [n l]
  (if (pos? n)
    (let [i (rand-int (count l)), [xs x] (remove-at i l)]
      (cons x (f1 (dec n) xs)))
    '()))