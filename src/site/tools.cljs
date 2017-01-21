(ns site.tools
  (:require [reagent.core :as r]
            [secretary.core :as secretary]
            [cljs-isomorphic.core :as core ]))

(enable-console-print!)

(defn template [{:keys [body]}]
  [:html {:lang "en"}
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]]
   [:body
    [:div#app [body]]
    [:script {:type "text/javascript" :src "goog/base.js"}]
    [:script {:type "text/javascript" :src "app.js"}]
    [:script {:type "text/javascript"
              :dangerouslySetInnerHTML {:__html "goog.require('cljs_isomorphic.client');"}}]]])

(defn ^:export render-page [path]
  (r/render-to-static-markup (do
                               (secretary/dispatch! path)
                               [template {:body core/app-view}])))
