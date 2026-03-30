# Demoblaze E2E Test Automation - Serenity BDD

## Description

End-to-End (E2E) test automation project for the complete purchase flow on [Demoblaze](https://www.demoblaze.com/) using **Serenity BDD**, **Cucumber**, and **Selenium WebDriver**.

### Automated Purchase Flow

1. Add two products to cart
2. View cart with added products
3. Complete checkout form
4. Finalize purchase and verify confirmation

---

## PREREQUISITES

> **IMPORTANT:** Make sure you have the following components installed before running the tests.

### 1. Java Development Kit (JDK) 11 or higher

**Verify installation:**
```bash
java -version
```

**Expected output:**
```
java version "11.0.x" or higher
```


### 2. Apache Maven 3.6 or higher

**Verify installation:**
```bash
mvn -version
```

**Expected output:**
```
Apache Maven 3.6.x or higher
```

**If not installed:**
- Download from: https://maven.apache.org/download.cgi
- Installation guide: https://maven.apache.org/install.html

---

### 3. Google Chrome (latest version)

**Note:** ChromeDriver is automatically downloaded by Serenity BDD.

---

## RUN THE TESTS

### Step 1: Install Dependencies

**Navigate to the project directory:**
```bash
cd "f:\Work 2026\SerenityBDD\SerenityBDD"
```

**Install Maven dependencies:**
```bash
mvn clean install -DskipTests
```

> This command downloads all necessary dependencies and compiles the project without running tests.

---

### Step 2: Run the Tests

#### **Option A: Run ALL tests**
```bash
mvn clean verify
```

#### **Option B: Run SMOKE tests only (recommended for quick start)**
```bash
mvn clean verify -Dcucumber.filter.tags="@smoke"
```

#### **Option C: Run REGRESSION tests**
```bash
mvn clean verify -Dcucumber.filter.tags="@regression"
```

#### **Option D: Use automated script (Windows)**
```bash
run-tests.bat
```

#### **Option E: Use automated script (Linux/Mac)**
```bash
chmod +x run-tests.sh
./run-tests.sh
```

---

### Step 3: View the Reports

**After running the tests, open the Serenity report:**

**Windows:**
```bash
start target\site\serenity\index.html
```

**Linux/Mac:**
```bash
open target/site/serenity/index.html
```

**Or navigate manually to:**
```
target/site/serenity/index.html
```

---

## Project Structure

```
SerenityBDD/
├── src/test/
│   ├── java/com/demoblaze/
│   │   ├── pages/              # Page Objects
│   │   │   ├── HomePage.java
│   │   │   ├── ProductPage.java
│   │   │   ├── CartPage.java
│   │   │   ├── CheckoutPage.java
│   │   │   └── ConfirmationPage.java
│   │   ├── steps/              # Step Definitions
│   │   │   ├── PurchaseSteps.java
│   │   │   └── Hooks.java
│   │   └── runners/            # Test Runners
│   │       ├── TestRunner.java
│   │       └── SmokeTestRunner.java
│   └── resources/features/     # Feature Files
│       └── purchase_flow.feature
├── pom.xml                     # Maven configuration
├── serenity.properties         # Serenity configuration
├── run-tests.bat              # Script Windows
├── run-tests.sh               # Script Linux/Mac
├── README.md                  # This file
└── conclusions.txt           # conclusions
```

## Technologies Used

| Technology | Version |
|------------|---------|
| **Java** | 11+ |
| **Maven** | 3.6+ |
| **Serenity BDD** | 4.0.1 |
| **Cucumber** | 7.14.0 |
| **Selenium WebDriver** | 4.15.0 |
| **JUnit** | 4.13.2 |
| **AssertJ** | 3.24.2 |

---

## Run Project

```bash
# Install dependencies
mvn clean install -DskipTests

# Run all tests
mvn clean verify

# Run smoke tests only
mvn clean verify -Dcucumber.filter.tags="@smoke"

# Run regression tests only
mvn clean verify -Dcucumber.filter.tags="@regression"

# Clean the project
mvn clean

# View report (Windows)
start target\site\serenity\index.html

# View report (Linux/Mac)
open target/site/serenity/index.html
```
