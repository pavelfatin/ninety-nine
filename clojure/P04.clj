; P04 Find the number of elements of a list.

; Predefined function
(defn f0 [l]
  (count l))

; Recursion
(defn f1 [l]
  (if (seq l)
    (inc (f1 (rest l)))
    0))

; Tail recursion
(defn f2 [l]
  (loop [it l, n 0]
    (if (seq it)
      (recur (rest it) (inc n))
      n)))