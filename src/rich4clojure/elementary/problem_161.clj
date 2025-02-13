(ns rich4clojure.elementary.problem-161
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Subset and Superset =
;; By 4Clojure user: hangkous
;; Difficulty: Elementary
;; Tags: [set-theory]
;; 
;; Set A is a subset of set B, or equivalently B is a
;; superset of A, if A is "contained" inside B. A and B
;; may coincide.

(def __ #{1 2})

(comment
  
  )

(tests
  __ := #{2}
  #{1} := __
  __ := #{1 2}
  #{1 2} := __)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/fb5992733dcee8d4e449957ed7ece7db