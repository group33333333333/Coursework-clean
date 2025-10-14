![workflow](https://github.com/camerondear/devops/actions/workflows/main.yml/badge.svg)
[![LICENSE](https://img.shields.io/github/license/camerondear/devops.svg?style=flat-square)](https://github.com/camerondear/devops/master/LICENSE)
[![Releases](https://img.shields.io/github/release/camerondear/devops/all.svg?style=flat-square)](https://github.com/camerondear/devops/releases)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/camerondear/devops/main.yml?branch=master&style=flat-square)

## READ ME 66


**17/09:**

1) Enabled VCS Integration
2) Created *.gitignore* file and ignored selected file types
3) Installed WLS via CMD and enabled Hyper-V
4) Installed and integrated Docker
5) Successfully pushed and committed to, and pulled from GitHub.

CODE OF CONDUCT

1. Use approprite and professional language orally and in writing when working
   with team members, and avoid potentially controversial topics, while being aware
   of others feelings
2. Dont participate in team activities under the influence or drugs or alcohol(exluding
   over the counter or prescription medicines)
3. No violent, aggressive or indecent behaviour is to be displayed towards any group memebers
4. No missuse of company, personal or university items.
5. Dont disrupt the groups work flow with unnecessary behaviour.
6. Adhere to health and safety policies at all times.
7. Adhere to the computer missuse act


**USER STORIES**

1. As a member of the group, i want clear and easy tasks to work towards with a due date. therefore we should use a sprint board
2. As a member of the team, i want to define tasks as user stories. so we can keep focus on the user and what they would like.
3. As a member of the group, i want to see whats being worked towards with a kanban board
4. As a user, i want a use case diagram so i can understand the system better
5. As a user, i want defined use cases so i know how i will be interacting with the system
6. As a member of the team, i want to integrate issues with github. So if there is an issue we can all know about it and work towards fixing it
7. As a member of the team, i want to sync zube.io with github so we can work towards issues and items in the backlog clearly


SCRUM METHOD for code review 2 week 6

Back log: 
Define tasks as user stories 
Sync zoup.io with GitHub
Create sprint board
Create/populate kanban board
integrate issues on GitHub
Create use case diagram
Define use cases


Ordered back log:
Sync Zoup.io with GutHub
Define tasks as user stories 
Create/populate kanban board
Create sprint board
Integrate issues on GitHub
Define use cases
Create use case diagram

Daily meeting 08/10/25 - the whole group has met up and organised
the kamban board to allow us to identify the tasks that needs to be 
completed and assign them to each member to make sure that eveyones work
load is defined. At this point we have encountered no problems.

Use case name: Generate Population Reports

Primary Actor: System User

Supporting Actor: Database

Summary: The System User wants to Generate a population report to view all countries in the world by population largest - smallest

Preconditions: The System User’s organisation must have access to an up-to-date population database. provided by the organisation

Trigger: The System User selects the option to generate population reports

Guarantees:

Success Guarantee: The population reports are generated (countries/regions by population size).
Failure Guarantee: The population reports are not generated

Main success scenario:

The System User locates the button to generate population reports
The System User requestspopulation data for a country.
The system queries the database.
The System User can now view all countries in the world by population largest - smallest
The System User can now upload the data into the Database



Use case name: Generate City Reports

Primary Actor: System User

Summary: The System User wants to Generate city reports to view all cities in the country

Preconditions: The System User must have access to an up-to-date population database provided by the organisation

Trigger: The System User selects the option to generate city reports

Guarantees:

Success Guarantee: The city reports are generated
Failure Guarantee: The city reports are not generated or data is incomplete

Main success scenario:

The System User locates the button to generate city reports
The System User requests all cities data for a country.
The system queries the database for all cities
The System User can now view all cities in the country
The System User can now upload the data into the Database



Use case name: Generate Capital Reports

Primary Actor: System User

Summary: The System User generates reports specifically for capital cities to compare their populations using information from the database

Preconditions: The System User must have access to an up-to-date capital city database provided by the organisation

Trigger: The System User selects the option to generate capital city reports

Guarantees:

Success Guarantee: The capital city reports are generated by population size
Failure Guarantee: The capital city reports are not generated or data retrieval fails

Main success scenario:

The System User locates the button to generate capital city reports
The System User requests capital city population data for a country.
The system queries the database for all capital cities
The system generates a report ranking capitals by population.
The System User can now view the report



Use case name: Generate City Population Reports

Primary Actor: System User

Summary: The System User wants to Generate a report of the most populated city in the world

Preconditions: The System User must have access to an up-to-date City database provided by the organisation

Trigger: The System User selects the option to generate highest populated city reports

Guarantees:

Success Guarantee: The city reports are generated by population size highest to smallest
Failure Guarantee: The city reports are not generated or data retrieval fails

Main success scenario:

The System User locates the button to generate city reports
The System User requests city population data for a country.
The system queries the database for all cities
The system generates a report ranking and produces the highest populated city in the world.
The System User can now view the report



Use case name: Generate Non-City Population Reports

Primary Actor: System User

Summary: The System User generates reports of populations not living in cities for example rural population of the country

Preconditions: The database must contain non-city population data.

Trigger: The System User selects the option to generate non-city population reports.

Guarantees:

Success: The system generates reports of non-city populations.
Failure: The Non-City population report is not generated or data retrieval fails.

Main Success Scenario:

The System User locates the button to generate non-city reports
The System User requests non-city population data for a country.
The system queries the database for non-city populations.
The system generates a report ranking county’s non-city populations.
The System User can now view the report.



Use case name: Generate World Population Report

Primary Actor: System User

Summary: The System User generates reports showing the total population of each country in the world.

Preconditions: Country-level population data must be stored in the database.

Trigger: The System User selects the option to generate world population reports.

Guarantees:

Success: The system generates reports with population totals for all countries.
Failure: The World Population report is not generated

Main Success Scenario:

The System User locates the button to generate world population reports
The System User requests a world population report.
The system queries the database for all countries.
The system generates a report showing each country’s population.
The System User views the report.





