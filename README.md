# CPSC471Project
Will, Andrew, and Cloud's Final Project for **CPSC 471**

To run this code, import the database dump to the desired SQL server. We used MySQL Workbench to export the data dump, so to import it there would be a few steps.

1. Extract the zipped dump file into a folder.
2. Using MySQL workbench, connect to a SQL server
3. Go to Server > Data Import > Import from Dump Project Folder
4. Review backup contents, and then click "Start Import"
5. Wait for completion of import

After the database is restored, to run the code, there are 2 ways:

1. Run the jar file on the desired server, using a terminal or command line with `java -jar openapi-spring-0.0.1.jar`

2. Import and run the project archive in eclipse.

To run the project, make sure you are running the main function in `OpenAPI2SpringBoot.java`.

The API will be instantiated on port 8080 of your machine, and you can view the *Swagger UI* and access the api with http://localhost:8080