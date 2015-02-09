(ns lol.ch2)
;;; Chapter 2 - local variables and local functions
;;; clojure is well better suited for this
;;;
;;; Local variables in Lisp
;(let ((a 5)
;      (b 6))
;    (+ a b))

(let [a 5
      b 6]
  (+ a b))


;;; Local functions in Lisp
; (flet ((f (n)
;           (+ n 10)))
;       (f 5))

(letfn [(f [n] 
           (+ n 10))]
  (f 5))

;;; Two Lisp local functions that don't need to call each other
;(flet ((f (n)
;          (+ n 10))
;       (g (n)
;          (- n 3)))
;  (g (f 5)))

(letfn [(f [n]
           (+ n 10))
        (g [n]
           (- n 3))]
  (g (f 5)))

;;; In Lisp, for local functions to be mutually callable]
;;; "labels" is used, where the form is identical to the flet
;(labels ((a (n)
;            (+ n 5))
;         (b (n)
;            (+ (a n) 6)))
;  (b 10))

;;; In Clojure, letfn has the functionality of both flet and labels
(letfn [(a [n]
           (+ n 5))
        (b [n]
           (+ (a n) 6))]
  (b 10))