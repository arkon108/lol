(ns lol.ch1a)
;;; Chapter 1 - first game "Guess my number"
;;; Imagine a number between 1 and 100 and start with (guess-my-number)
;;;
;;; Rewriten to more idiomatic Clojure


(def SMALL (atom   1))
(def BIG   (atom 100))

(defn guess-my-number []
  (bit-shift-right (+ @SMALL @BIG) 1)
)

(defn smaller []
  (reset! BIG (dec (guess-my-number)))
  (guess-my-number))

(defn bigger []
  (reset! SMALL (inc (guess-my-number)))
  (guess-my-number))