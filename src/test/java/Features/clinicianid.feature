Feature: GEt all the caregivers from API2
  @GetAPI
  Scenario: to get caregiver api
    Given API base uri is given caregiver
    When executed with 1
    Then here check the response code is 200