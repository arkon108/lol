(ns lol.ch3)
;;; Chapter 3 Exploring the Syntax of Lisp Code

;; FIXME, code below is unedited Lisp

;; ch3 - Exploring the Syntax of Lisp Code

;; Random function, can be considered as a list of nested lists
(defun square (n)
  (* n n))

;; Lisp is case-insensitive
;; Example: are two symbols identical?
(eq 'foOo 'FOoo)
;>T

;; Lisp "poisons" the result of integer plus floating point
(+ 1 1.0)
;>2.0

;; Pretty impressive number manipulation
;; example: 64 to the power of 64
(expt 64 64)
;>39402006196394479212279040100143613805079739270465446667948293404245721771497210611414266254884915640806627990306816

;; something weird happens when you divide two numbers
(/ 4 6)
;>2/3

;; Note: Lisp will poison division if includes a floating point
(/ 4.0 6)
;>0.6666667

;; Display a string
;; the first appearance of the string in the output is because the
;; evaluating princ will return the string entered
(princ "I love big butts")
;>I love big butts
;>"I love big butts"


;; Data Mode and Code mode
;; Code mode is a default one, where anything entered is evaluated
;; Data mode is quoting the code

(expt 2 3)
;>8

'(expt 2 3)
;>(expt 2 3)

;; Lists being crucial, function calls are also lists, where the first element is the
;; function name, which could also be considered an operator
(expt 4 2)
;>16

;; Cons cells -> elements of List (linked) lists, all lists in Lisp are linked
;; cons       -> constructs a list (append more elements)
;; car        -> first
;; cdr        -> rest, next

(cons 'chicken 'cat)
;>(CHICKEN . CAT)

;; Consing an element to nil will give us a list w/ one element
;; nil is special symbol used to terminate a list
(cons 'chicken 'nil)
;>(CHICKEN)

;; Empty list symbol () can be used interchangeably with nil
(cons 'chicken ())
;>(CHICKEN)

;; In Lisp, a chain of cons cells and a list are exactly the same thing
;; 
(cons 'port '(beef chicken))
;>(PORT BEEF CHICKEN)

;; car is the "first" function, returning the first element of a list
(car '(pork beef chicken))
;>PORK

;; cdr is the "next" or "rest"
(cdr '(pork beef chicken))
;>(BEEF CHICKEN)


;; cadr gets the second element and is equivalent to
(car (cdr '(pork beef chicken)))
;>BEEF

(cadr '(pork  beef chicken))
;>BEEF

;; "list" function creates a list from the symbols
(list 'sugar 'spice 'everything 'nice)
;>(SUGAR SPICE EVERYTHING NICE)

;; Nested list
'(cat (duck bat) ant)
;>(CAT (DUCK BAT) ANT)

;; now some functions

(cddr '((sushi ramen soba) (pork chicken beef) fish))
;>(FISH)

(caddr '((sushi ramen soba) (pork chicken beef) fish))
;>FISH

(cddar '((sushi ramen soba) (pork chicken beef) fish))
;>(SOBA)

(caddar '((sushi ramen soba) (pork chicken beef) fish))
;>SOBA

;; Lisp defines these, any c*r will work out-of-the box up to four levels deep
;; exercise: make cadadar work