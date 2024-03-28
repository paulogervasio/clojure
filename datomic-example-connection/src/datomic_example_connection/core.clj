(ns datomic-example-connection.core
  (:require [datomic.api :as d]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(println "connect to database...")
(def db-uri "datomic:dev://172.17.0.2:4334/hello?password=unsafe")
(def conn (d/connect db-uri))

(defn insert-new-entity
  "Insert a new entity into Datomic"
  [x]
  (println "insert a new trx")
  @(d/transact conn [{:db/doc "Hello world10000000000000000123"}])
)

(insert-new-entity "xxxx")
