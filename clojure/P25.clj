; P25 Generate a random permutation of the elements of a list.

; Helper function
(defn remove-at [n l]
  (let [[a [x & b]] (split-at n l)]
    [(concat a b) x]))

; Generates all permutations
(defn permutations [l]
  (if (seq l)
    (mapcat
      (fn [n]
        (let [[xs x] (remove-at n l)]
          (map #(cons x %) (permutations xs))))
      (range (count l)))
    '(())))

; The obvious answer is (P23/f1 (length l) l)
; Let's directly select a random permutation for a different implementation
(defn f1 [l]
  (let [all (permutations l)]
    (nth all (rand-int (count l)))))