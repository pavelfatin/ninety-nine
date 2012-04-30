; P18 Extract a slice from a list.

; Using "take" and "drop"
(defn f1 [l i k]
  (drop (dec i) (take k l)))

; Using "split-at"
(defn f2 [l i k]
  (second (split-at (dec i) (first (split-at k l)))))

; Recursion
(defn f3 [l i k]
  (if (seq l)
    (if (> i 1)
      (f3 (rest l) (dec i) (dec k))
      (if (pos? k)
        (cons (first l) (f3 (rest l) 1 (dec k)))
        '()))
    '()))

; Tail recursion
(defn f4 [l i k]
  (loop [acc '() xs l a i b k]
    (if (seq xs)
      (if (> a 1)
        (recur acc (rest xs) (dec a) (dec b))
        (if (pos? b)
          (recur (cons (first xs) acc) (rest xs) 1 (dec b))
          (reverse acc)))
      (reverse acc))))

; Filter by index
(defn f5 [l i k]
  (map first
    (filter #(>= (second %) i)
      (map list l (range 1 (inc k))))))

; Folding
(defn f6 [l i k]
  (defn f [acc [x n]]
    (if (>= n i) (cons x acc) acc))
  (reverse
    (reduce f '() (map list l (range 1 (inc k))))))