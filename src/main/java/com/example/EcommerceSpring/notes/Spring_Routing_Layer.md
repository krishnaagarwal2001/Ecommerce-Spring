### Routing Layer is handled by Dispatcher Servlet.
#### A servlet is a Java class that extends the functionality of a web server allowing it to handle requests and generate dynamic web content.
### All requests first go to Dispatcher Servlet and then to Controller.

### It is a 2 way step

1. HandlerMapping / Request Mapping --> helps the dispatcher servlet for pattern recognition of the incoming request to find the relevant controller.
2. HandlerAdapter --> helps in actually invoking the controller.