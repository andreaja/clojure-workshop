(ns clojure-workshop.test.core
  (:use [clojure-workshop.core])
  (:use [clojure.test]))

(defn __ [& args] false)
(def ___ identity)

(deftest very-basic-types
  (is (= 1 1))
  (is (true? __))
  (is (= (str \a \b \c) __))
  ;; Bruk vector literal
  (is (= [1 2 3] __))
  ;; Bruk list literal
  (is (= [1 2 3] __))
  ;; Bruk list function
  (is (= [1 2 3] __))
  ;; Bruk vec function
  (is (= [1 2 3] __)))

(deftest use-conjoin
  (are [x y] (= x y)
    (conj [1] 2) __
    (conj [1 2] 3 4) __
    (conj '(2 1) 3 4) __
    (conj #{2 1} 3 4) __))

;; Bruk (doc conj) for info

(deftest hvordan-telle-ting
  (are [x y] (= x y)
       5 (___ '(1 2 3 4 5))
       4 (___ [1 2 3 4])
       10 (___ (range 10))
       4 (___ {:a 1, :b 2, :c 3, :d 4})
       8 (___ "En banan")))

(deftest how-to-find-length-of-something
  (let [f ___]
    (are [x y] (= x y)
      (f '(1 2 3 3 1)) 5
      (f "Hello World") 11
      (f [[1 2] [3 4] [5 6]]) 3
      (f '(13)) 1
      (f '(:a :b :c))) 3))


(deftest hvordan-filtrere-ut-det-du-vil-ha
  (are [x y] (= x y)
       (filter odd? '(1 2 3 4 5)) __
       (filter even? '(1 2 3 4 5)) __))

(run-tests)
