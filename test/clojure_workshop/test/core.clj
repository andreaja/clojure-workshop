(ns clojure-workshop.test.core
  (:use [clojure.test]))

; Placeholders do not touch.
(defn __ [& args] false)
(def ___ '())


(deftest very-basic-types
  (is (= 1 1))
  (is (true? true))
  (is (= (str \a \b \c) "abc"))
  ;; Use vector literal
  (is (= '(1 2 3) [1 2 3]))
  ;; Use list literal
  (is (= [1 2 3] '(1 2 3)))
  ;; Use list function
  (is (= [1 2 3] (list 1 2 3)))
  ;; Use vector function
  (is (= [1 2 3] (vector 1 2 3))))


(deftest use-conjoin
  (are [x y] (= x y)
    (conj [1] 2) [1 2]
    (conj [1 2] 3 4) [1 2 3 4]
    (conj '(2 1) 3 4) '(4 3 2 1)
    (conj #{2 1} 3 4) #{1 2 3 4}))

;; Use (doc conj) for info


(deftest how-to-count-stuff
  (are [x y] (= x y)
       5 (count '(1 2 3 4 5))
       4 (count [1 2 3 4])
       10 (count (range 10))
       4 (count {:a 1, :b 2, :c 3, :d 4})
       8 (count "En banan")))


(deftest how-to-find-length-of-something
  (let [f count]
    (are [x y] (= x y)
      (f '(1 2 3 3 1)) 5
      (f "Hello World") 11
      (f [[1 2] [3 4] [5 6]]) 3
      (f '(13)) 1
      (f '(:a :b :c))) 3))


(deftest using-if
  (are [x y] (= x y)
       (if (> 1 0)
         true
         false)
       true

       (if (> 3 2 1)
         true
         false)
       true

       (if (> 3 2 3 1)
         true
         false)
       false))


(deftest dealing-with-lists
  (are [x y] (= x y)
       (first '(1 2 3 4))  1
       (last '(1 2 3 4 5)) 5
       (take 2 '(1 2 3 4)) '(1 2)))

(deftest operating-on-lists
  (are [x y] (= x y)
       (apply + [1 2 3 4]) 10
       (apply - [4 3 2 1]) -2
       (apply * [1 2 3 4]) 24
       ))


(deftest how-to-filter-out-the-stuff-you-want
  (are [x y] (= x y)
    (filter odd? '(1 2 3 4 5)) '(1 3 5)
    (filter even? '(1 2 3 4 5)) '(2 4)))


(deftest define-a-function-that-checks-length
  (are [x y] (= x y)
       (let [long? (fn [str len] (> (count str) len))]
         (long? "long string" 5) true
         (long? "short" 5) false
         (long? nil 2) false
         )))


(deftest use-map-to-manipulate-all-elements-in-a-sequence
  (are [x y] (= x y)
       (let [double (fn [i] (* 2 i))]
         (map double '(1 2 3)) '(2 4 6)
         (map double '(5 10 15)) '(10 20 30))))


(run-tests)
