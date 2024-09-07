--https://leetcode.com/problems/students-and-examinations/?envType=study-plan-v2&envId=top-sql-50
SELECT S.student_id, s.student_name, T.subject_name, count( E.student_id) AS attended_exams FROM Students S CROSS JOIN Subjects T
LEFT JOIN Examinations E on E.student_id = S.student_id AND E.subject_name = T.subject_name
GROUP BY S.student_id, s.student_name, T.subject_name
ORDER BY S.student_id,T.subject_name ASC;