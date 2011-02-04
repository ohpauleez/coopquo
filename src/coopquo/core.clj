(ns coopquo.core
  #_(:require [clojure.contrib.math :as math]))

(defn shared-keys
  "Find the similar keys given two maps"
  [id-1 id-2]
  (clojure.set/intersection (set (keys id-1)) (set (keys id-2)))) ; faster than filter

(defn similar-sum
  "Sum all the preferences for user/ID found in the sub-preferences"
  [prefs id sub-prefs]
  #_(reduce #(+ (get-in prefs [id %2]) %1) 0 sub-prefs) ; slower, not as clear upfront
  (apply + (vals (select-keys (prefs id) sub-prefs))))

(defn similar-sum-square
  "Sum the squares of all the preferences for user/ID found in the sub-preferences"
  [prefs id sub-prefs]
  #_(apply + (for [x (vals (select-keys (prefs id) sub-prefs))] (Math/pow x 2))) ; slower
  #_(apply + (map #(Math/pow (get-in prefs [id %1]) 2) sub-prefs)) ; about the same as below for small sample sizes
  #_(reduce #(+ (Math/pow (get-in prefs [id %2]) 2) %1) 0 sub-prefs) ; I think the above reads easier than this
  (apply + (map #(Math/pow (get-in prefs [id %1]) 2) sub-prefs)))
 
(defn similiar-sum-product
  ""
  [prefs id-1 id-2 sub-prefs]
  #_(reduce #(+ (* (get-in prefs [id-1 %2]) (get-in [id-2 %2])) %1) 0 sub-prefs) ; this feels needlessly complex
  (apply + (map #(* (get-in prefs [id-1 %2]) (get-in [id-2 %2])) sub-prefs)))

(defn pearson
  "Pearson Correltion between two users/IDs, given a preference map"
  [prefs id-1 id-2]
  (let [shared-items (shared-keys (prefs id-1) (prefs id-2))]
    (if-let [n-shared (if (empty? shared-items) false (count shared-items))]
      (let [sum1 (similar-sum prefs id-1 shared-items)
            sum2 (similar-sum prefs id-2 shared-items)
            sum1sq (similar-sum-square prefs id-1 shared-items)
            sum2sq (similar-sum-square prefs id-2 shared-items)
            psum (similiar-sum-product prefs id-1 id-2 shared-items)]
        (try
          (/ (- psum (/ (* sum1 sum2) n-shared))
             (* (- sum1sq (/ (Math/pow sum1 2) n-shared))
                (- sum2sq (/ (Math/pow sum2 2) n-shared))))
          (catch Exception e 0)))
      0)))

