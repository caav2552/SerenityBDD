#!/bin/bash

echo "================================================================================"
echo "Demoblaze E2E Tests - Serenity BDD"
echo "================================================================================"
echo ""

echo "Checking Java installation..."
java -version
if [ $? -ne 0 ]; then
    echo "ERROR: Java is not installed or not in PATH"
    exit 1
fi
echo ""

echo "Checking Maven installation..."
mvn -version
if [ $? -ne 0 ]; then
    echo "ERROR: Maven is not installed or not in PATH"
    exit 1
fi
echo ""

echo "================================================================================"
echo "Running Serenity BDD Tests..."
echo "================================================================================"
echo ""

mvn clean verify

echo ""
echo "================================================================================"
echo "Test execution completed!"
echo "================================================================================"
echo ""
echo "Opening Serenity Report..."
open target/site/serenity/index.html || xdg-open target/site/serenity/index.html

echo ""
echo "Report location: target/site/serenity/index.html"
