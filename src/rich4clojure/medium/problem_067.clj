(ns rich4clojure.medium.problem-067
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Prime Numbers =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [primes]
;; 
;; Write a function which returns the first x number of
;; prime numbers.

(defn prime? [n]
  (cond
    (or (= n 0) (= n 1)) false
    (or (= n 2) (= n 3)) true
    :else (= '(1) (filter #(= 0 (rem n %1)) (range 1 (inc (Math/sqrt n)))))))

(def __ (fn [n]
          (take n (filter prime? (range)))))

(comment
  
  )

(tests
  (__ 2) := [2 3]
  (__ 5) := [2 3 5 7 11]
  (last (__ 100)) := 541)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/024453db620369a2d32894f7b0940462