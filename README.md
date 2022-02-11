# **ShopBackTest**
> Outline a brief description of your project.
> Live demo [_here_](https://drive.google.com/file/d/1BwDdFP3Y2DjRi1qOUpuQ97FGa34Y-cZn/view?usp=sharing).

## Table of Contents
* [General Info](#general-information)
* [Tools Used/Environment Requirement](#technologies-used)
* [Test Scenarios Automated](#features)
* [Framework Structure](#screenshots)
* [How To Run](#usage)
* [Bugs Found](#project-status)


## General Information
- shopback project is created to automate webpage- https://www.shopback.sg/
- All the tests are run in chrome browser [Can be modified via remote webdriver]

## Tools Used/Environment Requirement
- Java JDK 17
- Maven 3.8.3
- Chrome 97
- Chrome Webdriver [Attached directly under project]

## Additioanl tools for Grid and CI implementataions [Not required to run in local machine]
- Docker For Windows


## Test Scenarios Automated
- Verify user is successfully able to login to ShopBack
- Verify user is successfully able to search product and select
- Verify user is able to filter the products(Multi pages are also validated)
- Verify user is able to sort the products(Multi pages are also validated)


## Framework Structure
Run command [MVN] -> Serenity BDD -> Cucumber-> Run Settings File [Junit] -> Secenarios -> Step Definitions -> Steps -> Page Object Class


## How To Run
- Directly it can be run in IntelliJi/Eclipse by running Junit file named "SerenityCucumberRunner'
- Can be run via maven command -"mvn clean verify"
- Can be run via maven with Selenium GRID setup, follow below steps
    - Install Docker For Windows
    - Perform docker compose on 'docker-compose.yml' file which consist of image requirements for hub and nodes
    - After hub is up , run following command via cmd - 'mvn clean verify  -Dwebdriver.driver=remote -Dwebdriver.remote.url=http://192.168.0.145:4444/wd/hub -Dwebdriver.remote.driver=chrome'
- CI/CD
    - Create a Jenkin PipeLine Job and add "JenkinFile" as Jenkins file
    - Run the Job [Job will run against already invoked Selenium GRID]
    - Specify "JenkinsFile" as "JenkinsFile" which will automatically setup the Selenium GRID images and run the scripts