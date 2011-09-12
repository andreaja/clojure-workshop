(ns clojure_workshop.test.json-http
  (:require [clojure.contrib.io :as io]
            [clojure.contrib.http.agent :as http]
            [clojure.contrib.json :as json]
            [clojure.walk :as walk]))

(defn print-json [jsn]
  (json/pprint-json jsn))

(defn twitter-text-result [{res :results}]
  (print (interpose "\n" (map :text res))))

(http/http-agent
  ;"https://api.github.com/repos/clojure/clojure/commits"
  "http://search.twitter.com/search.json?q=java&result_type=mixed&count=5"
  :handler #(-> % http/stream io/reader json/read-json twitter-text-result))

