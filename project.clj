(defproject cljs-isomorphic "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.5.3"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.293"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :clean-targets ^{:protect false} ["resources"]
  :cljsbuild {:builds [{:id "server"
                        :source-paths ["src-server"]
                        :compiler {:main cljs-isomorphic.server
                                   :output-to "resources/public/js/server-side/server.js"
                                   :output-dir "resources/public/js/server-side"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]})
