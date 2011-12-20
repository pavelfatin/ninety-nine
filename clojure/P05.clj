; P05 Reverse a list.

; Predefined function
(defn f0 [l]
  (reverse l))

; Tail recursion
(defn f1 [l]
  (loop [it l, acc (empty l)]
    (if (seq it)
      (recur (rest it) (conj acc (first it)))
      acc)))