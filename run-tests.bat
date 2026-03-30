@echo off
echo ================================================================================
echo Demoblaze E2E Tests - Serenity BDD
echo ================================================================================
echo.

echo Checking Java installation...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    pause
    exit /b 1
)
echo.

echo Checking Maven installation...
mvn -version
if %errorlevel% neq 0 (
    echo ERROR: Maven is not installed or not in PATH
    pause
    exit /b 1
)
echo.

echo ================================================================================
echo Running Serenity BDD Tests...
echo ================================================================================
echo.

mvn clean verify

echo.
echo ================================================================================
echo Test execution completed!
echo ================================================================================
echo.
echo Opening Serenity Report...
start target\site\serenity\index.html

pause
