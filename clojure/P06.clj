; P06 Find out whether a list is a palindrome.
;     A palindrome can be read forward or backward; e.g. (x a m a x).

; Tail recursion
(defn f1 [l]
  (or (empty? l)
      (empty? (rest l))
      (and
        (= (first l) (last l))
        (f1 (butlast (rest l))))))

; Builtin "reverse"
(defn f2 [l]
  (= l (reverse  l)))