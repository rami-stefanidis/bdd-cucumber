@User
  @InsertUser
Feature: Insert a new user

  @Success
  Scenario Outline: User information is valid
    Given that the users first name is <firstName>
    And last name is <lastName>
    And email is <email>
    When a call is made to <url> using the <httpMethod> http method
    Then the response HTTP status is <httpStatus>
    And the Http Code is <httpCode>
    And response body is <responseBody>

    Examples:
      |url          |httpMethod|firstName|lastName  |email        |httpStatus|httpCode|responseBody|
      |/insertuser  |POST      |Rami     |Stefanidis|aaa@gmail.com|ACCEPTED  |202     |Accepted    |
      |/insertuser  |POST      |JP       |Hansen    |bbb@gmail.com|ACCEPTED  |202     |Accepted    |
      |/insertuser  |POST      |Maria    |PaulVel   |ccc@gmail.com|ACCEPTED  |202     |Accepted    |



  @Error
  Scenario Outline: User email is invalid
    Given that the users first name is <firstName>
    And last name is <lastName>
    And email is <email>
    When a call is made to <url> using the <httpMethod> http method
    Then the response HTTP status is <httpStatus>
    And the Http Code is <httpCode>
    And response body is <responseBody>

    Examples:
      |url          |httpMethod|firstName|lastName  |email        |httpStatus|httpCode|responseBody                    |
      |/insertuser  |POST      |Rami     |Stefanidis|aaagmail.com |FORBIDDEN  |403    |User email format is invalid    |
      |/insertuser  |POST      |JP       |Hansen    |bbbgmail.com |FORBIDDEN  |403    |User email format is invalid    |
      |/insertuser  |POST      |Maria    |PaulVel   |cccgmail.com |FORBIDDEN  |403    |User email format is invalid    |