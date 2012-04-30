; P19 Rotate a list N places to the left.

; Using "split-at"
(defn f1 [n l]
  (if (seq l)
    (let [[a b] (split-at (mod n (count l)) l)]
      (concat b a))
    '()))

; Without using "let"
(defn f2 [n l]
  (if (seq l)
    (apply concat
      (reverse (split-at (mod n (count l)) l)))
    '()))

; Tail recursion
(defn f3 [n l]
  (if (and (seq l) (not (zero? n)))
    (if (pos? n)
      (recur (dec n) (concat (rest l) (list (first l))))
      (recur (inc n) (cons (last l) (drop-last l))))
    l))