; P16 Drop every N'th element from a list.

; Recursion with a counter
(defn f1 [n l]
  (defn f [k xs]
    (if (seq xs)
      (if (= k 1)
        (f n (rest xs))
        (cons (first xs) (f (dec k) (rest xs))))
      '()))
  (f n l))

; Tail recursion with a counter
(defn f2 [n l]
  (loop [k n acc '() xs l]
    (if (seq xs)
      (if (= k 1)
        (recur n acc (rest xs))
        (recur (dec k) (cons (first xs) acc) (rest xs)))
      (reverse acc))))

; Recursion with "take" and "drop"
(defn f3 [n l]
  (if (seq l)
    (concat (take (dec n) l) (f3 n (drop n l)))
    '()))

; Zip with cycle, filter, map
(defn f4 [n l]
  (map first
    (filter #(< (second %) n)
      (map list l (cycle (range 1 (inc n)))))))