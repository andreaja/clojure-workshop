(ns clojure-workshop.test.json-http
  (:require [clojure.java.io :as io]
            [clojure.contrib.http.agent :as http]
            [clojure.data.json :as json]
            [clojure.string]))

(defn print-json [jsn]
  (json/pprint-json jsn))


(defn- agent-handler [agt]
  (-> agt http/stream io/reader json/read-json))

(defn print-fn-result [f]
  (println (f (agent-handler
                (http/http-agent "http://search.twitter.com/search.json?q=usa&result_type=recent&count=10")))))

#_
(defn slurp-file-json []
  (json/read-json
    (slurp "twitter-java-search-json.txt")))

;; Hint hent results og deretter text. For fin formattering sjekk ut clojure/string.
(defn text-from-twitter-search [search-result]
  (clojure.string/join "\n"
    (map :text (:results search-result))))

(defn unique-set-of-tweet-encodings [search-result]
  (set (map :iso_language_code (:results search-result))))


(print-fn-result text-from-twitter-search)
(print-fn-result unique-set-of-tweet-encodings)

;(println (slurp-file-json))