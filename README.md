# opinionated-modular-boot
An opinionated modular-monolith structure for Spring Boot 3.0 applications.

## What does this repository cover
- Opinionated setup to structure packages within a modular spring-boot application
- Design your modular-monolith for decomposability
- How to enforce package boundaries through lightweight architecture tests

## Design considerations 

### Tech-Stack 
- Spring Boot 3
- Spring Data JPA
- TestContainer based PostgreSQL instance
  
The following is out of scope of this demonstration 
- Spring Modulith 
- Asynchronous Business Flows - all business flows are transactional in nature

## Functionality
The demonstration application is a library management application with the following business capabilities 
- Book Inventory 
- Book Lending and Returns
- Book Replacement

These capabilities will map to the different modules available in the application.

