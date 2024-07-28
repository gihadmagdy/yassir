Feature: login feature
Scenario Outline: Validate that user can login successfully
  Given user navigate to login page
  And  user enters his "<username>"
  And  user enters his right "<password>"
  And user click login button
  And validate that home page displayed
  And user select sortion "<sort>"
  And user click add to cart
  And user click cart icon
  Then validate that item added successfully
  And user click checkout
  And user enters his data
  And user click continue
  Then validate total price

  Examples:
  |    username |password| sort |
  |standard_user|secret_sauce | price high to low |
  #|standard_user|secret_sauce | price low to high |