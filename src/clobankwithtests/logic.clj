(ns clobankwithtests.logic
  (:require [clobankwithtests.db :as cb.db]
            [clobankwithtests.model :as cb.model]
            [schema.core :as s]))
(refer-clojure :exclude [range iterate format max min])
(require '[java-time :as java-time])

(defn get-total [v]
  (->> v
       (map #(get % :amount))
       (reduce +)))

(defn transform-group-with-sum
  [[k, v]]
  {
   k (get-total v)})

(defn group-total-by-category
  [ccs]
  (->> ccs
       (map :transactions)
       (reduce into [])
       (group-by :category)
       (map transform-group-with-sum)))

(defn format-transaction
  [transaction]
  (-> transaction
      (dissoc :guid)
      (update :date #(str (java-time/format "dd/MM/yyyy hh:mm" %)))
      (update :amount #(str "R$ " %))))

(defn show-formatted-transactions
  [transaction]
  (println "\nData:" (:date transaction)
           "\nValor:" (:amount transaction)
           "\nEstabelecimento:" (:merchant transaction)
           "\nCategoria:" (:category transaction)))

(defn get-amount-of-transactions-customer-by-category
  [customer]
  (->> customer
       (map :credit-cards)
       (map group-total-by-category)
       ))

(defn group-transactions-by-customer
  [[guid customer]]
  {
   :customer    guid,
   :by-category (get-amount-of-transactions-customer-by-category customer)
   })

(s/defn get-customer-credit-cards
  [customer :- cb.model/Customer]
  (->> customer
       :credit-cards
       first))

(s/defn transactions-by-category :-  [cb.model/TotalByCategory]
  [database :- [cb.model/Customer]]
  (->> database
           (map get-customer-credit-cards)
           (group-total-by-category)
           ))

(defn transactions-by-customer-category []
  (->> cb.db/clobank-database
       (group-by :guid)
       (map group-transactions-by-customer)))

(defn list-transactions []
  (->> cb.db/clobank-database
       (map get-customer-credit-cards)
       (map :transactions)
       (reduce into [])
       (map format-transaction)
       (mapv show-formatted-transactions)))


(defn get-month-bill [customer-guid month]
  (->> cb.db/clobank-database
       (filter #(= (:guid %) customer-guid))
       first
       :credit-cards
       (map :transactions)
       ;(filter #(= (:merchant /%) "Bar do Seu Zé"))
       (filter #((print %)))))
;(filterv #(= (java-time/as (get :date %) :month-of-year) month))))
