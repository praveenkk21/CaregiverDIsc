Feature: Checkin the pet store with valid data
  @Valid
  Scenario Outline: Add one Pet to pet store
    Given api uri is given
    When path file is provided
    Then here check response code is <int>
    Examples:
      | int |
      | 200 |

