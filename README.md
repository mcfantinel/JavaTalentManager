# JavaTalentManager

###### People-Ware Recruitment App

App built with all functional specifications requested on spec document.

Diagrams:
All diagrams are in the home folder of the project
- Database_schema_diagram is the database design for the project
- ClassDiagram_Applicants is the class diagram with the application design to manage the applicants
- ClassDiagram_JobOffer is the class diagram with the application design to manage the job offers
- ClassDiagram_Model is the class diagram with the application design to manage all the classes created to map the objects needed to show the pages in MODEL-VIEW-CONTROLLER architecture

Assumptions:
- Applicants and Job Offers did not have to match working period to be considered a match

Extra Functionalities:
- Unit Testing

###### Project Git Hub Repository
https://github.com/mcfantinel/JavaTalentManager.git

###### Built With

	Git - Repository Management
	JavaEE - Development Tool
    Maven - Dependency Management
    Spring MVC - Framework for Model-View-Controller (MVC) architecture in web applications
    Hibernate - Framework for database integration
    Bootstrap - Framework for web site design
    JQuery - Framework for front-end
    PostgreeSQL - Database
    JUnit - Framework for unit testing

###### Prerequisites

- JDK 8 or later
- Postgree Database 9.4 or later
- Apache Tomcat 8.5 or later
- Eclipse or Intellij


###### Installing

1- Create a database in PostgreeSQL where the application could connect to.

2- Under "JavaTalentManager\SpringHibernate\libs" copy the library "postgresql-9.4.1208.jre7" and place on Tomcat lib folder "$(TOMCAT_HOME)/lib"

3- Setup the database creation and connection editing the datasource in the file "\JavaTalentManager\SpringHibernate\src\main\webapp\WEB-INF\spring-servlet.xml"

	For database table structure creation change the line the property hibernate.hbm2ddl.auto to:
	<prop key="hibernate.hbm2ddl.auto">create</prop>

	Edit the datasource with the postgree database configuration for the properties url, username and password:
	<beans:bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<beans:property name="driverClassName" value="org.postgresql.Driver" />
		<beans:property name="url" value="jdbc:postgresql://HOST:PORT/DATABASE_NAME" />
		<beans:property name="username" value="USERNAME_VALUE" />
		<beans:property name="password" value="PASSWORD_VALUE" />
	</beans:bean>

###### Deployment

1- Open the project with Eclipse or Intellij

2- Generate war file

3- Deploy war file to tomcat server

4- Populate database with initial data from the file Database_Init.sql located on the home folder of the project

5- Access the application with the address "http://HOST:PORT/SpringHibernate/"


###### Author

    Manoel Capaverde