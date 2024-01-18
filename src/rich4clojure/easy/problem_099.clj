(ns rich4clojure.easy.problem-099
  (:require [clojure.string :as string]
            [hyperfiddle.rcf :refer [tests]]))

;; = Product Digits =
;; By 4Clojure user: jneira
;; Difficulty: Easy
;; Tags: [math seqs]
;; 
;; Write a function which multiplies two numbers and
;; returns the result as a sequence of its digits.

(def __ (fn [n1 n2] (map #(Integer/parseInt %1) (string/split (str (* n1 n2)) #"\D*"))))

(comment)

(tests
 (__ 1 1) := [1]
 (__ 99 9) := [8 9 1]
 (__ 999 99) := [9 8 9 0 1])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/2a889ddd7c667b5b738f9a61d14f3958