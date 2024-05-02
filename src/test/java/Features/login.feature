Feature: GEt all the products from API
@GetAPI
  Scenario Outline: to get api
    Given API base uri is given
    When executed
    Then check the response code is <arg0>
    Examples:
      | arg0 |
      | 200  |
      | 400  |

