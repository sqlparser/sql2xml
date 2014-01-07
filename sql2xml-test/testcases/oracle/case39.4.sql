SELECT * FROM employees
WHERE job_id NOT IN
('PU_CLERK', 'SH_CLERK')
ORDER BY employee_id;