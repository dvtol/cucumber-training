# Cucumber - Training

Cucumber training - test set. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
JDK 7.* / 8.*
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
(1) <github_host_repo>
(2) insert lombok plugin
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Maven (local via chrome, remote via selenium grid) run cmds
Selenium grid has the 'default' spring profile and runs will be executed via remote. 

```
local: mvn clean test
```

```
remote: mvn clean test -Dspring.profiles.active=remote
```

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
- Making use of PageObjects and StepDefs separately to keep clean OO programming. 
- Making use of annotated tags, including ignore tag for tests we don't want to be executed.
- Making use of spring (beans) to run this framework with different profiles.
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [Git](https://git-scm.com//) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors - Cucumber training Team

* **Danny van Tol** danny@opencore.nl
* **Glenn Dasai** glenn_gd@hotmail.com

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments
