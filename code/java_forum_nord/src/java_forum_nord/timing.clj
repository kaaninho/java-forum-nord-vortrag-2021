(ns java-forum-nord.timing)

(defn do-something
  []
  (mapv inc (range 20000000))
  "finished")

(let [before (System/currentTimeMillis)
      result (do-something)
      after  (System/currentTimeMillis)]
  (println "ms: " (- after before))
  result)


(defmacro timing [form]
  `(let [before# (System/currentTimeMillis)
         result#  ~form
         after#  (System/currentTimeMillis)]
     (println "ms: " (- after# before#))
     result#))

(timing (do-something))
