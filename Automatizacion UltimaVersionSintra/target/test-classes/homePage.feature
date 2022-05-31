
Feature: Access HomePage
  Background:
    Given the user is on the home page

  Scenario: Verify an user can change the language at HomePage
    And the user click English language display
    Then The user changed the language at HomePage successfully

  Scenario: Verify an user can not change the language at HomePage
    And the user click English language display
    Then The HomePage did not loaded

    @testcase02

  Scenario: Select <location> from Location area
    When The user select <location> from radio button
    Then Location is displayed in grey color at the top right and Location area is contracted while Department area is shown

  Scenario: Select <location> from Location area
    When The user select <location> from radio button
    Then Location is not displayed in grey color at the top right and Location area is not contracted while Department area is shown


  @testcase04
  Scenario Outline: Select <department> from Department area
    And <location> from radio button is already selected
    When I select <department> from radio button
    Then "Department" area is contracted and <department> is displayed in grey color at the end of the area while "Job" area is shown

    Examples:
      | URL                                 | location               | department                        |
      | https://citaprevia.demohiberus.com/ | Santa Cruz de Tenerife | Estadio Heliodoro Rodríguez López |

  @testcase05
  Scenario Outline: Display <department> when "Find" field is filled
    And <location> from radio button is already selected
    When I type <character sequence> into "Find" field
    Then <department> size list matches with <character sequence>

    Examples:
      | URL                                 | location               | character sequence | department                        |
      | https://citaprevia.demohiberus.com/ | Santa Cruz de Tenerife | Heliodoro          | Estadio Heliodoro Rodríguez López |

  @I select <location> from radio buttontestacase06
  Scenario Outline: Select <Job> from "Job" area
    And <location> is already selected
    And <department> is already selected
    When I select <job>
    Then "Job" area is contracted and <job> is displayed in grey color at the end of the area while "Date" area is shown

    ExampI click the button English\\(EN)les:
      | URL                                 | location               | department                        | job        |
      | https://citaprevia.dem<location> is displayed in grey color at the top right and {string} area is contracted while Department area is shownohiberus.com/ | Santa Cruz de Tenerife | Estadio Heliodoro Rodríguez López | Dársena 21 |

  @testacase07
  Scenariarg0o Outline: Select <Date> & <Time> from "Date" area
    And <location> is already selected
    And <department> is already selected
    And <job> is already selected
    When I select availables <date> and <time> in blue color
    Then "Date" area is contracted and <date> and <time> is dispLocation is not displayed in grey color at the top right and Location area is not contracted while Department area is shownlayed in grey color at the end of the area while "Client information" area is shown

    Examples:
      | URL                                 | location               | department                        | job        | date | time  |
      | https://citaprevia.demohiberus.com/ | Santa Cruz de Tenerife | Estadio Heliodoro Rodríguez López | Dársena 21 | 17   | 12:30 |

  @testacase08
  Scenario Outline: Fill personal data into "Cliente Information" area fields
    And <location> is already selected
    And <department> is already selected
    And <job> is already selected
    And <date> and <time> are already selected
    When <name and last name> is filled
    And <document type> is selected
    And <document type field> is filled
    And <email> is filled
    And <phone> is filled
    And <comments> is filled
    And <checkbox> is checked
    And request button is clicked
    Then url is redirected to appointment info url where displays "Client information" previously input and hiperlink cancel option <cancel hiperlink> is available and shown

    Examples:
      | URL                                 | location               | department                        | job        | date | time  | name and last name | document type | document type field | email                 | phone     | comments    | checkbox | request button |
      | https://citaprevia.demohiberus.com/ | Santa Cruz de Tenerife | Estadio Heliodoro Rodríguez López | Dársena 21 | 17   | 12:30 | Rigoberto Perales  | DNI           | 15868424B           | ojmeneses@hiberus.com | 652778625 | Quiero cita | checked  | clicked        |