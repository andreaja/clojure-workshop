(ns clojure-workshop.test.json-http
  (:require [clojure.java.io :as io]
            [clj-http.client :as client]
            [clojure.data.json :as json]
            [clojure.string]))

(def twitter-search-url "http://search.twitter.com/search.json?q=usa&result_type=recent&count=10")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Predefined functions. Check below for tasks
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn print-json
  "Prints json in a 'pretty' way to *out*"
  [jsn] (json/pprint-json jsn))

(defn search-twitter
  "Search twitter using 'twitter-search-url'.
   Converts it to internal json representation before returning it."
  [] (-> twitter-search-url client/get :body json/read-json))

(defn print-fn-result
  "Prints results of a function call 'f' and returns the result"
  [f json-result-fn]
  (let [res (f (json-result-fn))]
    (println res)
    res))

(defn slurp-file-json
  "Reads 'twitter-java-search-json.txt' from the file system and converts it to json"
  [] (json/read-json
    (slurp "twitter-java-search-json.txt")))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; This is where you should fill in your code.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Hint: get results and then the text. If you want nice formatting check out clojure/string.
(defn text-from-twitter-search [search-result]
  (print-json search-result))


;; Hint: get the results, then map the contents so the collection will only contain encoding (iso_language_code).
(defn unique-set-of-tweet-encodings [search-result]
  (set '()))

(comment
(print-fn-result text-from-twitter-search search-twitter)
(print-fn-result unique-set-of-tweet-encodings search-twitter)

(if (= 9 (count (print-fn-result unique-set-of-tweet-encodings slurp-file-json)))
  (println "You are a Clojure master")
  (println "You need to practice some more"))

; Print out tweet(s) from "@world_finance"
(println
  (map :text
    (filter #(= (:from_user %) "world_finance")
      (:results (slurp-file-json)))))

; Print out all tweets that replies to someone
(println
  (map :text
    (filter
      #(not= nil (:to_user %))
      (:results (slurp-file-json )))))

)

; Still have time left. Think about how you would make http call asynchronous.
