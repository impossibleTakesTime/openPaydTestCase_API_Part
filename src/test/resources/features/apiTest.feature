
@wip

Feature: OpenPayd Post Api Tests

  Background:
    When I get a list of blog posts using the API endpoint


  Scenario Outline: Counting posts for user <user>

    Then User <user> should have <numposts> posts

    Examples:
      | user | numposts |
      | 5 | 10 |
      | 7 | 10 |
      | 9 | 10 |


  Scenario: Unique ID per post

    Then Each blog post should have a unique ID