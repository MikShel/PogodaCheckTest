Meta:

Narrative:
In order to check weather
As a user
I want to have possibility to check current and future weather in my town


Scenario: Check current weather
Given Im on the http://pogoda.yandex.by
When I find Москва using search
Then I see current temperature
And I see next time period temperature
And I see detailed weather info

Scenario: Check future weather
Given Im on the http://pogoda.yandex.by
And I want to check weather in Минск
Then I check short future weather

Scenario: Check detailed future weather
Given Im on the http://pogoda.yandex.by
And I want to check weather in Будапешт
Then I check detailed future weather

Scenario: Check detailed future weather
Given Im on the http://pogoda.yandex.by
When I find Брест using search
Then I check climate