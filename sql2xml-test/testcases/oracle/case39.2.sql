SELECT * FROM employees
WHERE salary IN
(SELECT salary 
FROM employees
WHERE department_id =30)
ORDER BY employee_id;