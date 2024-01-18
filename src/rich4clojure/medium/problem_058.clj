(ns rich4clojure.medium.problem-058
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Function Composition =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [higher-order-functions core-functions]
;; 
;; Write a function which allows you to create function
;; compositions. The parameter list should take a variable
;; number of functions, and create a function that applies
;; them from right-to-left.

(def restricted [comp])

(def __ (fn [& fns]
          (fn [& args]
            ;; args out of the reduce are always a vector, so pull the first one out, that's the final result
            (first
             (reduce
              #(let [next-args
                    ;;  resulting args list must be a vector for the subsequent apply call
                     (vector
                      ;; apply the current fn with the provided args
                      (apply %2 %1))]
                 next-args)
              args
              (reverse fns))))))

(comment
  ((__ rest reverse) [1 2 3 4])
  (def fns (quote (rest reverse)))
  (def args (quote ([1 2 3 4]))))

(tests
 [3 2 1] := ((__ rest reverse) [1 2 3 4])
 5 := ((__ (partial + 3) second) [1 2 3 4])
 true := ((__ zero? #(mod % 8) +) 3 5 7 9)
 "HELLO" := ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ecb209948f280eeb565745dce17937f4