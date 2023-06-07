select reverse(s.name) as 'reversed_name', concat(upper(t.name),'-', a.name) as 'full_address', count(e.id) as 'employees_count' from stores as s
left join addresses as a on a.id = s.address_id
left join towns as t on t.id = a.town_id
left join employees as e on e.store_id = s.id
group by s.id
having employees_count >=1
order by  full_address 