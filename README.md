# WELCOME TO THE ROOM RAIDERS API

## Project aims:

This project aims to create a chatroom API which allows users to freely join and send messages into chatrooms with other users.

The Room Raiders Chatroom API can:
* `create / delete` new users
* `create / delete` new chatrooms
* `send messages` to chatrooms

Additional API functionality includes:
* enabling users to `post / retrieve images` to / from the `chatroom database`
* `adding / removing users from specific chatrooms`
* `updating user information` (`name` and `email`)
* `updating chatroom information` ( chatroom `name`)



## Technical Information:
Our project utilises the following:
* Spring Boot `version: 3.0.6`
* Maven
* Packaging: `Jar`
* Java `version: 17`
* Dependencies: `Lombok`, `Spring Data JPA`, `Spring Web`, `Spring Boot DevTools`, `PostgreSQL Driver`
* `IntelliJ IDEA JDK 17`, `PostgreSQL`, `Postico` & `Postman` to help create and visualise our code


## Installation Guide:
* Create a local database for the chatroom called `chatroom_db`. In the terminal run: `createdb chatroom_db`

* In `resources.application.properties`, copy the following code :
```
spring.datasource.url=jdbc:postgresql://localhost:5432/chatroom_db
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
```
* After running the application, you should be able to view the seeded user, chatroom, and message information from the `DataLoader` in Postman and Postico.



## Diagrams:
### UML Diagram:
![](/Users/sarah/Downloads/Screenshot 2023-04-27 at 17.56.50.png) 

### ERD Diagram:
![](/Users/sarah/Downloads/Screenshot 2023-04-27 at 17.57.25.png)



## List of routes:

### User Controller
| Route Name             | Request Type | RequestBody                      | Request Path              |
|------------------------|--------|----------------------------------|---------------------------|
| `displayAllUsers`        | GET    | null                             | `/users`                    |
| `displayUserById`        | GET    | null                             | `/users/{userId}`           |
| `editUser`               | GET    | null                             | `/users/{userId}/edit `     |
| `updateUser`             | PUT    | `UserDTO userDTO` (name & email) | `/users/{userId} `          |
| `createUser`             | POST   | `User user` (name & email)       | `/users`                    |
| `deleteUser`             | DELETE | null                             |` /users/{id}  `                  
| `displayChatroomsByUser` | GET    | null                             |` /users/{userId}/chatrooms` |


### Chatroom Controller
| Route Name             | Request Type | RequestBody                      | Request Path                                    |
|------------------------|--------------|----------------------------------|-------------------------------------------------|
| `displayAllChatrooms`    | GET          | null                             | `/chatrooms  `                                  |
| `displayChatroomById`    | GET          | null                             | `/chatrooms/{chatroomId}`                       |
| `editChatroomName`       | GET          | null                             | ` /chatrooms/{chatroomId}/edit `                |
| `updateChatroomName`     | PUT          | `ChatroomDTO chatroomDTO` (name) | `/chatrooms/{chatroomId} `                      |
| `createChatroom`         | POST         | `Chatroom chatroom`  (name)      | `/chatrooms`                                    |
| `deleteChatroom`         | DELETE       | null                             | `/chatrooms/{chatroomId} `                      
| `addUserToChatroom`      | PATCH        | null                             | `/chatrooms/{chatroomId}/users/{userId}/add`    |
| `removeUserFromChatroom` | PATCH        | null                             | `/chatrooms/{chatroomId}/users/{userId}/remove ` |

### Message Controller

| Route Name                  | Request Type | RequestBody                       | Request Path           |
|-----------------------------|--------------|-----------------------------------|------------------------|
| `sendMessage`                 | POST         | `MessageDTO messageDTO` (message) | `/messages    `          |
| `deleteMessage`               | DELETE       | null                              | `/messages/{id}`         |
| `retrieveMessagesForChatroom` | GET          | null                              |` /messages/{chatroomId}` |


### Image Controller
| Route Name             | Request Type | RequestBody                                                    | Request Path           |
|------------------------|--------------|----------------------------------------------------------------|------------------------|
| `uploadImage`            | POST         | null  (used `@RequestParam` instead. More info given below).** | ` /image`              |
| `downloadImage`          | GET          | null                                                           |`/image/{fileName}/`*** |

** `uploadImage`: the @RequestParam represents the image. See the example below:

##### An example of how to execute the `uploadImage` route in Postman:
 
   > 1) `POST` -> localhost:8080/image
   > 2) `Body` -> `form-data`
   > 3) Within `key` type in `image`
   > 4) Hover your mouse in the top-right corner of the `image` box and click on the drop-down and select `file` NOT `text`
   > 5) Type the file's name into `value`. For example: `balloons.png`


##### An example of how to execute the `downloadImage` route in Postman:
` GET ->  localhost:8080/image/balloons.png/`
>*** CAUTION: You must include the final slash at the end of the path/url or it will break.

## Aspirational Extension Tasks
#### Given extra time, we would have implemented the following features/functionality to the API:
1. Build on our image methods/controller to enable a user to send images and videos as messages into chatrooms, rather than them simply being stored/retrieved from the database
2. Created user types: participants, moderators and admin
3. Added logic to delete the chatroom method so that a chatroom automatically deletes when users no longer exist in the chatroom
4. In the front-end, it would be nice to include automated suggestions for text (This can be done by implementing ChatGPT's API)


## Coders
```
Sujan Sriram
Sarah Abdulle
Zaynah Sadiq
Natasha Usoh
```
