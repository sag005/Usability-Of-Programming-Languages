### Tasks

Observation/code explanation tasks:
Please go through the whole code base to get an understanding of it.
Afterwards, specifically go through the code in Restaurant.java, methods "getTable", "getAvailableTable", "
getAvailableServer" and write a brief description of what you feel the methods are doing.

Description:

getTable: Checks for available table and server and returns the table object with assigned server. Returns null if any of them is not available
getAvailableTable: Iterates through the tables and checks if the table is available and can seat given number of guests. Returns if any such table is available or null
getAvailableServer: Checks all the servers if any of them has available capacity. Returns the server or null f not available.

Coding/modifying tasks:

1. Get the optimal available table: Implement the function getOptimalAvailableTable() in such a way that it returns a
   table whose capacity is just greater than the guest count.
2. Reduce already served items to get final bill amount: Implement the function generateBill() in Table.java.

