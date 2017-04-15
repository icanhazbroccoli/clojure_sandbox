(ns io.whitebox.clojure.sandbox.selector)

(defn selector [& path]
  {:pre [(not (empty? path))]}
  (fn [ds] (get-in ds path)))
