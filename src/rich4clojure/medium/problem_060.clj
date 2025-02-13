(ns rich4clojure.medium.problem-060
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Sequence Reductions =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [seqs core-functions]
;; 
;; Write a function which behaves like reduce, but returns
;; each intermediate value of the reduction. Your function
;; must accept either two or three arguments, and the
;; return sequence must be lazy.

(def restricted [reductions])

(def __ (fn my-reductions
          ([f coll]
           (my-reductions f (first coll) (rest coll)))

          ([f init coll]
           (cons init
                 (lazy-seq
                  (when-let [s (seq coll)]
                    (my-reductions f (f init (first s)) (rest s))))))))


(comment)

(tests
 (take 5 (__ + (range))) := [0 1 3 6 10]
 (__ conj [1] [2 3 4]) := [[1] [1 2] [1 2 3] [1 2 3 4]]
 (last (__ * 2 [3 4 5])) := (reduce * 2 [3 4 5]) 120)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/4688fc26154649a2735f14264938fa3b