--https://leetcode.com/problems/employee-bonus/description/?envType=study-plan-v2&envId=top-sql-50
SELECT Employee.name,Bonus.bonus FROM Employee
LEFT JOIN Bonus ON Employee.empID = Bonus.empID
WHERE bonus < 1000 OR Bonus IS NULL ;