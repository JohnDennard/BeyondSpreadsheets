# BeyondSpreadsheets

Requires JDK 11 or higher, Maven, MySQL, and MySQL Workbench to run properly.

Locate to pom.xml file and open terminal, then type:

mvn clean install

and

mvn spring-boot:run

then go to http://localhost:8080


NOTE: MUST edit application.properties file to include your own personal username and password for MySQL. Additionally, must change the datasource.url in this file to whichever port your MySQL runs on.
      You must also import the db.sql file to MySQL workbench and run it in an existing database before running the mvn commands above.
