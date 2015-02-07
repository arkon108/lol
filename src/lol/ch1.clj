(ns lol.ch1)
;;; Chapter 1 - first game "Guess my number"
;;; Imagine a number between 1 and 100 and start with (guess-my-number)
;;;
;;; Example (imagined 12)
;;; lol.ch1a=> (guess-my-number)
;;; 50
;;; lol.ch1a=> (smaller)
;;; 25
;;; lol.ch1a=> (smaller)
;;; 12


(def *small* 1)
(def *big* 100)
(defn guess-my-number []
  (bit-shift-right (+ *small* *big*) 1)
)

(defn smaller []
  (setf *big* (dec (guess-my-number)))
  (guess-my-number))

(defn bigger []
  (setf *small* (inc (guess-my-number)))
  (guess-my-number))