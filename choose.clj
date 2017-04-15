(ns io.whitebox.clojure.sandbox)

(defn choose [num first second third]
  (cond
    (= 1 num) (first)
    (= 2 num) (second)
    (= 3 num) (third)))

(defmacro simpler-choose [num first second third]
  `(cond
     (= 1 ~num) ~first
     (= 2 ~num) ~second
     (= 3 ~num) ~third))

(defn time-run [to-time]
  (let [start (System/currentTimeMillis)]
    (to-time)
    (- (System/currentTimeMillis) start)))

(defmacro avg-time [times to_time]
  `(let [total-time#
         (apply + (for [_# (range ~times)] (time-run (fn [] ~to-time))))]
     (float (/ total-time# ~times))))
