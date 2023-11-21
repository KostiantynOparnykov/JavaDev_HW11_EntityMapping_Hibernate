### Moddule 10 homework "ORM Hibernate"

This is homework for Module 10 of JavaDeveloper (14) GoIt course

This homework contains 3 main goals
1. Is to create `Gradle` project and properly connect  
   * Database (in my case `postgres`)
   * `hibernate`
   * `flyway`
2. Create two migration files
   * `V1__create_db.sql` - creates my db structure
   * `V2__populate_db.sql` - populates my db
3. Create entities `Client`, `Planet`, `Ticket`.

   And for `Client` and `Planet` create hibernate mapping and CRUD services
   * `ClientCrudService`
   * `PlanetCrudService`