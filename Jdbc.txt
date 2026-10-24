1]Explain indetail about JDBC ?
    ->JDBC stands for java database connectivity
    ->JDBC is an API that allows java programs to connect and interact with the database
    ->To make my java application to connect and interact with the database i will follow 6 steps:-
        i)Load the driver class
        ii)Establish a connection to database
        iii)Create statement or preparedstatement
        iv)Execute query
        v)process the result
        vi)close the connection

2]What is the role of DriverManager in JDBC ?

    ->It manages a list of database drivers
    ->It is used to establish a connection to a database using getConnection()
    ->getConnection() will accept 3 parameters 
        i)Database URL
        ii)Database username
        iii)Database password


3]Explain different types of Drivers in JDBC ?

    ->In JDBC thier are 4 different types of drivers:-
        i)JDBC-ODBC Bridge driver
        ii)Native API
        iii)Netword protocol Driver
        iv)Thin Driver (which is most widely used because it is platform independent and requires no native libraries)


4]Difference between statement vs prepared statement vs callable statement ?
    ->Statement is used for static SQL queries
    ->PreparedStatement is used for dynamic queries with parameters and it is more secure and prevents SQL injection problem.
    ->Callable statement is used to call the stored procedures from java using JBDC



5]What is auto-commit in JDBC ?

    ->By default JDBC commits after every SQL execution,we can turn it off using connection.setAutoCommit(false);.


6]How do you handle transactions in JDBC ? 

    ->To handle transactions in JDBC 
        i)turn off the AutoCommit
        ii)Perform operations
        iii)commit or rollback

    
7]What is batch processing in JDBC ?

    ->Batch processing in jdbc,executes a batch of SQL commands in single go using addBatch() and executeBatch().


8]What is ResultSet in JDBC ?

    ->ResultSet is an object that stores the data retrived from the database.


9]How do you handle resources properly in JDBC ?

    ->To handle resoruce properly in JDBC i will use finally block or try with resource to close Connection,Statement and ResultSet.


10]How do you prevent SQL injection in JDBC ?

    ->To prevent SQL injection in JDBC i will use preparedStatement instead of concatinating the Strings in Statement.

11]What is connection pooling and why is it important ?

    ->Connection pooling means re-using existing database connections and it improves the performance.


12]Can we use multiple ResultSets on a single Statement object ?

    ->No,only one ResultSet per statement is allowed at a time.


13]What happens if you don’t close the JDBC resources ?

    ->It may lead to memory leaks,connection exhaustion and poor performance.


14]What is the use of execute(), executeQuery(), and executeUpdate() ?

    ->execute() : for any SQL
    ->executeQuery() -> to perform READ operations
    ->executeUpdate() -> to perform INSERT,UPDATE and DELETE.

15]How do you handle exceptions in JDBC?

    ->To handle exceptions in JDBC i will make use of try-catch block for SQLExceptions.


16]What is SQL Injection ?

    ->SQL Injection is a process where attacker manipulates the SQL query by injecting malicious input
