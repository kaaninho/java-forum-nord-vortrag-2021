(ns java-forum-nord.switch)

(comment
  (defn prepare-statement [thing statement]
    `((= ~thing ~(first statement))
      (second '~statement)))

  (defmacro switch
    [thing & statements]
    (let [prepared-statements (mapcat (fn [s] (prepare-statement thing s))
                                      statements)]
      `(cond
         ~@prepared-statements

         :else
         (throw (Exception. (str "No match, got: " ~thing))))))

  (let [y "Work"]
    (switch y
            ("Holiday" "I am not around")
            ("Work" "How can I help?")
            ("Night" "zzZZzzzzZZ"))))


(comment
  (defn prepare-statement [thing statement]
    `((= ~thing ~(first statement))
      (second '~statement)))


  (defn prepare-more [thing statement]
    (let [[case thingy arrow then] statement]
      (prepare-statement thing (list thingy then))))

  (defmacro switch
    [thing & statements]
    (let [prepared-statements (mapcat (fn [s] (prepare-more thing s))
                                      statements)]
      `(cond
         ~@prepared-statements

         :else
         (throw (Exception. (str "No match, got: " ~thing))))))

  (let [y "Work"]
    (switch y
            (case "Holiday" -> "I am not around")
            (case "Work" -> "How can I help?")
            (case "Night" -> "zzZZzzzzZZ"))))



(defn prepare-statement [thing statement]
  `((= ~thing ~(first statement))
    (second '~statement)))


(defn prepare-more [thing statement]
  (let [[case thingy arrow then] statement]
    (prepare-statement thing (list thingy then))))

(defn prepare-statements [s]
  (partition 4 s))

(defmacro switch
  [thing & statements]
  (let [prepared-statements (mapcat (fn [s] (prepare-more thing s))
                                    (prepare-statements statements))]
    `(cond
       ~@prepared-statements

       :else
       (throw (Exception. (str "No match, got: " ~thing))))))

(let [y "Work"]
  (switch y
          case "Holiday" -> "I am not around"
          case "Work" -> "How can I help?"
          case "Night" -> "zzZZzzzzZZ"))
