test project
---
---
#### _Technologies:_
- Java 17
- Spring Boot (MVC, REST)
- JUnit (Mockito)
- Lombok

#### _Task:_

Design (plan the format and constraints of incoming/outgoing parameters) and implement a REST API that calculates the frequency of character occurrences in a given string. The result should be sorted in descending order of the number of occurrences of each character in the specified string.

#### _Project start:_

To start the application in port 8080:

http://localhost:8080/test?text=aabbbc

and you get the result: ["b: 3","a: 2","c: 1"]

#### _Server requests:_


```sh
GET http://localhost:8080/test?
```
- **RequestParam**:
> `text` - a client sends the text to the server and server return array. The text exceed the 100 character limit and allows English alpha characters, digits and special characters: ~.\"(),:;<>@[]!#$%&'*+-/=?^_`{|}";


