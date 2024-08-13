# Potential Duplicates Check
As a challenge for 'Compass', a simple program that checks a clients base for potential duplicates.

## Rationale Under the Hood
The program will calculate an accuracy score based on the likeness of client's contact info, there are three levels of
accuracy: 'Low' with score point, 'Medium' with two and 'High' with three points, each point will be awarded to the
client pair that match with the following scenarios:
1) if clients has the same email address
2) if clients coincide in the name or last name with at least one word
3) if at least two words of the physical address coincide (could be expanded)

## How the Program Works
- The application works with a list that contains at least two clients
- The entry point is via 'App' class, then calls for the service which yields all the methods
- The method "searchPotentialDuplicates" returns a list with "potential duplicates", an object that holds the
id pairs of the objects that match as the criteria states and its accuracy score between low and high

## The Tests
Are written in Groovy, a scripting language that make TDD easy, using Spock testing framework. The tests covers all the
scenarios of the scoring.

Thanks for the opportunity, it was a fun journey 🤓.