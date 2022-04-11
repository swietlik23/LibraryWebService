# LibraryWebService
---
This application is created to learn the Spring Boot framework. 
__LibraryWebService__ currently allows you to manage the library service (book management, user management, loans, returns, penalty fees). 
In the future it is planned to add a module that will suggest readers specific items to borrow based on their borrowing history.

### Table of contents

---

* [Build with](#build-with)

* [Data source](#data-source)

* [Presentation](#presentation)

* [Heroku](#heroku)

* [Status](#status)

### Build with
---
* Java 11

* Spring Boot

* Hibernate

* JPA

* PostgreSQL

* Swagger

### Data source
---
The project is based on a collection of books from the Kaggle website. Data contains more than 9,000 items.
(https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks).

### Presentation
---
Here is an actual database schema which is in progress.

![Database schema](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/dbschema.PNG)

_Swagger endpoints_

![SwaggerEndpoints](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/swagger_endpoints.PNG)

_Find book by title (SWAGGER)_

![FindBookByTitle](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getBookByTitle.PNG)

_Get reader before books returning (SWAGGER)_

![GetSingleReader](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getSingleReader.PNG)

_Get reader after books returning (SWAGGER)_

![GetSingleReaderAfterReturning](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getSingleReaderAfterReturns.PNG)

_Get financial transactions after books returning and money transfer (SWAGGER)_

![GetFinancialTransactions](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getReaderFinancialTransactionsAfterReturning.PNG)

### Heroku
---
You can test the aplication on Heroku: https://libraryservice.herokuapp.com/swagger-ui.html#/

### Status
---
Project is in progress with some active features and another improvements to make.

##### _Features_

* CRUD operations on Reader, Borrowing, Book, FinancialTransaction objects

* Use of Pagination during searches

* Automatic calculation of penalty charges if the return deadline is exceeded

##### _To do_

* Updating of response statuses

* Implementation of administrator and user accounts

* Adding a book categories table (not included in the accompanying data from Kaggle)

* Creating a borrowing history table

* Creating a table with suggested books to borrow

* Email and sms notification service (notifications of upcoming return date)

---
