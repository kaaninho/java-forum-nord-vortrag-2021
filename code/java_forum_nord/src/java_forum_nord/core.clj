(ns java-forum-nord.core)

;;; Kommentar

;; Ausdrücke

3

"String"

'symbol

true

(list 1 2 3)

(inc 3)

(if (> 2 3)
  "It is true"
  100)

(cond
  (> 3 4) "Ich bin nicht das Ergebnis"
  (= 3 3) "Ich bin das Ergebnis"
  (> 3 2) "Ich bin nicht das Ergebnis")

;;; Funktionen

(defn add1
  [x]
  (+ 1 x))

(defn factorial
  [n]
  (if (= n 1)
    1
    (* n (factorial (dec n)))))

;;; ENDE Syntax, Definitionen



;;; REPL und IDE

;;; zeige Dinge von oben und dann auch

;; Definition eines "Counters" (der keiner ist)
(def counter 15)

;; erhöhe um 1
(inc counter)

;; immer noch 15 -> immutable data
counter

;; lokale Bindungen

(let [x 5
      y 7]
  (+ x y))


;;; Higher Order Functions

(map inc [1 2 3])

(filter even? [1 2 3])

(filter (fn [x] (> x 2)) [1 2 3])

(reduce (fn [res x]
          (assoc res (hash x) x))
        {}
        ["hallo" "du" "!"])

;;; ENDE REPL

;;; READ UND EVAL

(read-string "(+ 1 2)")
(eval (read-string "(+ 1 2)"))

;;; ENDE READ UND EVAL

;;; Makros

(list + (list * 2 3) 4)

`(+ (* 2 3) 4)



(defmacro emit-defs [sym-name low mid high]
  `(do
     (def ~(symbol (str sym-name "-high"))
          ~high)
     (def ~(symbol (str sym-name "-mid"))
       ~mid)
     (def ~(symbol (str sym-name "-low"))
       ~low)))

(macroexpand-1 '(emit-defs kaan 1 2 3))

kaan-high
