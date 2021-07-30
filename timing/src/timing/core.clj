(ns timing.core
  (:gen-class))


(defn do-something
  []
  (mapv inc (range 20000000))
  "finished")

(let [before (System/currentTimeMillis)
      calc   (do-something)
      after  (System/currentTimeMillis)]
  (println "ms: " (- after before))
  calc)


(defmacro timing [form]
  `(let [before# (System/currentTimeMillis)
         calc#   ~form
         after#  (System/currentTimeMillis)]
     (println "ms: " (- after# before#))
     calc#))

(timing (do-something))
