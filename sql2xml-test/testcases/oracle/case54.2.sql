SELECT *
FROM employees
WHERE NOT 
(salary BETWEEN 1000 AND 2000)
ORDER BY employee_id;