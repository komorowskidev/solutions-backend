# Solutions - backend in Java
>#### "Talk is cheap - show me the code."

This is my code I want to show you.
It's a RESTful web service in Java. 

It's deployed on Heroku (you have to wait about 30 seconds if task is sleeping):

https://solutions-backend.herokuapp.com/version

It's consuming by Angular application deployed on Heroku:

https://solutions-frontend.herokuapp.com

## REST API

### request type: GET

* application version:

`/version` 

* set of problem names:

`/names`

* problem's description and data example (param: name=[String]):

`/problem?name=...`

* solution (param: name=[String], data=[String]):

`/solution?name=...&data=...`

---

### v1.3

- added problem: Dice Rolling

### v1.2

- added problem: Blackjack Counting

### v1.1

- added problem: Median

### v1.0

- added problem: Paths in the Grid
