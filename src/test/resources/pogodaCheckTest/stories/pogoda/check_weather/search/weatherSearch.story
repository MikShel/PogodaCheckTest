Feature: Check weather in concrete town

Narrative:
In order to check weather
As a simple user
I want to have possibility to find my town and get all weather data about it.

Im from concrete Town and i want to check temperature


Scenario: Search existing town

Given Im on the http://pogoda.yandex.by
When I find Минск using search
Then I see todays weather

Scenario: Search nonexisting town

Given Im on the http://pogoda.yandex.by
And I want to check weather in Фывап
Then I am notified that it is not exist

Scenario: Choose another town

Given Im on the http://pogoda.yandex.by
When I find Минск using search
And I want to change town on Москва
Then I see todays weather

