# My readme

### Technical Information:
Java 17. 

Maven.

Spring 3.0.7

Dependencies: lombok, JPA, Spring web, Spring boot dev tools, Postgresql.

### Installation Instructions:

Install Postman, Postico, Postgresql , IntelliJ.

To create a local database called `chatroom_db`, run the command `createdb chatroom_db`
in the terminal.
### Project aims:

For the user to create a chatroom, add users and send messages.


### List of example routes:

##User Controller
## Chatroom Controller
| Route Name             | Request Type | RequestBody          | RequestPath                                   |
|------------------------|----------|----------------------|-----------------------------------------------|
| displayAllChatrooms    | GET      | null                 | /chatrooms                                    |
| displayChatroomById    | GET      | null                 | /chatrooms/{chatroomId}                       |
| editChatroomName       | GET (edit) | null                 | /chatrooms/{chatroomId}/edit                  |
| updateChatroomName     | PUT      | ChatroomDTO ("name") | /chatrooms/{userId}                           |
| createChatroom         | POST     | Chatroom ("name")    | /chatrooms                                    |
| deleteChatroom         | DELETE   | null                 | /chatrooms/{id}                               
| addUserToChatroom      | UPDATE   | null                 | /chatrooms/{chatroomId}/users/{userId}/add    |
| removeUserFromChatroom | UPDATE   | null                 | /chatrooms/{chatroomId}/users/{userId}/remove |

## User Controller

| Route Name             | Request Type | RequestBody                  | RequestPath                                   |
|------------------------|--------------|------------------------------|-----------------------------------------------|
| displayAllUsers        | GET          | null                         | /users                                      |
| displayUserById        | GET          | null                         | /users/{userId}                      |
| editUser               | GET (edit)   | null                         | /users/{userId}/edit                  |
| updateUser             | PUT          | UserDTO ("name" and "email") | /chatrooms/{userId}                           |
| createUser             | POST         | null                         | /users                                    |
| deleteUser             | DELETE       | null                         | /users                              
| displayChatroomsByUser | POST         | User                         | /users/{userId}/chatrooms    |
 
