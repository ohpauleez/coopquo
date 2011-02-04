(ns coopquo.test.core
  (:require [coopquo.core :as ccore] :reload)
  (:use [lazytest.deftest :only (deftest is)]
        [lazytest.describe :only  (describe it testing)]))

;; This test set is based on the 'critics' set used in Programming Collective Intelligence (page 8)
(def test-set {"Johhny"   {"The Life Aquatic" 5.0 "Amelie" 4.5 "Wall-E" 4.0
                           "Mean Girls" 4.5 "Roman Holiday" 4.0 "White Christmas" 3.5
                           "Pillow Talk" 4.0 "The Aristocats" 3.5}
               "Mikey"    {"The Life Aquatic" 3.0 "Amelie" 5.0 "Wall-E" 5.0
                           "Roman Holiday" 3.0 "White Christmas" 3.0 "The Aristocats" 2.0}
               "Susan"    {"The Life Aquatic" 4.0 "Wall-E" 4.0
                           "Mean Girls" 5.0 "Roman Holiday" 4.0
                           "Pillow Talk" 4.0 "The Aristocats" 5.0}
               "Marge"    {"The Life Aquatic" 4.0 "Amelie" 3.5 "Wall-E" 5.0
                           "Mean Girls" 5.0 "Roman Holiday" 5.0 "White Christmas" 3.0
                           "Pillow Talk" 4.0 "The Aristocats" 4.5}
               "Toby"     {"Wall-E" 3.0 "Mean Girls" 5.0 "White Christmas" 3.0
                           "Pillow Talk" 2.0}
               "James"    {"The Life Aquatic" 1.0 "Amelie" 1.5  
                           "Roman Holiday" 4.0}
               "Jessica"  {"The Life Aquatic" 5.0 "Amelie" 5.0}
               "Jane"     {"Amelie" 2.0 "Wall-E" 3.0 "Mean Girls" 4.5 "Roman Holiday" 4.0 
                           "Pillow Talk" 1.0}})

;; This smaller data set is used to ensure there are no issues with numeric keys/ids
;;  The smaller set also makes it easier to compute operations/functions by hand
(def test-set-nums {1 {"1" 5.0 "2" 3.0 "3" 1.0}
                    2 {"2" 4.0 "4" 5.0 "5" 5.0}
                    3 {"1" 5.0 "4" 4.5 "5" 4.0 "6" 4.0}
                    4 {"1" 4.0}})

;(deftest replace-me ;; FIXME: write
;  (is false "No tests have been written."))

(describe "shared-keys (shared-keys map-1 map-2)"
  (testing "when there are no common keys"
    (it "should return an empty set"
      (let [m1 (test-set-nums 2)
            m2 (test-set-nums 4)
            expected #{}
            experimental (ccore/shared-keys m1 m2)]
        (= expected experimental))))
  (testing "when the maps share keys"
    (it "should return a set of those keys"
      (let [m1 (test-set-nums 2)
            m2 (test-set-nums 3)
            expected #{"4" "5"}
            experimental (ccore/shared-keys m1 m2)]
        (= expected experimental))))
  (testing "when the supplied args are similar (identical)"
    (it "should return all of the keys"
      (let [m1 (test-set-nums 2)
            m2 {"2" 4.0 "4" 5.0 "5" 5.0}
            expected #{"2" "4" "5"}
            experimental (ccore/shared-keys m1 m2)]
        (and (= expected experimental)
             (= (set (keys m1)) experimental)))))
  (testing "when the supplied args are empty"
    (it "should return an empty set"
      (let [m1 {}
            m2 {}
            expected #{}
            experimental (ccore/shared-keys m1 m2)]
        (= expected experimental))))
  (testing "when the one or both of the supplied args are nil"
    (it "should return an empty set"
      (let [m1 nil
            m2 {}
            expected #{}
            experimental (ccore/shared-keys m1 m2)]
        (and (= expected experimental)
             (= expected (ccore/shared-keys nil nil)))))))

