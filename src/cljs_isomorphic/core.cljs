(ns cljs_isomorphic.core
  (:require [reagent.core :as r]
            [secretary.core :as secretary :refer-macros [defroute]]))

(def current-page (r/atom nil))

(defn navigation []
  [:div [:a {:href "/"} "Home Page"]
   [:span {:style {:padding "5px"}}]
   [:a {:href "/page-one"} "Page One"]
   [:span {:style {:padding "5px"}}]
   [:a {:href "#" :on-click #(js/Notification. "Hello there")} "Say Hi!"]])

(defn home-page []
  [:div [navigation] [:h1 "Home Page"]])

(defn page-one []
  [:div [navigation] [:h1 "Page One"]])

(defn app-view []
  [:div [@current-page]])

(secretary/set-config! :prefix "/")

(defroute "/" []
  (.log js/console "home page")
  (reset! current-page home-page))

(defroute "/page-one" []
  (.log js/console "page-one")
  (reset! current-page page-one))

(reset! current-page home-page)
