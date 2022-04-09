# LibraryWebService
---
This application is created to learn the Spring Boot framework. 
__LibraryWebService__ currently allows you to manage the library service (book management, user management, loans, returns, penalty fees). 
In the future it is planned to add a module that will suggest readers specific items to borrow based on their borrowing history.


### Build with
---
* Java 11

* Spring Boot

* Hibernate

* JPA

* H2 Database

* Swagger

### Data source
---
The project is based on a collection of books from the Kaggle website. Data contains more than 11,000 items.
(https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks).

### Status
---
Project is in progress with some active features and another improvements to make.

##### _Features_

* CRUD operations on Reader, Borrowing, Book, FinancialTransaction objects

* Use of Pagination during searches

* Automatic calculation of penalty charges if the return deadline is exceeded

##### _To do_

* Implementation of administrator and user accounts

* Adding a book categories table (not included in the accompanying data from Kaggle)

* Creating a borrowing history table

* Creating a table with suggested books to borrow

* Email and sms notification service (notifications of upcoming return date)


