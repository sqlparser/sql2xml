SELECT last_name
FROM employees
WHERE commission_pct
IS NOT NULL
ORDER BY last_name;