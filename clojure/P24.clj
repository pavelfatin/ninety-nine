; P24 Lotto: Draw N different random numbers from the set 1..M.

; The obvious answer is (P23/f1 n (range 1 m))
; Let's use "distinct" for a different solution
(defn f1 [n m]
  (take n (distinct (repeatedly #(inc (rand-int m))))))