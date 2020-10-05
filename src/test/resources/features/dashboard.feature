Feature: As a manager
  I want to see statistics of the offered courses
  So I will track the progress of those courses

  Scenario: Filter by company and check course enrollment
    Given a manager is logged
    When the manager filters by "Microsoft corporation" company
    Then the course enrollment should be greater than 0