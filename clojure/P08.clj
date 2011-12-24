; P08 Eliminate consecutive duplicates of list elements.

; Predefined functions
(defn f1 [l]
  (map first (partition-by identity l)))

; Recursion with "drop-while"
(defn f2 [l]
  (if (seq l)
    (let [h (first l) t (rest l)]
      (cons h (f2 (drop-while #(= % h) t))))
    '()))

; Recursion
(defn f3 [l]
  (if (next l)
    (let [a (first l) b (second l) t (rest l)]
      (if (= a b) (f3 t) (cons a (f3 t))))
    l))