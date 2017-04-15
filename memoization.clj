(ns io.whitebox.clojure.sandbox.memoization)

(defn expensive-lookup [id]
  (Thread/sleep 1000)
  (println (str "Lookup for " id))
  ({42 "foo" 12 "bar" 1 "baz"} id))

(def memoized-expensive-lookup
  (memoize expensive-lookup))
