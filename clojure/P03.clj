; P03 Find the Kth element of a list.

; Tail recursion
(defn f1 [l, n]
  (if (= n 1)
    (first l)
    (recur (rest l) (dec n))))

; Using index
(defn f2 [l, n]
  (nth l (dec n)))