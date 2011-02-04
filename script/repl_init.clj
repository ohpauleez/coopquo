(ns user
  (:use [clojure.contrib.repl-utils :only (show)]))
;(clojure.contrib/repl-utils/add-break-thread!)

(defn unmap-all-ns []
  (doseq  [[f _]  (ns-publics *ns*)]  (ns-unmap *ns* f)))

;user=>  (let  [band "zeppelin" city "london"]  (show-env))
;{city #<LocalBinding clojure.lang.Compiler$LocalBinding@78ff9053>, band #<LocalBinding clojure.lang.Compiler$LocalBinding@525c7734>}
(defmacro show-env [] (println &env))

