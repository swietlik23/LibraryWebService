# LibraryWebService
---
This application is created to learn the Spring Boot framework.
__LibraryWebService__ currently allows you to manage the library service (book management, user management, loans, returns, penalty fees).
In the future it is planned to add, among other things, a module that will suggest readers specific items to borrow based on their borrowing history.
The application is embedded in Heroku, so you can run it quickly and easily.

### Table of contents

---

* [Build with](#build-with)

* [Data source](#data-source)

* [Presentation](#presentation)

* [Accessing secured endpoints](#accessing-secured-endpoints)

* [Heroku](#heroku)

* [Status](#status)

### Build with
---
* Java 11

* Spring Boot

* Hibernate

* JPA

* Spring Security

* PostgreSQL

* Swagger

* JUnit5

### Data source
---
The project is based on a collection of books from the Kaggle website. Data contains more than 9,000 items.
(https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks).

### Presentation
---
Here is an actual database schema which is in progress.

![Database schema](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/dbschema.PNG)

_Swagger endpoints_ (to access them, you need to go through an authorization process -> see section below)

![SwaggerEndpoints](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/swagger_endpoints.PNG)

_Find book by title (SWAGGER)_

![FindBookByTitle](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getBookByTitle.PNG)

_Get reader before books returning (SWAGGER)_

![GetSingleReader](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getSingleReader.PNG)

_Get reader after books returning (SWAGGER)_

![GetSingleReaderAfterReturning](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getSingleReaderAfterReturns.PNG)

_Get financial transactions after books returning and money transfer (SWAGGER)_

![GetFinancialTransactions](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/getReaderFinancialTransactionsAfterReturning.PNG)

### Accessing secured endpoints
---
This section is based on articles posted on the nullpointerexception.pl blog (this contains some of the code provided by the blog's author).

In order to access secure endpoints, you need to go through the authentication process according to the following instructions.
The token validity time is set to __15 minutes__.

_Step #1_

![Log in #1](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/login1.png)

_Step #2_

![Log in #2](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/login2.png)

_Step #3_

![Log in #3](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/login3.png)

_Step #4_

![Log in #4](https://github.com/swietlik23/LibraryWebService/blob/main/picturesToReadeMe/login4.png)

---
### Heroku
---
You can test the application on Heroku: https://libraryservice.herokuapp.com/swagger-ui.html#/

### Status
---
The project is in progress with some active features and another improvements to make.

##### _Features_

* CRUD operations on Reader, Borrowing, Book, FinancialTransaction objects

* Use of Pagination during searches

* Automatic calculation of penalty charges if the return deadline is exceeded

* An authorization necessary to access endpoints

##### _To do_

* Implementation of administrator and user accounts

* Adding a book categories table (not included in the accompanying data from Kaggle)

* Creating a borrowing history table

* Creating a table with suggested books to borrow

* Email and sms notification service (notifications of upcoming return date)

* Create unit tests for the rest of the classes

* Integration Testing

---
