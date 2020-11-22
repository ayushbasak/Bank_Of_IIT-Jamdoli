-- Create a Database named "bank" with proper authentication and replace those parameters in src/HelperClasses/SQLConnection.java

-- Consumer Table (Contains details of Consumer)
CREATE TABLE CONSUMER(
    ConsumerID INT,
    Name VARCHAR(20) NOT NULL,
    DOB VARCHAR(20) NOT NULL,
    Gender VARCHAR(1) NOT NULL,
    Address VARCHAR(100) NOT NULL,
    Pincode INT not NULL,
    AccountID INT NOT NULL,
    PRIMARY KEY(ConsumerID)
);

-- Accounts Table (Contains Account information of said Consumer)
CREATE TABLE ACCOUNTS(
    AccountID INT NOT NULL,
    AccountCreationDate VARCHAR(20) NOT NULL,
    BankAccountNumber BIGINT NOT NULL,
    PRIMARY KEY(AccountID)
);

-- Balance Table (Contains Current balance of a given registered Account Number)
CREATE TABLE BALANCE(
    CurrBalance INT NOT NULL,
    BankAccountNumber BIGINT NOT NULL
);

-- Transactions Table (Lists all transactions that occur amongst the said accounts)
CREATE TABLE "TRANSACTION"(
    BankAccountNumber BIGINT NOT NULL,
    TransactionType VARCHAR(10) NOT NULL,
    Destination BIGINT,
    Date VARCHAR(20) NOT NULL,
    Amount INT NOT NULL
);