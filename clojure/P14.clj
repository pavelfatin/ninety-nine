; P14 Duplicate the elements of a list.

; Recursion
(defn f1 [l]
  (if (seq l)
    (cons (first l)
      (cons (first l) (f1 (rest l))))
    '()))

; Direct tail recursion (inefficient)
(defn f2 [l]
  (loop [acc '() xs l]
    (if (seq xs)
      (recur
        (concat acc (list (first xs) (first xs)))
        (rest xs))
      acc)))

; Tail recursion with "reverse"
(defn f3 [l]
  (loop [acc '() xs l]
    (if (seq xs)
      (recur
        (cons (first xs) (cons (first xs) acc))
        (rest xs))
      (reverse acc))))

; Direct left folding (inefficient)
(defn f4 [l]
  (reduce #(concat %1 (list %2 %2)) '() l))

; Left folding with reverse
(defn f5 [l]
  (reduce #(cons %2 (cons %2 %1)) '() (reverse l)))

; Map then flatten
(defn f6 [l]
  (flatten (map #(list %1 %1) l)))

; Using "mapcat"
(defn f7 [l]
  (mapcat #(list %1 %1) l))

; With "repeat"
(defn f8 [l]
  (mapcat #(repeat 2 %) l))