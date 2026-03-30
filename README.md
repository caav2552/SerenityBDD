# Demoblaze E2E Test Automation

E2E test automation for [Demoblaze](https://www.demoblaze.com/) purchase flow using Serenity BDD, Cucumber, and Selenium WebDriver.

## Prerequisites

- Java 11+
- Maven 3.6+
- Chrome (latest)

Verify installation:
```bash
java -version
mvn -version
```

## Run Test 

```bash
# Install dependencies
mvn clean install -DskipTests

# Run tests
mvn clean verify

# View report
start target\site\serenity\index.html  # Windows
open target/site/serenity/index.html   # Mac/Linux
```

## Test Execution

```bash
# Run all E2E tests
mvn clean verify

# Run main scenario only
mvn clean verify "-Dcucumber.filter.tags=@main"

# Run specific feature
mvn verify -Dcucumber.features="src/test/resources/features/complete_purchase.feature"
```

## Project Structure

```
src/test/
├── java/com/demoblaze/
│   ├── pages/         # Page Objects
│   ├── steps/         # Step Definitions
│   └── runners/       # Test Runners
└── resources/features/
    ├── add_to_cart.feature
    ├── checkout.feature
    └── complete_purchase.feature
```

## Technologies

- Serenity BDD 4.0.1
- Cucumber 7.14.0
- Selenium WebDriver 4.15.0
- Java 11+
- Maven 3.6+

## Features

- **Page Object Model** - Clean separation of concerns
- **BDD with Cucumber** - Gherkin scenarios
- **Automated Reports** - Detailed Serenity reports with screenshots
- **CI/CD Ready** - Maven-based execution

## Documentation

- [conclusiones.txt](conclusiones.txt) - Test findings and approach
