; P07 Flatten a nested list structure.

; Predefined functions
(defn f0 [l]
  (flatten l))

; Recursion
(defn f1 [l]
  (if (seq l)
    (let [h (first l) t (rest l)]
      (if (list? h)
        (concat (f1 h) (f1 t))
        (cons h (f1 t))))
    '()))