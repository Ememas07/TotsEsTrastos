select *
from results
    left join drivers USING (driver_id)
    left join teams USING (team_id)
where points > 1;