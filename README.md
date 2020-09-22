# Solutions - backend in Java

This application solves selected programming task for the given data.
It's communicate by RESTful API.

It's deployed on Heroku (you have to wait about 20 seconds if task is sleeping):

try me: https://solutions-backend.herokuapp.com/api/v1/version

I created it for use by my Angular application deployed on Heroku:

https://solutions-frontend.herokuapp.com

# REST API

## Version

returns application version

* URL:

`/api/v1/version`

* method: 

`GET`

## Get Problem List

returns list of Problems with specified fields

* URL:

`/api/v1/problems?fields=...`

* method:

`GET`

* URL Params:

Required:

`fields=[string]`

* Example:

`/api/v1/problems?fields=id,name,description,example`

## Get Problem

returns JSON data about a single Problem

`/api/v1/problems/:{id}`

* method:

`GET`

* URL Params:

Required:

`id=[long]`

## Get solution

returns solution of specified problem

`/api/v1/problems/:{id}`

* method 

`POST`

* URL Params:

Required:

`id=[long]`

* Data Params:

Required:

`data=[string]`

---
### v1.4.1

- bugfixing: return solution as map

### v1.4

- new REST API

### v1.3

- added problem: Dice Rolling

### v1.2

- added problem: Blackjack Counting

### v1.1

- added problem: Median

### v1.0

- added problem: Paths in the Grid
