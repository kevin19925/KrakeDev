--- agregacion
----ejemplo de coubt 
select count(ec.codigo)|
from personas per, estado_civil ec
where per.estado_civil_codigo = ec.codigo
and estado_civil_codigo = 'C'

--- avg
--cast 
select AVG (cast (cantidad_ahorrada as numeric))
from personas

select AVG (cast (cantidad_ahorrada as numeric))
from personas per, estado_civil ec
where per.estado_civil_codigo = ec.codigo
and estado_civil_codigo = 'C'

--sum -- max min
select MAX (cast (cantidad_ahorrada as numeric))
from personas

select SUM(cast (cantidad_ahorrada as numeric))
from personas per, estado_civil ec
where per.estado_civil_codigo = ec.codigo
and estado_civil_codigo = 'C'

--- group by


select * from personas
group by estado_civil_codigo

-- cuenta cada estado civil 
select estado_civil_codigo, count (*)
from personas
group by estado_civil_codigo

