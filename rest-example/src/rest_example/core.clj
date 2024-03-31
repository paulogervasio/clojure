(ns rest-example.core
  (:require [org.httpkit.server :as server]
            [compojure.route :as route]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class))

;(defroutes app-routes
;           (GET "/users" [] user-handler)
;           (POST "/users/add" [] adduser-handler)
;           (PUT "/user/update" [] update-city)
;           (DELETE "/user/delete" [] delete-user))



; Simple Body Page
(defn simple-body-page [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body (str (json/write-str {:message "Hello, World!"}))})

(defroutes app-routes
           (GET "/" [] simple-body-page)
           (route/not-found "Error, page not found!"))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3001"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    ; Run the server without ring defaults
    ;(server/run-server #'app-routes {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))

;(defn -main
;  "I don't do a whole lot ... yet."
;  [& args]
;  (println "Hello, World!"))
