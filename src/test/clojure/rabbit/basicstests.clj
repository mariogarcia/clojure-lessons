(ns rabbit.basicstests
  (:use midje.sweet))

;; tag::basics1[]
(fact "do word"
    (expect
      (do
        (println "do evaluates all expresions")
        (println "but returns the value of the last one")
        (/ 10 2)) => 5))
;; end::basics1[]

;; tag::basics2[]
(fact "collection literals"
    (expect (instance? clojure.lang.PersistentList '(a b :name 12.5)) => true)
    (expect (instance? clojure.lang.PersistentVector ['a 'b :name 12.5]) => true)
    (expect (instance? clojure.lang.PersistentArrayMap {:name "john"}) => true)
    (expect (instance? clojure.lang.PersistentHashSet #{1 2 3}) => true))
;; end::basics2[]

;; tag::basics3[]
(def numbers (1 2 3 4))
; => a list
(def someones-name "john")
; => a string
(def pi 3.14)
; => a decimal
;; end::basics3[]

;; tag::let1[]
(fact "Local bindings: let"
    (let [x 10
          y 20]
      (expect (+ x y) => 30)))
;; end::let1]

;; tag::let2[]
(fact "Destructuring let"
    (let [v [1 2 3 4 5]]
      (expect (first v) => 1)
      (expect (last v) => 5)
      (expect (rest v) => [2 3 4 5])
      (expect (nth v 2) => 2)
      (expect (.get v 2) => 2)))
;; end::let2[]


