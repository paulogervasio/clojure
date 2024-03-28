(ns datomic-example-connection.core
  (:use clojure.pprint)
  (:require [datomic.api :as d]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(println "connect to database...")
(def db-uri "datomic:dev://172.17.0.2:4334/hello?password=unsafe")
(println "create hello database...")
(d/create-database db-uri)
;(d/delete-database db-uri)

(println "connect to database")
(def conn (d/connect db-uri))

(defn insert-new-entity
  "Insert a new entity into Datomic"
  [x]
  (println "insert a new trx 1")

  (def schema [
                        {:db/ident         :person/name
                        :db/valueType     :db.type/string
                        :db/cardinality   :db.cardinality/one
                        :db/doc           "Person's name"
                        }
                        {:db/ident         :person/id
                        :db/valueType     :db.type/string
                        :db/cardinality   :db.cardinality/one
                        :db/doc           "Person's ID"
                        }
                     ])
  (println "Creating schema")
  (d/transact conn schema)

  (println "Inserting data into schema with ID")
  (d/transact conn [{
                     :person/name "PauloHI3"
                     :person/id "ID TESTE1"
                     }])
)

(insert-new-entity "xxxx")