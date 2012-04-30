; P20 Remove the K'th element from a list.

; Using "split-at"
(defn f1 [n l]
  (let [[a [x & b]] (split-at (dec n) l)]
    [(concat a b) x]))

; By index (inefficient)
(defn f2 [n l]
  [(concat (take (dec n) l) (drop n l)) (nth l (dec n))])

; Recursion
(defn f3 [n l]
  (let [[h & t] l]
    (if (> n 1)
      (let [[a b] (f3 (dec n) t)]
        [(cons h a) b])
      [t h])))

; Tail recursion
(defn f4 [n l]
  (loop [acc '() i n [h & t] l]
    (if (> i 1)
      (recur (cons h acc) (dec i) t)
      [(concat (reverse acc) t) h])))