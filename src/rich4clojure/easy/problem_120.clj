(ns rich4clojure.easy.problem-120
  (:require [clojure.string :as string]
            [hyperfiddle.rcf :refer [tests]]))

;; = Sum of square of digits =
;; By 4Clojure user: danilo
;; Difficulty: Easy
;; Tags: [math]
;; 
;; Write a function which takes a collection of integers
;; as an argument. Return the count of how many elements
;; are smaller than the sum of their squared component
;; digits. For example: 10 is larger than 1 squared plus 0
;; squared; whereas 15 is smaller than 1 squared plus 5
;; squared.

(def __ (fn [l]
          (reduce
           (fn [count v]
             (let [num-list (map #(Integer/parseInt %1) (string/split (str v) #"\D*"))
                   sum-of-squares (apply + (map #(* %1 %1) num-list))]
              ;;  (println "num-list:" num-list " sum-of-squares:" sum-of-squares " v:" v)
               (if (< v sum-of-squares)
                 (inc count)
                 count)))
           0
           l)))

(comment)

(tests
 8 := (__ (range 10))
 19 := (__ (range 30))
 50 := (__ (range 100))
 50 := (__ (range 1000)))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/80b83817f6c63ee546a5d05e0972a7ea