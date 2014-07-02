(ns rabbit.typestest
  (:use midje.sweet)
  (:require [rabbit.types :as rab]))

(fact "Getting the size of a given word"
  (expect (.length "hello") => 5))

(fact "Using string multilines"
  (expect (not (.isEmpty "some
                    multilines")) => true))

(fact "Using nil to check true/false"
    (expect (not nil) => true))

(fact "Using characters"
    (expect \o41 => \!)
    (expect \u0049 => \I)
    (expect (class \c) => java.lang.Character))

(fact "Using keywords"
    (expect (:name (rab/build-new-person)) => "john"))


