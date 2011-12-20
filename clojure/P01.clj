; P01 Find the last element of a list.

; Predefined function
(defn f0 [l]
  (last l))

; Tail recursion
(defn f1 [l]
  (if (next l)
    (recur (rest l))
    (first l)))