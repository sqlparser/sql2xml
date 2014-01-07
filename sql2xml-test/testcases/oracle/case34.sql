select department_id,avg(salary)
from employees
group by department_id
having avg(salary) > 8000
order by sum(salary) desc;