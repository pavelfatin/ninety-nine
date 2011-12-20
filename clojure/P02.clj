; P02 Find the last but one element of a list.

; Built-ins
(defn f1 [l]
  (last (butlast l)))

; Using index
(defn f2 [l]
  (nth (reverse l) 1))