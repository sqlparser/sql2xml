SELECT *
FROM employees
WHERE NOT (job_id IS NULL)
ORDER BY employee_id;
