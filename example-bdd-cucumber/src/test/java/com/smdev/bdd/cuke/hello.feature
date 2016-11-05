Feature: Hello

Scenario: Say Hello To 'Milena'
Given User with username 'Milena'
When Presses login button
Then Greeting message with text 'Hello, Milena' appears