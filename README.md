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

For the user to `create a chatroom`, `add users` and `send messages`.

### UML Diagram and ERD Diagram

![](/Users/sarah/Downloads/Screenshot 2023-04-27 at 17.56.50.png)
![](/Users/sarah/Downloads/Screenshot 2023-04-27 at 17.57.25.png)

## List of example routes:

### User Controller
| Route Name             | Request Type | RequestBody                  | RequestPath                                   |
|------------------------|--------------|------------------------------|-----------------------------------------------|
| `displayAllUsers`        | GET          | null                         | /users                                      |
| `displayUserById`        | GET          | null                         | /users/{userId}                      |
| `editUser`               | GET (edit)   | null                         | /users/{userId}/edit                  |
| `updateUser`             | PUT          | UserDTO ("name" and "email") | /chatrooms/{userId}                           |
| `createUser`             | POST         | null                         | /users                                    |
| `deleteUser`             | DELETE       | null                         | /users                              
| `displayChatroomsByUser` | POST         | User                         | /users/{userId}/chatrooms    |


### Chatroom Controller
| Route Name             | Request Type | RequestBody                  | RequestPath                  |
|------------------------|----------|------------------------------|------------------------------|
| `displayAllChatrooms`    | GET      | null                         | /chatrooms                   |
| `displayChatroomById`    | GET      | null                         | /chatrooms/{chatroomId}      |
| `editChatroomName`       | GET (edit) | null                         | /chatrooms/{chatroomId}/edit |
| `updateChatroomName`     | PUT      | UserDTO ("name" and "email") | /users/{userId}              |
| `createChatroom`         | POST     | null                         | /users                       |
| `deleteChatroom`         | DELETE   | null                         | /users                        
| `addUserToChatroom`      | UPDATE   |     |     |
| `removeUserFromChatroom` | UPDATE   |-----|-----|

### Message Controller

| Route Name                  | Request Type | RequestBody  | RequestPath            |
|-----------------------------|--------------|--------------|------------------------|
| `sendMessage`                 | POST         | MessageDTO (" | /messages              |
| `deleteMessage`               | DELETE       | null         | /messages/{id}         |
| `retrieveMessagesForChatroom` | GET          | null         | /messages/{chatroomId} |


### Image Controller
| Route Name             | Request Type | RequestBody                              | RequestPath               |
|------------------------|--------------|------------------------------------------|---------------------------|
| `uploadImage`            | POST         | null  (@RequestParam read more below***) | /image                    |
| `downloadImage`          | GET          | null                                     | /image/{fileName}/        |

** in the uploadImage route the @RequestParam represents the image.
An example of how to execute this in Postman:
1) POST localhost:8080/image
2) Body -> form-data
3) Within the key enter `image`
4) Hover mouse at then end of the `image` box and click on the drop-down and select `file`
5) The value would include the filename for example: `balloons.png`

An example of how to execute `downloadImage` in Postman:
`GET localhost:8080/image/balloons.png/ `
(MUST include the final slash at the end of the path or there will be an error!)

## Further Extensions We Would Have Liked To Include:
If we had extra time, we would have:
1. Created user types: participants, moderators and admin
2. Added logic to delete the chatroom method so that a chatroom automatically deletes when no users exist in the chatroom
3. Enabled videos to be sent as messages

