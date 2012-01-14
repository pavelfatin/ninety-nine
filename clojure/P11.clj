; P11 Modified run-length encoding.

(defn f1 [l]
  (defn f [x] (if (= 1 (first x)) (second x) x))
  (map f l))