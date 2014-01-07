select employee_id,city,department_name
from demployee e
join department d
on d.department_id = e.department_id
join locations l
on d.location_id = l.location_id;