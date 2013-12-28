SELECT last_name 
FROM employees
WHERE last_name 
NOT LIKE '%A\_B%' ESCAPE '\'
ORDER BY last_name; 