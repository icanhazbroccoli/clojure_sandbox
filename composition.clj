(ns io.whitebox.clojure.sandbox.composition)

(def request {:headers {"Authorization" "auth" "X-RequestFingerprint" "fingerprint"} :body "body"})

(defn check-authorization [request]
  (let [auth-header (get-in request [:headers "Authorization"])]
    (assoc request :principal (if-not (nil? auth-header) "AUser"))))

(defn log-fingerprint [request]
  (let [fingerprint (get-in request [:headers "X-RequestFingerprint"])]
    (println (str "FINGERPRINT=" fingerprint))
    request))

(defn compose-filters [filters]
  (reduce
    (fn [all-filters current-filter] (comp all-filters current-filter))
    filters))

(def filter-chain (compose-filters [check-authorization log-fingerprint]))

