# MarvelBackend
[Deployed Backend](https://marvel-backend-application.herokuapp.com/)

**Models:**
userLogins & heroProfiles

**Endpoints:**
https://marvel-backend-application.herokuapp.com/api/v1/

MODEL 1 - USERLOGINS TABLE

C - POST ->   "adduser"              Create a new user by entering necessary data
    POST ->   "login"                Used to insert data for the purpose of a search 
R - GET ->    "allusers"             Returns all users within database
R - GET ->    "users/{usersid}"      Returns a specific user as defined by their unique id #
R - GET ->    "allusers/{username}"  Returns a specific user as defined by their unique username
U - PUT ->    "user/{userid}"        Updates a specific user by calling on their unique id #
D - DELETE -> "user/{userid}"        Deletes a specific user by calling on their unique id #


MODEL 2 - HEROPROFILES TABLE

C - POST ->   "addprofile"           Create a new profile by entering necessary data
R - GET ->    "allprofiles"          Returns all profiles within database
R - GET ->    "profiles/{usersid}"   Returns a specific profiles as defined by their unique id #
R - GET ->    "allprofiles/{name}"   Returns a specific profiles as defined by their unique name
U - PUT ->    "profile/{userid}"     Updates a specific profiles by calling on their unique id #
D - DELETE -> "profile/{userid}"     Deletes a specific profiles by calling on their unique id #
