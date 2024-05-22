## SportsBetAutomation Suite README

**Assumptions**

 1. The automation suite operates only when there is a live race. 
 2. The user is always using Chrome as the browser for automation testing.
 4. There is at least one card available under the 'Next to Jump' carousel. 
 5. At least two different bets are available as Runners. 
 6. Two bets are randomly selected from the Runners list. 
 7. The bet slip should be closed before adding the second bet to the bet slip.

**Issues Encountered and Resolutions**

Issue:
Selecting random two cards took additional time.

Resolution:
Implemented the Random() function to efficiently select two random cards.

**Potential Problems as the Test Suite Grows**

The automation suite should return an assertion failure if there is no live bet available.

**Improvements for Easier Adoption and Future Test Implementation**

To make this suite easier for team members to adopt and to facilitate the implementation of future tests, several improvements have been made:

 - Added comments throughout the code to enhance readability and understanding.
 - Used meaningful variable and method names for clarity and maintainability.
 - Considered using the Page Object Model (POM) design pattern to enhance the structure and reusability of the code.
 - Utilized utility methods to avoid code duplication and to simplify common tasks.
 - Handled some exceptions that may occur during test execution.

As an Improvement, further exception handling can be implemented for other potential issues.

**Additional Info**

 - Extent reports, TestNG metrics report and screenshots are avaialble in test-output folder.
 - run_tests.sh shell script is added (https://github.com/Ieshanie/SportsbetAutomation/blob/master/run_tests.sh)


 
