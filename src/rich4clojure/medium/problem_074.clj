(ns rich4clojure.medium.problem-074
  (:require [clojure.string :as string]
            [clojure.math.numeric-tower :as math]
            [hyperfiddle.rcf :refer [tests]]))

;; = Filter Perfect Squares =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; 
;; Given a string of comma separated integers, write a
;; function which returns a new comma separated string
;; that only contains the numbers which are perfect
;; squares.

(def __ (fn [s]
          (string/join
           ","
           (filter
            #(not (float? (math/sqrt %1)))
            (map
             #(Integer/parseInt %1)
             (string/split s #","))))))

(comment
  (def s "4,5,6,7,8,9"))

(tests
 (__ "4,5,6,7,8,9") := "4,9"
 (__ "15,16,25,36,37") := "16,25,36")

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b90fcac09b35c74a07228dea603ddc73