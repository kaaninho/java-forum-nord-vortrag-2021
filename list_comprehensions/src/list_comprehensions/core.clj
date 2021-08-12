(ns list-comprehensions.core)

(comment

  ;; Ziel
  ;; (lc [(* x x) for x in [1 2 3 4] where (> x 2)])

  (defmacro lc
    [form]
    (let [sym      (first form)
          variable (nth form 2)
          lis      (nth form 4)
          pred     (nth form 6)]
      `~lis)))


(comment
  ;; Ziel
  ;; (lc [x for x in [1 2 3 4] where (> x 2)])


  (defn make-pred-fn
    [sym pred]
    `(fn [~sym]
       ~pred))

  (defmacro lc
    [form]
    (let [sym      (first form)
          variable (nth form 2)
          lis      (nth form 4)
          pred     (nth form 6)]
      `(filter ~(make-pred-fn variable pred)
               ~lis))))

(defn make-pred-fn
  [sym pred]
  `(fn [~sym]
     ~pred))

(defn make-map-fn
  [sym fn-form]
  `(fn [~sym]
     ~fn-form))

(defmacro lc
  [form]
  (let [sym      (first form)
        variable (nth form 2)
        lis      (nth form 4)
        pred     (nth form 6)]
    `(map ~(make-map-fn variable sym)
          (filter ~(make-pred-fn variable pred)
                  ~lis))))

(lc [(* x x) for x in [1 2 3 4] where (> x 2)])


;; Aber: "normaler Weg" sogar kürzer bzgl. Zeichen und für funktionale
;; Programmierinnen sehr gut lesbar
;; Deshalb oft: Solche Makros nicht nötig
;; Außer z. B. DSLs für "Fachfremde" o. ä.
(map #(* % %) (filter #(> % 2) [1 2 3 4]))
