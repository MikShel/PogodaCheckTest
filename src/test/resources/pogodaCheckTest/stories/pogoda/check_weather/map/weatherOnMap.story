Meta:

Narrative:
In order to check the weather
As a user
I want to have possibility to check weather using map


Scenario: Weather on region
Given Im on the http://pogoda.yandex.by
When I find Москва using search
And I choose weather on map
Then I can see map Погода view

