(ns rich4clojure.medium.problem-080
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Perfect Numbers =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; 
;; A number is "perfect" if the sum of its divisors equal
;; the number itself. 6 is a perfect number because
;; 1+2+3=6. Write a function which returns true for
;; perfect numbers and false otherwise.

(def __ (fn [n]
          (= n
             (apply + (filter #(int? (/ n %1)) (range 1 n))))))

(comment
  (def n 6)
  )

(tests
  (__ 6) := true
  (__ 7) := false
  (__ 496) := true
  (__ 500) := false
  (__ 8128) := true)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/349c937f940951b1ec6972b98834f185