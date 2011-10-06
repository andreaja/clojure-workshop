(ns clojure-workshop.test.core
  (:use [clojure.test]))

; Placeholders do not touch.
(defn __ [& args] false)
(def ___ identity)

(comment

(deftest very-basic-types
  (is (= 1 1))
  (is (true? __))
  (is (= (str \a \b \c) __))
  ;; Use vector literal
  (is (= '(1 2 3) __))
  ;; Use list literal
  (is (= [1 2 3] __))
  ;; Use list function
  (is (= [1 2 3] __))
  ;; Use vector function
  (is (= [1 2 3] __)))


(deftest use-conjoin
  (are [x y] (= x y)
    (conj [1] 2) __
    (conj [1 2] 3 4) __
    (conj '(2 1) 3 4) __
    (conj #{2 1} 3 4) __))

;; Use (doc conj) for info


(deftest how-to-count-stuff
  (are [x y] (= x y)
    __ (count '(1 2 3 4 5))
    __ (count [1 2 3 4])
    __ (count (range 10))
    __ (count {:a 42, :b 1337, :c 3.14, :d 1701})
    __ (count "En banan")))


(deftest how-to-find-length-of-something
  (let [f ___]
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
       ___
       (if (> 3 2 1)
         true
         false)
       ___
       (if (> 3 2 3 1)
         true
         false)
       ___))

(deftest dealing-with-lists
  (are [x y] (= x y)
       (first '(1 2 3 4))  __
       (last '(1 2 3 4 5)) __
       (take 2 '(1 2 3 4)) __))


(deftest operating-on-lists
  (are [x y] (= x y)
       (apply + [1 2 3 4]) ___
       (apply - [4 3 2 1]) ___
       (apply * [1 2 3 4]) ___
       ))



(deftest how-to-filter-out-the-stuff-you-want
  (are [x y] (= x y)
       (filter odd? '(1 2 3 4 5)) __
       (filter even? '(1 2 3 4 5)) __))

(deftest define-a-function-that-checks-if-something-is-longer-than
  (let [long? __]
    (are [x y] (= x y)
         (long? "long string" 5) true
         (long? "short" 5) false
         (long? nil 2) false
         )))


(deftest use-map-to-manipulate-all-elements-in-a-sequence
  (let [double __]
    (are [x y] (= x y)
        (map double '(1 2 3)) '(2 4 6)
        (map double '(5 10 15)) '(10 20 30))))

)

(run-tests)
