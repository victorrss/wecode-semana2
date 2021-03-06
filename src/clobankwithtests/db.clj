(ns clobankwithtests.db
  (:import (java.util UUID)))
(require '[java-time :as java-time])

(def customer1 {:guid         (UUID/fromString "3fe728fc-216b-402d-9927-d5c2ac0cefa7"),
                :name         "Joao Clojure",
                :cpf          "12312312312",
                :email        "joaoclojure@gmail.com",
                :credit-cards [{:guid         (UUID/fromString "16f476bc-a4aa-4254-8552-c3b6b99e98d0"),
                                :number       "1111222233334444",
                                :cvv          123,
                                :valid        "04/2022",
                                :limit        5234,
                                :transactions [{:guid     (UUID/fromString "38146102-16c7-4a21-ace8-c17bccecc546"),
                                                :date     (java-time/local-date-time 2021 07 26 8 34),
                                                :amount   15.00,
                                                :merchant "Bar do Seu Zé",
                                                :category "Alimentação",
                                                },
                                               {:guid     (UUID/fromString "1f4bab0c-b0c4-4723-ba3f-be9fe7a7acb2"),
                                                :date     (java-time/local-date-time 2021 07 26 12 0),
                                                :amount   320.40,
                                                :merchant "Clínica Sorriso Feliz",
                                                :category "Saúde",
                                                },
                                               {:guid     (UUID/fromString "f6e8b759-3059-43a0-aee4-96916de989d6"),
                                                :date     (java-time/local-date-time 2021 07 27 9 48),
                                                :amount   110.20,
                                                :merchant "Hi Lorena Idiomas",
                                                :category "Educação",
                                                },
                                               {:guid     (UUID/fromString "cfff8b7c-9186-4bc3-83a4-870eb94040dc"),
                                                :date     (java-time/local-date-time 2021 06 28 15 22),
                                                :amount   70.00,
                                                :merchant "Mosca Frita",
                                                :category "Alimentação",
                                                }]}]})

(def customer2 {:guid         (UUID/fromString "38146103-216b-402d-9927-d5c2ac0cefa2"),
                :name         "Maria Clojure",
                :cpf          "12312312312",
                :email        "ma_clojure@gmail.com",
                :credit-cards [{:guid         (UUID/fromString "16f476bc-a4aa-4254-8552-c3b6b99e98d1"),
                                :number       "1111222233334444",
                                :cvv          123,
                                :valid        "04/2022",
                                :limit        5234,
                                :transactions [{:guid     (UUID/fromString "38146102-16c7-4a21-ace8-c17bccecc516"),
                                                :date     (java-time/local-date-time 2021 07 26 8 34),
                                                :amount   25.00,
                                                :merchant "Bar do Seu Zé",
                                                :category "Alimentação",
                                                },
                                               {:guid     (UUID/fromString "1f4bab0c-b0c4-4723-ba3f-be9fe7a7a3b2"),
                                                :date     (java-time/local-date-time 2021 06 26 12 0),
                                                :amount   420.40,
                                                :merchant "Clínica Sorriso Feliz",
                                                :category "Saúde",
                                                },
                                               {:guid     (UUID/fromString "f6e8b759-3059-43a0-aee4-96916d3989d6"),
                                                :date     (java-time/local-date-time 2021 07 27 9 48),
                                                :amount   210.20,
                                                :merchant "Hi Lorena Idiomas",
                                                :category "Educação",
                                                },
                                               {:guid     (UUID/fromString "cfff8b74-9186-4bc3-83a4-870eb94040dc"),
                                                :date     (java-time/local-date-time 2021 07 28 15 22),
                                                :amount   80.00,
                                                :merchant "Mosca Frita",
                                                :category "Alimentação",
                                                }]}]})

(def clobank-database [customer1, customer2])