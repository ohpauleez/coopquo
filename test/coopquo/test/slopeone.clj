(ns coopquo.test.slopeone
  (:require [coopquo.slopepone :as cso] :reload)
  (:use [lazytest.deftest :only (deftest is are)]
        [lazytest.describe :only  (describe it testing given)]
        [coopquo.test.core :only (test-set test-set-nums)]))

