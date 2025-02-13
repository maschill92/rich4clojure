(ns rich4clojure.easy.problem-088
  (:require [clojure.set :as set]
            [hyperfiddle.rcf :refer [tests]]))

;; = Symmetric Difference =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [set-theory]
;; 
;; Write a function which returns the symmetric difference
;; of two sets. The symmetric difference is the set of
;; items belonging to one but not both of the two sets.

(def __ (fn [a b]
          (set/union (set/difference a b) (set/difference b a))))

(comment
  (def a #{1 2 3 4 5 6})
  (def b #{1 3 5 7}))

(tests
 (__ #{1 2 3 4 5 6} #{1 3 5 7}) := #{2 4 6 7}
 (__ #{:a :b :c} #{}) := #{:a :b :c}
 (__ #{} #{4 5 6}) := #{4 5 6}
 (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) := #{[1 2] [3 4]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b78bc7de41bb6cef6ca18c1e924bb5ac