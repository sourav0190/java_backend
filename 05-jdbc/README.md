# 05 - JDBC (Java Database Connectivity)

## What concept it covers
- **Connection Management**: DriverManager and DataSource.
- **SQL Execution**: Statement, PreparedStatement, and CallableStatement.
- **Result Sets**: Processing query results.
- **Transaction Management**: Commit and Rollback.

## Why it exists
Before using JPA/Hibernate, it's vital to understand how Java communicates with relational databases at a low level.

## What I will learn from it
- How to write raw SQL in Java.
- How to handle database connections and resources safely.

## Important Notes
- Always close database connections to prevent memory leaks.
- Use `PreparedStatement` to prevent SQL Injection.
