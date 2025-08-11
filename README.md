# Java Tax Free System project

# Prerequisites
This project uses Spring Boot, Spring MVC, Spring Data JPA and Thymeleaf HTML template rendering engine.
It is recommended to have a basic understanding of these technologies before reviewing any of the code.
Technologies used:
* Bootstrap 5.3.3
* Font Awesome 6.5.0
* Spring Security 6.5.2
* Thymeleaf 3.1.3
* Flatpickr v4

# Requirements
* JDK 17+
* Check if JAVA_HOME is using JDK 17
    * On Windows CMD:
  > echo %JAVA_HOME%
    * On Unix Terminal:
  > echo $JAVA_HOME

# Access Points

# Web Application
- **Main app**: http://localhost:8080/
- **Submit declaration**: http://localhost:8080/salesman/details
- **View declaration**: http://localhost:8080/declarations/list

# Important notes:
1. Application uses wizard like form (declaration) submission process with steps in a preset order, any attempts to manually open a specific wizard step without completing the previous, will result in a redirection to a required step.
2. Only users holding the ADMIN role have the privilege of submitting a declaration or deleting submitted declarations, other users a limited only to submitted declarations view list.