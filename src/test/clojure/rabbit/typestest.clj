(ns rabbit.typestest
  (:use midje.sweet)
  (:require [rabbit.types :as rab]))

;; tag::scalar1[]
(fact "Getting the size of a given word"
  (expect (.length "hello") => 5))
;; end::scalar1[]

;; tag::scalar2[]
(fact "Using string multilines"
  (expect (not (.isEmpty "some
                    multilines")) => true))
;; end::scalar2[]

;; tag::scalar3[]
(fact "Using characters"
    (expect \o41 => \!)
    (expect \u0049 => \I)
    (expect (class \c) => java.lang.Character))
;; end::scalar3[]

;; tag::scalar4[]
(fact "Using nil to check true/false"
    (expect (not nil) => true))
;; end::scalar4[]

;; tag::scalar5[]
(fact "Using keywords: simple"
    (expect
        (:name {:age 22 :name "john"}) => "john"))
;; end::scalar5[]

;; tag::scalar6[]
(fact "Using keywords: namespaces"
    (let [person  {:age 22
                   :name "john"
                   :address/street "Marconi"
                   :address/number 22
                   :address/city "Madrid"}]
        (expect (:age person) => 22)
        (expect (:name person) => "john")
        (expect (:address/street person) => "Marconi")
        (expect (:address/number person) => 22)
        (expect (:address/city person) => "Madrid")
        (expect (:city person) => nil)))

;; end::scalar6[]

(fact "Using keywords 2: custom example"
    (expect (:name (rab/build-new-person)) => "john"))


;; tag::scalar7[]
(fact "Numbers"
    (expect 20/2 => 10) ;; clojure.lang.Ratio
    (expect (/ 20 2) => 10)
    (expect (+ 42N 1) => 43N)
    (expect (+ 1 1.0) => 2.0))
;; end::scalar7[]

;; tag::scalar8[]
(fact "Regular expressions"
  (let [phrase "all or nothing"]
    (expect (nth (first (re-seq #"(\w+)\s(\w+)\s(\w+)" phrase)) 1) => "all")))
;; end::scalar8[]


