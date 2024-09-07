--# Write your MySQL query statement below
--https://leetcode.com/problems/rising-temperature/?envType=study-plan-v2&envId=top-sql-50
SELECT weather.Id AS Id
FROM Weather AS weather
JOIN Weather AS prev_weather ON weather.RecordDate = DATE_ADD(prev_weather.RecordDate, INTERVAL 1 DAY)
WHERE weather.Temperature > prev_weather.Temperature;