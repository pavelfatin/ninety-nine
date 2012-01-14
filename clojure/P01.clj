; P01 Find the last element of a list.

; Predefined function
(defn f0 [l]
  (last l))

; Tail recursion
(defn f1 [l]
  (if (next l)
    (recur (rest l))
    (first l)))

; Folding
(defn f2 [l]
  (reduce (fn [_ b] b) l))