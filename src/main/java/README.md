### Tasks

Observation/code explanation tasks:
Please go through the whole code base to get an understanding of it.
Afterwards, specifically go through the code in Restaurant.java, methods "getTable", "getAvailableTable", "
getAvailableServer" and write a brief description of what you feel the methods are doing.

Description:

getTable: Checks if a table and server are available, else returns null
getAvailableTable: Checks if a table is available and if it can seat the required number of guests
getAvailableServer: Checks if any of the servers have the capacity to serve a new table.

Coding/modifying tasks:

1. Get the optimal table available: Implement the function getOptimalAvailableTable() in such a way that it returns a
   table whose capacity is just greater than the guest count.
2. Reduce already served items to get final bill amount: Implement the function generateBill() in Table.java.
3. Reduce all the tables to get final money made by the restaurant by calculating all the table's generateBill() and
   summing up.
   Implement the function collectTableBills()

 Bug Fix task:

