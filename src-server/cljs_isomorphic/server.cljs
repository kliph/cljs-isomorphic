(ns cljs-isomorphic.server
  (:require [cljs.nodejs :as nodejs]
            [reagent.core :as reagent]))

(nodejs/enable-util-print!)

(def express (nodejs/require "express"))

(defn template []
  [:html {:lang "en"}
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]]
   [:body
    [:div#app
     [:h1 "Server Rendering!!"]]]])

(defn ^:export render-page [path]
  (reagent/render-to-static-markup [template]))

(defn handle-request [req res]
  (.send res
         (-> req
             (goog.object.get "path")
             render-page)))

(defn -main []
  (let [app (express)]
    (.get app "/" handle-request)
    (.listen app 3000 (fn []
                        (println "Server started on port 3000")))))

(set! *main-cli-fn* -main)
