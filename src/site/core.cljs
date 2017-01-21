(ns site.core
  (:require [reagent.core :as r]
            [secretary.core :as secretary :refer-macros [defroute]]))

(def current-page (r/atom nil))

(defn home-page []
  [:div [:h1 "Home page"]])

(defn app-view []
  [:div [@current-page]])

(secretary/set-config! :prefix "/")

(defroute "/" []
  (.log js/console "home page")
  (reset! current-page home-page))

(reset! current-page home-page)
