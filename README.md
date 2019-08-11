# RESTful-DNS-Server
Run service: `mvn package tomee:run`

JPA src\main\resources\META-INF\persistence.xml will create
H2 database.

## Testing with Postman
POST Request Url: http://localhost:8080/restapi/api/books<br/>
Raw body (JSON (application/json)):<br/>
    {<br/>
        "title" : "New Title",<br/>
        "author" : "New Author",<br/>
        "description" : "New Description"<br/>
    }
    
GET Request Url: http://localhost:8080/restapi/api/books<br/>
Body is empty.

PUT Request Url: http://localhost:8080/restapi/api/books/{id}<br/>
Raw body: <br/>
    {<br/>
        "title" : "Updated Title",<br/>
        "author" : "Updated Author",<br/>
        "description" : "Updated Description"<br/>
    }
    
DELETE Request Url: http://localhost:8080/restapi/api/books/{id}<br/>
Body is empty.