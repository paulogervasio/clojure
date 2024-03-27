(ns datomic-example-connection.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(require '[datomic.api :as d])
(println "connect to database...")
(def db-uri "datomic:dev://172.17.0.2:4334/hello?password=unsafe")
(def conn (d/connect db-uri))
(println "trx")
@(d/transact conn [{:db/doc "Hello world999"}])
(println "done")