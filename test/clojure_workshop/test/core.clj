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
  ;; Bruk vec function
  (is (= [1 2 3] (vector 1 2 3))))

(deftest use-conjoin
  (are [x y] (= x y)
    (conj [1] 2) [1 2]
    (conj [1 2] 3 4) [1 2 3 4]
    (conj '(2 1) 3 4) '(4 3 2 1)
    (conj #{2 1} 3 4) #{1 2 3 4}))

;; Bruk (doc conj) for info

(deftest how-to-find-lenght-of-something
  (let [f count]
    (are [x y] (= x y)
      (f '(1 2 3 3 1)) 5
      (f "Hello World") 11
      (f [[1 2] [3 4] [5 6]]) 3
      (f '(13)) 1
      (f '(:a :b :c))) 3))

(run-tests)
