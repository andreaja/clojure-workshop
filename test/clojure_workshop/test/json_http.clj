(ns clojure-workshop.test.json-http
  (:require [clojure.contrib.io :as io]
            [clojure.contrib.http.agent :as http]
            [clojure.data.json :as json]
            [clojure.string]))

(defn- print-json [jsn]
  (json/pprint-json jsn))

(defn- twitter-text-result [{res :results}]
  (println
    (clojure.string/join "\n"
      (map :text res))))

(defn- agent-handler-> [agt]
  (-> agt http/stream io/reader json/read-json twitter-text-result))

(agent-handler->
  (http/http-agent "http://search.twitter.com/search.json?q=usa&result_type=recent&count=10"))

