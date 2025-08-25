Selenium Test Automation Framework (Java + Maven + TestNG)
==============================================================
This repository contains a Test Automation Framework built using Selenium WebDriver, Java, Maven, and TestNG.
It follows the Page Object Model (POM) design pattern with utilities for reusability and logging

Project Structure
--------------------------
Assessment_Test_Project_Aug/
│── pom.xml
│── test-output/           
│── target/                     
├── src/ 
	├── main/
	├── java/
		└── com.GenericLibrary
          			├── BaseClass                    # Base classes (setup)
           			├── Browser                      # Browser Configurations
           			├── Constants                    # Constants & Config reader
           			├── WebDriverCommonLib           # WebDriver & file utilities
           			|── Samplelistener               # TestNG listeners (reports/screenshots)
        	└── com.pageObjectLib
           			 |──HomePage
            			 |──LoginPage
           			 |──PIM_Page
├── src/
    ├── main/  
    ├── test/
    ├── java/
       └── TestCases
            ├── Employee_CreationTest.java
│──resources/
    ├── log4j.properties           # Logging configuration                              
│── FailedTCScreenshots/      

 Tech Stack
 -------------------

Language: Java 8+

Automation Tool: Selenium WebDriver

Test Runner: TestNG

Build Tool: Maven

Logging: Log4j

Author
----------------


