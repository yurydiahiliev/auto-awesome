# Test project for AQA interview

This project is a Selenium-based Java project for testing the website "https://plexusworldwide.com". It includes two test cases for testing basic flow scenarios.

## Requirements
- Java 11
- Maven

## Installation
1. Ensure you have Java 11 installed on your system.
2. Install Maven by following the instructions on the [official website](https://maven.apache.org/install.html).

## Running Tests
To run the tests, use the following Maven command:
```bash
mvn clean test
```
This command will execute the test cases using Chrome as the browser.

## Generation test report
To generate the Allure report, use the following Maven command:
```bash
mvn allure:report
```
The report will be generated in the following directory:
```bash
/auto-awesome/target/site/allure-maven-plugin
```
Open the index.html file in a browser to view the generated Allure report.

Note
- Actual ChromeDriver in the Browser class before running the tests will be downloaded automatically or use from cache.
- Optionally, you can customize Chrome options (e.g., headless mode) in the Browser class.
