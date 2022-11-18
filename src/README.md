### Tasks
Observation/code explanation tasks:
Please go through the whole code base to get an understanding of it. Afterwards, specifically go through the code in Restaurant.java, methods "getTable", "getAvailableTable", "getAvailableServer" and write a brief description of what the methods are doing.

Coding/modifying tasks
1. Get the first table optimally: Implement the function getAvailableTableOptimal() in such a way that it returns a table whose capacity is just greater than the guest count.
2. Reduce already served items to get final bill amount: Implement the function generateBill() in Table.java.
3. Merge two tables with served and pending items. Iterate over both lists to change the resulting table number. (Final study)
 (think about the destruction of original 2 tables and creation of new, once the bill is paid for the new restore original tables)