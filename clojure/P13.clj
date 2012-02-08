; P13 Run-length encoding of a list (direct solution).

; Factory function
(defn encode [n x]
  (if (= 1 n) x [n x]))

; Using "split-with", so there's still some kind of sublists
(defn f1 [l]
  (if (seq l)
    (let [h (first l) t (rest l) [a b] (split-with #(= % h) t)]
      (cons (encode (inc (count a)) h) (f1 b)))
    '()))

; Recursion, "look-behind"
(defn f2 [l]
  (defn f [n x xs]
    (if (seq xs)
      (let [y (first xs) ys (rest xs)]
        (if (= y x)
          (f (inc n) y ys)
          (cons (encode n x) (f 1 y ys))))
      (list (encode n x))))
  (if (seq l) (f 1 (first l) (rest l)) '()))