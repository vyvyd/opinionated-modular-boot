# opinionated-modular-boot
An opinionated modular-monolith structure for Spring Boot 3.0 applications.

## What does this repository cover
- Opinionated setup to structure packages within a modular spring-boot application
- Design your modular-monolith for decomposability
- How to enforce package boundaries through lightweight architecture tests

## Design considerations 

### Package Structure 

```mermaid
%%{init: {'theme': 'base', 'themeVariables': { 'primaryColor': '#64fdd7', 'edgeLabelBackground':'#e8e8e8', 'tertiaryColor': '#64fdd7'}}}%%
block-beta
    columns 2
    block:group1:1
        columns 1 
        id1(["Library Modules"])
        ErrorHandling 
        Logging 
        Security
        Observability
    end
    block:group2:2
        columns 1
        id2(["Application Modules"])
        ApplicationModule1 ["Module 1"] 
        ApplicationModule2 ["Module 2"] 
        ApplicationModule3 ["Module 3"]
        ApplicationModule4 ["Module 4"] 
    end
    style id1 fill:#fdd764,stroke:#333,stroke-width:4px
    style id2 fill:#fdd764,stroke:#333,stroke-width:4px
    style ApplicationModule1 fill:#b6d3e6
    style ApplicationModule2 fill:#b6d3e6
    style ApplicationModule3 fill:#b6d3e6
    style ApplicationModule4 fill:#b6d3e6
```

Broadly, there are two kinds of modules in the applications  
- **Library Modules**: These modules are usually cross-cutting concerns that are not domain based.
- **Application Modules**: These modules deal with the domain of the application, and they can make use of functionality available in either the library-modules or from other application modules that are available alongside.

### Dependency Rules 
1. **Library Modules** MUST NOT depend on any code in **Application Modules**
2. **Application Modules** CAN depend on published API in **Library Modules**
3. **Application Modules** MUST NOT have cyclic depdendencies with each other. 




