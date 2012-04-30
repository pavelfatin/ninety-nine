; P21 Insert an element at a given position into a list.

; Using "split-at"
(defn f1 [n x l]
  (let [[a b] (split-at (dec n) l)]
    (concat a (cons x b))))

; By index (inefficient)
(defn f2 [n x l]
  (concat (take (dec n) l) (cons x (drop (dec n) l))))

; Recursion
(defn f3 [n x l]
  (if (= n 1)
    (cons x l)
    (cons (first l) (f3 (dec n) x (rest l)))))

; Tail recursion
(defn f4 [n x l]
  (loop [i n ys l acc '()]
    (if (= i 1)
      (concat (reverse acc) (cons x ys))
      (recur (dec i) (rest ys) (cons (first ys) acc)))))