; P22 Create a list containing all integers within a given range.

; Predefined function
(defn f1 [a b]
  (range a (inc b)))

; As a sum
(defn f2 [a b]
  (reductions + a (repeat (- b a) 1)))

; Recursion
(defn f3 [a b]
  (if (<= a b)
    (cons a (f3 (inc a) b))
    '()))

; Tail recursion
(defn f4 [a b]
  (loop [i a, k b, acc '()]
    (if (>= k i)
      (recur i (dec k) (cons k acc))
      acc)))