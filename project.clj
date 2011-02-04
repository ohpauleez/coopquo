(defproject org.clojars.ohpauleez/coopquo "0.1.0-SNAPSHOT"
  :description "A collective intelligence library for Clojure"
  :url "http://github.com/ohpauleez/coopquo"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "See the notice in README.md or details in LICENSE.html"}
  :dependencies [;[org.clojure/clojure "1.3.0-master-SNAPSHOT"]
                 [org.clojure/clojure "1.2.0"]
                 [clj-json "0.3.1"]]
  :dev-dependencies [[vimclojure/server "2.3.0-SNAPSHOT"]
                     [org.clojure/clojure-contrib "1.2.0"]
                     [org.clojure/clojure "1.3.0-alpha4"]
                     [org.clojure.contrib/repl-utils "1.3.0-alpha4"]
                     ;[org.clojure.contrib/repl-utils "1.3.0-SNAPSHOT"]
                     [lein-cdt "1.0.0"]
                     [com.stuartsierra/lazytest "2.0.0-SNAPSHOT"]]
  :repositories {"stuartsierra-releases" "http://stuartsierra.com/maven2"
                 "stuartsierra-snapshots" "http://stuartsierra.com/m2snapshots"}
  :hooks  [leiningen.hooks.cdt]
  ;:warn-on-reflection true
  ;:jvm-opts ["-Xmx1g"]
  :repl-init-script "script/repl_init.clj")

