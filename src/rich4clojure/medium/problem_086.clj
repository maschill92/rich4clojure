(ns rich4clojure.medium.problem-086
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Happy numbers =
;; By 4Clojure user: daviddavis
;; Difficulty: Medium
;; Tags: [math]
;; 
;; Happy numbers are positive integers that follow a
;; particular formula: take each individual digit, square
;; it, and then sum the squares to get a new number.
;; Repeat with the new number and eventually, you might
;; get to a number whose squared sum is 1. This is a happy
;; number. An unhappy number (or sad number) is one that
;; loops endlessly. Write a function that determines if a
;; number is happy or not.

(defn summed-squares [n]
  (apply + (map
            (fn [s]
              (let [i (Integer/parseInt s)]
                (* i i)))
            (clojure.string/split (str n) #""))))

(def __ (fn calc [n]
          (loop [seen #{}
                 curr n]
            (let [summed (summed-squares curr)]
              (cond
                (= summed 1) (do (println curr "is happy!") true)
                (contains? seen curr) (do (println curr "is sad and we've already seen this number. Bummer!") false)
                :else (do
                        (println curr "is sad but hasn't seen. Trying again!")
                        (recur (conj seen curr) summed)))))))

(comment
  (__ 7))

(tests
 (__ 7) := true
 (__ 986543210) := true
 (__ 2) := false
 (__ 3) := false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b921948244dc0417fc716fe31cecb359