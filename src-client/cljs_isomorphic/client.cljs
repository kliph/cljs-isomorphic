(ns cljs-isomorphic.client
  (:require [reagent.core :as r]
            [secretary.core :as secretary]
            [pushy.core :as pushy]
            [cljs-isomorphic.core :as core])
  (:import goog.History))

(enable-console-print!)

(r/render-component [core/app-view] (.getElementById js/document "app"))

(pushy/push-state! secretary/dispatch!
                   (fn [x]
                     (when (secretary/locate-route x)
                       x)))
