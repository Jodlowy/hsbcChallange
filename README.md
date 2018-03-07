# hsbc_challange

Posting short messages with ability to follow other users with REST API

### [](https://github.com/Jodlowy/hsbc_challange#features)Features

-   post new tweet
-   register by adding tweet
-   get all posted tweets
-   get all posted tweets of followed users

### [](https://github.com/Jodlowy/hsbc_challange#build)Build

```
./gradlew clean build

```

### [](https://github.com/Jodlowy/hsbc_challange#api)API:

```
Title: Post tweet
Description: Posts new tweet, validate it's content, adds user if needed
URL: /posting 
Method: POST 
Success response: 
	Status: 200, 
	Content: 
Error resposne: 
	Status: 400, 
	Contet: { "timestamp": "2018-03-07T09:10:33.600+0000","status": 400, "error": "Bad Request","message": "Tweet message too long.","path": "/posting"}

Title: Get wall 
Description: Returns list of user's tweets in reverse chronological order 
URL: /wall 
Method: GET 
Succes response: 
	Status: 200, 
	Content: [{ "user": {"name": "Alice"},"content": "Lorem ipsum dolor sit amet","id": 1,"date": "2018-03-07T10:07:17.303"}\]

Title: Get Timeline 
Description: Returns list of followed user's tweets in reverse chronological order 
URL: /timeline 
Method: GET Succes response: 
	Status: 200, 
	Content: [{ "user": {"name": "Bob"},"content": "Lorem ipsum dolor sit amet","id": 1,"date": "2018-03-07T10:07:17.303"}\] Error response: 
	Status: 401, 
	Contetnt: { "timestamp": "2018-03-07T09:41:26.606+0000", "status": 401, "error": "Unauthorized", "message": "User not logged in.", "path": "/wall" }

Title: Follow user 
Description: Follow other user 
URL: /followin 
Method: POST 
Success response: 
	Status: 200, 
	Content: 
Error response: 
	Status: 400, 
	Content: { "timestamp": "2018-03-07T09:31:14.378+0000", "status": 400, "error": "Bad Request", "message": "User not found", "path": "/following" }

	Status: 401,
	Contetnt: { "timestamp": "2018-03-07T09:41:26.606+0000", "status": 401, "error": "Unauthorized", "message": "User not logged in.", "path": "/wall" }

```

### [](https://github.com/Jodlowy/hsbc_challange#assumptions)Assumptions

-  user name is unique

### [](https://github.com/Jodlowy/hsbc_challange#possible-upgrades)Possible upgrades

-   add tests
-   use database for both users and tweets
-   add more tweet operations (remove, modify, clear, get value without closing)
- add user profile, upgrade user
