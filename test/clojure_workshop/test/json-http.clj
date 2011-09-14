(ns clojure_workshop.test.json-http
  (:require [clojure.contrib.io :as io]
            [clojure.contrib.http.agent :as http]
            [clojure.contrib.json :as json]
            [clojure.string]))

(defn- print-json [jsn]
  (json/pprint-json jsn))

(defn- twitter-text-result [{res :results}]
  (println
    (clojure.string/join "\n"
      (map :text res))))

;; Three following functions does the same, which do you prefer?
(defn- agent-handler [agt]
  (twitter-text-result
    (json/read-json
      (io/reader
        (http/stream agt)))))

(defn- agent-handler-> [agt]
  (-> agt http/stream io/reader json/read-json twitter-text-result))

(defn- agent-handler-let [agt]
  (let [str (http/stream agt)
        rdr (io/reader str)
        jsn (json/read-json rdr)]
    (twitter-text-result jsn)))

(agent-handler
  (http/http-agent "http://search.twitter.com/search.json?q=usa&result_type=recent&count=10"))

(http/http-agent
  "http://search.twitter.com/search.json?q=usa&result_type=recent&count=10"
  :handler agent-handler)

