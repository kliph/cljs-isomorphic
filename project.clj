(defproject cljs-isomorphic "0.1.0-SNAPSHOT"
  :description "Following along with http://blog.testdouble.com/posts/2016-01-21-isomorphic-clojurescript.html"
  :url "http://github.com/kliph/cljs-isomorphic"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.5.3"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.293"]
                 [reagent "0.6.0"]
                 [secretary "1.2.3"]
                 [kibu/pushy "0.3.6"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :clean-targets ^{:protect false} ["resources"]
  :cljsbuild {:builds [{:id "server"
                        :source-paths ["src" "src-server"]
                        :compiler {:main cljs-isomorphic.server
                                   :output-to "resources/public/js/server-side/server.js"
                                   :output-dir "resources/public/js/server-side"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}
                       {:id "app"
                        :source-paths ["src" "src-client"]
                        :compiler {:output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js"
                                   :optimizations :none
                                   :source-map true}}]})
