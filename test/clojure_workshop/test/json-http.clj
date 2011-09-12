(ns clojure_workshop.test.json-http
  (:require [clojure.contrib.io :as io]
            [clojure.contrib.http.agent :as http]
            [clojure.contrib.json :as json]))

(defn handle-json [jsn]
  (json/pprint-json jsn))

(http/http-agent
  "https://api.github.com/repos/clojure/clojure/commits"
  :handler #(-> % http/stream io/reader json/read-json handle-json))

