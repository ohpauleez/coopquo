(ns user
  (:use [clojure.contrib.repl-utils :only (show)]))
;(clojure.contrib/repl-utils/add-break-thread!)

(defn unmap-all-ns []
  (doseq  [[f _]  (ns-publics *ns*)]  (ns-unmap *ns* f)))

