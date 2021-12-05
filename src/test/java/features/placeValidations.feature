Feature: Validating Place API
  #Scenario: Verify if Place is being successfully added using AddPlaceAPI
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    #Given Add place payload
    When User calls "ADD_PLACE_API" with post http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      |name | language | address |
      | AAhouse | English | World Cross Center |
      | BBhouse | English | World Cross Center |