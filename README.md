# Time Checker
Find out the local time of remote cities

# Code Structure
```sh
# assume you are inside src folder
-- Application.java
-- util
 | -- Timemanipulator.java
-- api/v1/time
 | -- TimeModel.java
 | -- TimeService.java
 | -- TimeController.java
```

# Running locally
```sh
# terminal
./gradlew clean build bootRun
```

# Testing
```sh
# terminal
./gradlew test
```

# Contribution
Always create a new branch from `develop`, before making any major change
```sh
# Assume your local branch is currently develop

# for bug fixing
git checkout -b bugfix/<bug-short-name>

# for feature addition
git checkout -b feature/<feature-short-name>

# when done, make pull request to develop branch
```
