# Teste Banco Original API

CRUD Rest Api implemented using spring-boot Maven Project.


## How to Run
### Backend
-   Download the zip or clone the Git repository.
-   Unzip the zip file (if you downloaded one)
-   Open Command Prompt and Change directory (cd) to folder containing pom.xml
 - Run the service by using the following command:

    `./mvnw spring-boot:run`
    
- Create a user to login in frontend


    POST localhost:8080/user/
    Accept: application/json
    Content-Type: application/json
	{
	"login": "login",
	"password": "password"				
	}    

### Frontend
-   Download the zip or clone the Git repository.
-   Unzip the zip file (if you downloaded one)
-   Open Command Prompt and Change directory (cd) to folder frontend
 - Run the service by using the following command:

    `ng serve`
-   Navigate to `http://localhost:4200/`

- Use the login and password created to use the application.