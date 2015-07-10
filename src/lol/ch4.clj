(ns lol.ch4)

;; Making decisions with conditions

;; Warning, Clojure != Lisp
;;; (eq nil ())
;;; >T
(= nil ())
;;>false

;; !! Clojure != Lisp
;;; (if () 'yes 'no)
;;; >NO
(if () 'yes 'no)
;; >yes

;; List-eating-functions are ones recursively "consuming" a list
;; (defun my-length (list)      
;;   (if list
;;       (1+ (my-length (cdr list)))
;;       0))
;; This won't work in Clojure as "if list" will always return true
;; as empty list in Clojure !== nil

;;; (eq '() nil)  > T
;;; (eq '() ())   > T
;;; (eq '() 'nil) > T

(= '() nil) ;; false
(= '() ())  ;; true
(= '() 'nil);; false

;; Quote from the book:
;; The creators of the other popular dialect of Lisp, Scheme, 
;; felt differently about this issue, and preferred to keep the 
;; concepts of falsity and empty list completely separate, 
;; at a slight cost to code brevity.


(if (= (+ 1 2) 3) 'yup 'nope)
;;> yup

(if (odd? 5) 'odd-number 'even-number)
;;> yup

;; IF being a special form has special rules :)
;; it short-circuits, meaning that the division by zero in the next
;; example won't ever execute
(if (odd? 7) 'odd-num (/ 1 0))
;;>odd-num



;; Lisp's "progn" == Clojure "do"
(def NUM-WAS-ODD (atom nil))
(if (odd? 5) 
  (do 
    (reset! NUM-WAS-ODD true) 
    'odd-number) 
  'even-number)
;;> odd-number
@NUM-WAS-ODD
;;> true


;; Implicit "do" is in the "when" and "unless"
;; however, Clojure replaces "unless" with "when-not"

(def N-IS-ODD (atom nil))
(when (odd? 5) (reset! N-IS-ODD true) 'odd-number)
;;> odd-number
@N-IS-ODD
;;> true

;; (unless (oddp 4) (setf *num-is-odd* nil) 'even-number)
;;>EVEN-NUMBER
;; *num-is-odd*
;;>NIL
(when-not (odd? 4) (reset! N-IS-ODD nil) 'even-number)
;;>even-number
@N-IS-ODD
;;>nil