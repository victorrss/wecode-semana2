(ns clobankwithtests.core-test
  (:require [clojure.test :refer :all]
            [clobankwithtests.core :refer :all]
            [clobankwithtests.logic :as cb.logic]
            [clobankwithtests.db :as cb.db]
            [schema.core :as s]))

(s/set-fn-validation! true)

(deftest transactions-by-category-test
  ; Boundary Test
  (testing "Quando há algum elemento"
    (is (= [{"Alimentação" 190.0} {"Saúde" 740.8} {"Educação" 320.4}]
           (cb.logic/transactions-by-category cb.db/clobank-database))))
  ;(testing "Quando não há elemento"
  ;  (is (= []
  ;         (cb.logic/transactions-by-category []))))
  ;(testing "Quando a entrada é nula"
  ;  (is (not= []
  ;         (cb.logic/transactions-by-category nil))))
  )