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
| Route Name | Request Type | RequestBody                  | RequestPath               |
|------|--------------|------------------------------|---------------------------|
| displayAllUsers | GET          | null                         | /users                    |
| getUserById | GET          | null                         | /users/{userId}           |
| editUser | GET (edit)   | null                         | /users/{userId}/edit      |
| updateUser | PUT          | UserDTO ("name" and "email") | /users/{userId}           |
| createUser | POST         | null                         | /users                    |
| deleteUser | DELETE       | null                         | /users                    
| displayChatroomsByUser | POST         | User                         | /users/{userId}/chatrooms |

## Chatroom Controller
| Route Name             | Request Type | RequestBody                  | RequestPath                  |
|------------------------|----------|------------------------------|------------------------------|
| displayAllChatrooms    | GET      | null                         | /chatrooms                   |
| displayChatroomById    | GET      | null                         | /chatrooms/{chatroomId}      |
| editChatroomName       | GET (edit) | null                         | /chatrooms/{chatroomId}/edit |
| updateChatroomName     | PUT      | UserDTO ("name" and "email") | /users/{userId}              |
| createChatroom         | POST     | null                         | /users                       |
| deleteChatroom         | DELETE   | null                         | /users                        
| addUserToChatroom      | UPDATE   |     |     |
| removeUserFromChatroom | UPDATE   |-----|-----|



1. Create a user: you need 
2. Create a chatroom
3. Edit the chatroom name
3. Add a user
4. Send a message
5. 