# Rules
demo is a banking application which features creating new accounts for its existing customers. It features the following:
  1-) Creates new accounts for its existing customers and record this transaction to the database.
      *The endpoint URL = http://localhost:8080/createAccount/
      In Postman(or an API client of your choice) choose 'POST' from the left of the url and click 'body' tab at the bottom
      and enter a json file of your choice consisting of "customerId" and "initialCredit" fields. I enter the following json for
      Demo purposes:
      {
        "customerId":1,
        "initialCredit":400
      }
      * As the application starts up with a customer Database consisting of following tables:
       CUSTOMER
       *********
       ID    NAME        SURNAME
       -------------------------------
       1      Emre        Psycho
       
       ACCOUNT 
       *********
       ID     BALANCE    CUSTOMER_ID(Primary Key)
       -------------------------------------------
       2       1000        1
       
       TRANSACTION
       ************
       ID     ACCOUNT_FROM   ACCOUNT_TO     AMOUNT        DATE   --> empty table as no transactions has been made yet.
       ------------------------------------------------------
       
       When the post request with the body consisting of {"customerId":1,"initialCredit":400}via Postman is made, as the customerId exists in
       the database and as the initialCredit > 0, a new account is created connected to the customer id 1. 
        CUSTOMER
       *********
       ID    NAME        SURNAME
       -------------------------------
       1      Emre        Psycho
       
       ACCOUNT 
       *********
       ID     BALANCE    CUSTOMER_ID(Primary Key)
       -------------------------------------------
       2       1000        1
       3        400        1
       
       
       TRANSACTION
       ************
       ID     ACCOUNT_FROM   ACCOUNT_TO     AMOUNT        DATE   --> empty table as no transactions has been made yet.
       --------------------------------------------------------------
       4        null           3              400         currentDate
   2-)Displays the customer information. *The endpoint URL = http://localhost:8080/createAccount/{customerId} -> for demo purposes I type 1 in place of customerId
      Choose 'GET' Method at the left of the url in Postman. This endpoint retrieves and displays the customer info consisting of id, name, surname, accounts and transactions
      fields.
      {
        "id": 1,
        "name": "Emre",
        "surname": "Psycho",
        "accounts": [
          {
            "id": 2,
            "balance": 1E+3
          },
          {
            "id": 3,
            "balance": 4E+2
          }
        ],
        "transactions": [
          {
            "id": 4,
            "accountFrom": null,
            "accountTo": 3,
            "amount": 4E+2,
            "date": -currentDate-
          }
         ]
        }
        
        ------------------------------------------------------------------
        -----------------------------------------------------------------
        TEST CASES
       1 - If customerId is invalid (0 or null), no account is created no matter what the 
       2 - If customerId is not found in database, no account is created
       3 - Enter customerId 1, initialCredit 500 -> CustomerId 1 has 2 accounts in accounts array, 1 transaction in its array field.
       4-  Precondition(TC#3) Enter customerId 1, initialCredit 300 -> CustomerId 1  has 3 accounts now in his accounts array, 2 transactions in its array field
       5-  Precondition(TC#3,4) Enter customerId 1, initialCredit 0 -> GET to '/retrieveCustomerInfo/1' retrieves the same result in TC#4. So No new account is created.
