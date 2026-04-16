-- Active: 1744015454928@@127.0.0.1@33700@f1_2023
/* informe amb tots els pilots que han puntuat, mostrant el nom, equip, puntuació i millor posició. */

select DISTINCT (driver_id),
    first_name,
    last_name,
    team_name,
    points,
    position
from results
    left join drivers USING (driver_id)
    left join teams using (team_id) 
    where position < 2
order by position
/* limit 6 */