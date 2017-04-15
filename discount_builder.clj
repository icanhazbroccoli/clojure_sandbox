(ns io.whitebox.clojure.discount_builder)

(defn discount [percentage]
  {:pre [(and (>= percentage 0) (<= percentage 100))]}
  (fn [price] (* price (- 1 (*  percentage 0.01))))
)
