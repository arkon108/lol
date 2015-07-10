(ns lol.ch3 (:require [clojure.math.numeric-tower :as math]))

;;; Chapter 3 Exploring the Syntax of Lisp Code

;; Random function, can be considered as a list of nested lists
(defn square [n]
  "Gives a square of passed argument"
  (* n n))


;; FIXME, code below is unedited Lisp
;; Lisp is case-insensitive
;; Example: are two symbols identical?
;(eq 'foOo 'FOoo)
;;>T
;;; Clojure is case-sensitive, so above yields false
(= 'foOo 'FOoo)
;> false

;; Lisp (and Clojure) "poisons" the result of integer plus floating point
(+ 1 1.0)
;>2.0

;; Pretty impressive number manipulation
;; example: 64 to the power of 64
;(expt 64 64)
;>39402006196394479212279040100143613805079739270465446667948293404245721771497210611414266254884915640806627990306816
;; 
;; After some adventurous Googling, I figured how to add the numeric-tower library
;; to Clojure to rewrite
(math/expt 64 64)
;>39402006196394479212279040100143613805079739270465446667948293404245721771497210611414266254884915640806627990306816N

;; Something weird happens when you divide two numbers
(/ 4 6)
;>2/3

;; Note: Lisp will poison division if includes a floating point
(/ 4.0 6)
;>0.6666667
; Clojure
;>0.6666666666666666

;;; Display a string
;;; the first appearance of the string in the output is because the
;;; evaluating princ will return the string entered
;(princ "I love big butts")
;;>I love big butts
;;>"I love big butts"

; Clojure
(print "I love big butts")
;>I love big buttsnil
(print-str "I love big butts")
;>"I love big butts"

;; Data Mode and Code mode
;; Code mode is a default one, where anything entered is evaluated
;; Data mode is quoting the code
;Lisp
;;(expt 2 3)
;;>8
;Clojure
(math/expt 2 3)

; Quoting: 
'(expt 2 3)
;>(expt 2 3)

;; Lists being crucial, function calls are also lists, where the first element is the
;; function name, which could also be considered an operator
;(expt 4 2)
;;>16

;; Cons cells -> elements of List (linked) lists, all lists in Lisp are linked
;; cons       -> constructs a list (append more elements)
;; car        -> first
;; cdr        -> rest, next

;(cons 'chicken 'cat)
;>(CHICKEN . CAT)

;; Clojure - 2nd arg must be a list? 
;; seems crappy no?
(cons 'chicken ())
(cons 'chicken 'nil)
(cons 'chicken nil)
;>(chicken)

;; Consing an element to nil will give us a list w/ one element
;; nil is special symbol used to terminate a list
(cons 'chicken 'nil)
;>(CHICKEN)

;; Empty list symbol () can be used interchangeably with nil
(cons 'chicken ())
;>(CHICKEN)

;; In Lisp, a chain of cons cells and a list are exactly the same thing
;; 
(cons 'pork '(beef chicken))
;>(PORK BEEF CHICKEN)

;; car is the "first" function, returning the first element of a list
;(car '(pork beef chicken))
;>PORK
; Clojure
(first '(pork beef chicken))
;>pork

;; cdr is the "next" or "rest"
;(cdr '(pork beef chicken))
;;>(BEEF CHICKEN)
; Clojure
(rest '(pork beef chicken))
;>(beef chicken)

;; cadr gets the second element and is equivalent to
;(car (cdr '(pork beef chicken)))
;>BEEF

;(cadr '(pork  beef chicken))
;>BEEF

;; "list" function creates a list from the symbols
;(list 'sugar 'spice 'everything 'nice)
;>(SUGAR SPICE EVERYTHING NICE)

;; Nested list
'(cat (duck bat) ant)
;>(CAT (DUCK BAT) ANT)

;; now some functions

;(cddr '((sushi ramen soba) (pork chicken beef) fish))
;>(FISH)

;(caddr '((sushi ramen soba) (pork chicken beef) fish))
;>FISH

;(cddar '((sushi ramen soba) (pork chicken beef) fish))
;>(SOBA)

;(caddar '((sushi ramen soba) (pork chicken beef) fish))
;>SOBA

;; Lisp defines these, any c*r will work out-of-the box up to four levels deep
;; exercise: make cadadar work