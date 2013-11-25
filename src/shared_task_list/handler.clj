(ns shared-task-list.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]))

(defrecord Task [id title completed])

(defn get-tasks [task-list]
  (def xiayun (->Task 1 "Kiss Xiayun" false))
  [xiayun (->Task 2 "Take out trash" false)]
  )

(defn save-task [task-list id]
  (->Task 3 "New Task" false)
  )


(defroutes app-routes
  (GET "/" [] "Hello Davey!")
  (GET "/tasks/:task-list" [task-list] (json/write-str (get-tasks task-list)))
  (POST "/tasks/:task-list/:id" [id task-list] (json/write-str (save-task (task-list id))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
