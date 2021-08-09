(ns clobankwithtests.core
  (:require [clobankwithtests.logic :as cb.logic]
            [clobankwithtests.db :as cb.db])
  (:use clojure.pprint))

;(println "\nTransações por cliente e categoria: ")
;(pprint (cb.logic/transactions-by-customer-category))

(println "\nTransações por categoria: ")
(pprint (cb.logic/transactions-by-category cb.db/clobank-database))

;(println "\nTransações: ")
;(cb.logic/list-transactions)
;
;(println "\nFatura do mês 7: ")
;(cb.logic/get-month-bill "" 7)
