(ns clojure-workshop.test.json-http
  (:require [clojure.java.io :as io]
            [clojure.contrib.http.agent :as http]
            [clojure.data.json :as json]
            [clojure.string]))

(def twitter-search-url "http://search.twitter.com/search.json?q=usa&result_type=recent&count=10")

(defn print-json [jsn]
  (json/pprint-json jsn))

(defn- agent-handler [agt]
  (-> agt http/stream io/reader json/read-json))

(defn search-twitter []
  (agent-handler
    (http/http-agent twitter-search-url)))

(defn print-fn-result [f json-result-fn]
  (let [res (f (json-result-fn))]
    (println res)
    res))

(defn slurp-file-json []
  (json/read-json
    (slurp "twitter-java-search-json.txt")))

;; Hint hent results og deretter text. For fin formattering sjekk ut clojure/string.
(defn text-from-twitter-search [search-result]
  (print-json search-result))

;; Hint hent results og deretter text, mappe så innhold av collection til kun å være encoding (iso_language_code).
(defn unique-set-of-tweet-encodings [search-result]
  (set '()))


(print-fn-result text-from-twitter-search search-twitter)
(print-fn-result unique-set-of-tweet-encodings search-twitter)

(if (= 9 (count (print-fn-result unique-set-of-tweet-encodings slurp-file-json)))
  (println "You are a Clojure master")
  (println "You need to practice some more"))

; Skriv ut tweet(s) fra "@world_finance"
(println (map :text (filter #(= (:from_user %) "world_finance") (:results (slurp-file-json )))))

; Skriv ut tweets fra som svarer/sender til noen
(println (map :text (filter #(not= nil (:to_user %)) (:results (slurp-file-json )))))