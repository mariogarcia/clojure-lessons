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

;; tag::basics3a[]
(def numbers '(1 2 3 4))
;; => a list
;; end::basics3a[]

;; tag::basics3b[]
(def someones-name "john")
;; => a string
;; end::basics3b[]

;; tag::basics3c[]
(def pi 3.14)
;; => a decimal
;; end::basics3c[]

;; tag::let1[]
(fact "Local bindings: let"
    (let [x 10
          y 20]
      (expect (+ x y) => 30)))
;; end::let1[]

;; tag::let2[]
(fact "Destructuring let"
    (let [v [1 2 3 4 5]]
      (expect (first v) => 1)
      (expect (last v) => 5)
      (expect (rest v) => [2 3 4 5])
      (expect (nth v 2) => 3)
      (expect (.get v 2) => 3)))
;; end::let2[]


;; tag::let3[]
(def v [1 2 3 4])
;; end::let3[]

;; tag::let4[]
(fact "Simple form of assigning values from a collection"
    (let [x (nth v 0)
          y (nth v 1)
          z (nth v 2)]
          (expect x => 1)
          (expect y => 2)
          (expect z => 3)))
;; end::let4[]

;; tag::let5[]
(fact "Destructuring in order to assign values from a collection"
    (let [[x y z] v]
          (expect x => 1)
          (expect y => 2)
          (expect z => 3)))
;; end::let5[]

;; tag::fn1[]
(fn [name]
  (str "Hola: " name))
;; end::fn1[]

;; tag::fn2[]
(defn greetings [name]
  (str "Hola: " name))
;; end::fn2[]

;; tag::fn3[]
(defn greetings [name & family-names]
  (str "Hola: " name " " (first family-names)))

(fact "Greetings must only use first family name"
    (expect (greetings "john" "sinkup" "fogerty") => "Hola: john sinkup"))
;; end::fn3[]
