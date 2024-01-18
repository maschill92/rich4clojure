(ns rich4clojure.medium.problem-085
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Power Set =
;; By 4Clojure user: peteris
;; Difficulty: Medium
;; Tags: [set-theory]
;; 
;; Write a function which generates the power set of a
;; given set. The power set of a set x is the set of all
;; subsets of x, including the empty set and x itself.

(def __ (fn [s]
          (reduce
           ;; for each set item...
           ;; merge into the set of sets the following:
           #(do
              ;; (println %1)
              ;; (println %2)
              (into
               %1
             ;; each set in the set with the current item in context added
               (for [subset %1]
                 (conj subset %2))))
          ;;  init is a set with an empty set
           #{#{}}
           ;; reduce through all items in the set
           s)))



(comment)

(tests
 (__ #{1 :a}) := #{#{1 :a} #{:a} #{} #{1}}
 (__ #{}) := #{#{}}
 (__ #{1 2 3}) :=
 #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}
 (count (__ (into #{} (range 10)))) := 1024)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ace16b73b8ec73ae84d8c83ceff9e568