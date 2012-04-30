; P17 Split a list into two parts; the length of the first part is given.

; Using predefined function
(def f1 split-at)

; Using "take" and "drop"
(defn f2 [n l]
  [(take n l) (drop n l)])

; Recursion with a counter
(defn f3 [n l]
  (if (seq l)
    (if (zero? n)
      ['(), l]
      (let [[a b] (f3 (dec n) (rest l))]
        [(cons (first l) a), b]))
    ['(), '()]))

; Tail recursion with a counter
(defn f4 [n l]
  (loop [k n xs l acc '()]
    (if (seq l)
      (if (zero? k)
        [(reverse acc) xs]
        (recur (dec k) (rest xs) (cons (first xs) acc)))
      [(reverse acc) '()])))