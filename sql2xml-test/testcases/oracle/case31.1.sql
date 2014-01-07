select department_id,department_name,
location_id,city
from departments
natural join locations
where department_id in (20,30);