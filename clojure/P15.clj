; P15 Replicate the elements of a list a given number of times.

; Replicate then mapcat
(defn f1 [n l]
  (mapcat #(repeat n %) l))

; Without using "repeat", one-pass concatenation
(defn f2 [n l]
  (defn prepend [n x xs]
    (if (= n 0) xs (cons x (prepend (dec n) x xs))))
  (reduce #(prepend n %2 %1) '() (reverse l)))