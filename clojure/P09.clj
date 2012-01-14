; P09 Pack consecutive duplicates of list elements into sublists.

; Predefined function
(defn f0 [l]
  (partition-by identity l))

; Recursion with "split-with"
(defn f1 [l]
  (if (seq l)
    (let [h (first l) t (rest l) [a b] (split-with #(= % h) t)]
      (cons (cons h a) (f1 b)))
    '()))