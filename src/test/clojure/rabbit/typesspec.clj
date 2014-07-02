(ns rabbit.typesspec
  (:use midje.sweet))

(fact "Getting the size of a given word"
  (expect (str "hello") => "hello"))
