(ns clobankwithtests.model
  (:require [schema.core :as s]
            [java-time :as java-time]))

(def vector-empty clojure.lang.PersistentVector/EMPTY)


(s/def TotalByCategory {s/Str s/Num})


(def IsLocalDateTime (s/pred java-time/local-date-time? 'local-date-time?))

(def Transaction
  {
   :guid     s/Uuid,
   ;:date     java-time/local-date-time,
   ;:date     java-time/local-date-time?,
   :date     IsLocalDateTime,
   :amount   s/Num
   :merchant s/Str
   :category s/Str
   })

(def CreditCard
  {
   :guid         s/Uuid,
   :number       s/Str,
   :cvv          s/Num,
   :valid        s/Str,
   :limit        s/Num,
   :transactions [Transaction]
   })

(def Customer
  {
   :guid         s/Uuid,
   :name         s/Str,
   :cpf          s/Str,
   :email        s/Str,
   :credit-cards [CreditCard]
   })
