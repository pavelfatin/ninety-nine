; P05 Reverse a list.

; Predefined function
(defn f0 [l]
  (reverse l))

; Tail recursion
(defn f1 [l]
  (loop [it l, acc '()]
    (if (seq it)
      (recur (rest it) (cons (first it) acc))
      acc)))