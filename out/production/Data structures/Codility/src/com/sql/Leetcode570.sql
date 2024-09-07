--https://leetcode.com/problems/managers-with-at-least-5-direct-reports/description/?envType=study-plan-v2&envId=top-sql-50
--# Write your MySQL query statement below
SELECT Manager.name
FROM Employee Manager
JOIN Employee DirectReport ON Manager.id = DirectReport.managerId
GROUP BY Manager.id, Manager.name
HAVING COUNT(DISTINCT DirectReport.id) >= 5;