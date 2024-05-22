#!/bin/bash

# Navigate to the project
cd /path/to/your/project

# Run Maven clean and test
mvn clean test

# Check the result of the Maven command
if [ $? -eq 0 ]; then
  echo "Build and tests were successful."
else
  echo "Build or tests failed."
  exit 1
fi