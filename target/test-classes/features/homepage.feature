Feature: This is BSE india automation

  @sanity5
  Scenario: Validate the list of language available at homepage
    Given user is at bse india homepage
    When user click on select language dropdown
    Then user is able to view below list of values
      | Hindi | Marathi | Gujarati1 |

  @sanity5
  Scenario: Validate the list of language available at homepage
    Given user is at bse india homepage
    When user click on select language dropdown
    And usr select the language "Hindi" from the dropdown
    Then user is navigated to the page translated in hindi

  @sanity6
  Scenario: Validate the list of language available at homepage
    Given user is at bse india homepage
    When user click on select language dropdown
    Then user is able to view below keys of values
      | Hindi | Marathi | Gujarati |
      | Hindi | Marathi | Gujarati |

  @sanity7
  Scenario: Validate the list of language available at homepage
    Given user is at bse india homepage
    When user click on select language dropdown
    And usr select the language "Hindi" key from the dropdown
    Then user is navigated to the page translated in hindi

  @sanity8
  Scenario: Validate the list of language available at homepage
    Given user is at bse india homepage
    When user click on select language dropdown
    Then user is able to view indices table
      | Index                   | Current   | Pt. Change | % Change |
      | S&P BSE SENSEX          | 74,005.94 | +88.91     | +0.12    |
      | S&P BSE BANKEX          | 55,063.16 | +59.26     | +0.11    |
      | S&P BSE SENSEX 50       | 23,642.90 | +40.04     | +0.17    |
      | S&P BSE 100             | 23,808.33 | +52.71     | +0.22    |
      | S&P BSE Bharat 22 Index |  8,704.16 | +57.28     | +0.66    |
