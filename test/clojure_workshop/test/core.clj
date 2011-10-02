(ns clojure-workshop.test.core
  (:use [clojure-workshop.core])
  (:use [clojure.test]))

(defn __ [& args] false)
(def ___ '())

(deftest very-basic-types
  (is (= 1 1))
  (is (true? true))
  (is (= (str \a \b \c) "abc"))
  ;; Bruk vector literal
  (is (= [1 2 3] [1 2 3]))
  ;; Bruk list literal
  (is (= [1 2 3] '(1 2 3)))
  ;; Bruk list function
  (is (= [1 2 3] (list 1 2 3)))
  ;; Bruk vector function
  (is (= [1 2 3] (vector 1 2 3))))

(deftest use-conjoin
  (are [x y] (= x y)
    (conj [1] 2) [1 2]
    (conj [1 2] 3 4) [1 2 3 4]
    (conj '(2 1) 3 4) '(4 3 2 1)
    (conj #{2 1} 3 4) #{1 2 3 4}))

;; Bruk (doc conj) for info

(deftest hvordan-telle-ting
  (are [x y] (= x y)
       5 (count '(1 2 3 4 5))
       4 (count [1 2 3 4])
       10 (count (range 10))
       4 (count {:a 1, :b 2, :c 3, :d 4})
       8 (count "En banan")))

(deftest hvordan-filtrere-ut-det-du-vil-ha
  (are [x y] (= x y)
    (filter odd? '(1 2 3 4 5)) '(1 3 5)
    (filter even? '(1 2 3 4 5)) '(2 4)))

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
       (first [1 2 3 4])  1
       (last [1 2 3 4 5]) 5
       (take 2 [1 2 3 4]) [1 2]
       ))

(run-tests)
