(ns lol.ch1)
;;; Chapter 1 - first game "Guess my number"
;;; Imagine a number between 1 and 100 and start with (guess-my-number)
;;;
;;; Example (imagined 12)
;;; lol.ch1=> (guess-my-number)
;;; 50
;;; lol.ch1=> (smaller)
;;; 25
;;; lol.ch1=> (smaller)
;;; 12


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

(defn start-over []
  (reset! SMALL   1)
  (reset! BIG   100)
  (guess-my-number))