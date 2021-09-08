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

;; Definition eines "Counters" (der keiner ist)
(def counter 15)

;; erhöhe um 1
(inc counter)

;; immer noch 15 -> immutable data
counter

;; Funktionen

(defn add1
  [x]
  (+ 1 x))

(defn factorial
  [n]
  (if (= n 1)
    1
    (* n (factorial (dec n)))))

;; lokale Bindungen

(let [x 5
      y 7]
  (+ x y))


;;; ENDE Syntax, Definitionen

(defn do-smth [x y]
  (if (> x 0)
    "Ja"
    y))
