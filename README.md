# datasources-sum

A simple operation of adding numerical data from different sources.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Required:

```
Java 8
Maven
Lombok
```

### Installing

Install Lombok plugin in the IDE of your choice and build project using Maven.

### Running

Run application and open the following link in the browser:

```http://localhost:8080/sum```

* It returns a sum of numbers from the following sources:
*    1 : given value from the database
*    2 : random number
*    3 : number received via REST API

(or in case of an error, a default value, zero)
