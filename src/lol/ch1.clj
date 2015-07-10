(ns lol.ch1)
;;; Chapter 1 - first game "Guess my number"
;;; Imagine a number between 1 and 100 and start with (guess-my-number)
;;;
;;; This is an example of a binary search
;;; 
;;; Example (imagined 12)
;;; => (guess-my-number)
;;; 50
;;; => (smaller)
;;; 25
;;; => (smaller)
;;; 12
;;; 



;; Original Lisp uses *earmuffs* vars which throws a warning in Clojure
;; “variables must be declared dynamic 
;; in order to change their bound value: (def ^:dynamic x 1)” 
(def SMALL (atom   1))
(def BIG   (atom 100))

;; always guesses the half between small and big
(defn guess-my-number []
  ;; original (ash (+ *small* *big*) -12)
  ;; arithmetic shift, or bit shifting halves or doubles numbers
  (bit-shift-right (+ @SMALL @BIG) 1)
)


;; (reset! atom neval)
;; sets the value of atom to new value, returns newval
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