; P12 Decode a run-length encoded list.

; Mapping
(defn f1 [l]
  (defn f [x] (if (seq? x) (repeat (first x) (second x)) x))
  (flatten (map f l)))

; Recursion
(defn f2 [l]
  (if (seq l)
    (let [h (first l) t (rest l)]
      (if (seq? h)
        (concat (repeat (first h) (second h)) (f2 t))
        (cons h (f2 t))))
    '()))