1. We talked about Dependencies, Starter Dependencies, Spring Boot way to wrap all the necessary dependencies
   and provide a fully-tested, working and all-set package of different dependencies, as a ONE WHOLE WORKING
   dependency!
   Spring Boot Starter Web, for instance, among others, includes these:
   - Spring Web MVC
   - Servlet Container
   - Tomcat
   - Jackson;
   - Jackson Binder;
   - ... and so on, everything you need to have for a WEB! (name of starter dependency tells you what this dependency is used for)


2. A huge amount of Automatic Configuraiton! @SpringBootApplication includes:
    - @EnableAutoConfiguration - for a huge huge amount of Convention-Over-Configuration specifics!

---------


In Spring Boot applications, we usually practice so caleld "n-Tier / multilayered architecture".

- Web Layer (@Controller classes), depends on / uses
  - Service layer (@Service claases), depends on / uses
     - DAO / Repository layer (@Repository classes), depends on / uses
        - Database / Data Persistence Layer.


Why such a layered separation is important?
 - Web layer should be only responsible for WEB-related activities.. HTTP communication!
   Otherwise, 1) you duplicate the code, and 2) you kill maintainability!
   That's why, it's BEST to separate Business-Logic from the Web-Layer, and abstract it away!

