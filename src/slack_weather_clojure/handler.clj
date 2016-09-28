(ns slack-weather-clojure.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [clj-http.client :as client]))

; (defroutes app-routes
;   (GET "/" [] "Hello World")
;   (route/not-found "Not Found"))
;
; (def app
;   (wrap-defaults app-routes site-defaults))

(defn post-to-slack [url msg]
  (let [m (merge {:username "SASSY BOT"
                  :icon_emoji ":sunglasses:"} msg)]
    (client/post url {:body (json/write-str m)
                      :content-type :json})))

(def hook-url "https://hooks.slack.com/services/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")

(def get-forecast-for-nyc "https://api.darksky.net/forecast/fe124719cd2509432612696d966bb01b/40.712784,-74.005941")
