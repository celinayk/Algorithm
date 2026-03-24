select count(t2.FISH_NAME) as FISH_COUNT, t2.FISH_NAME
from FISH_INFO t1 inner join FISH_NAME_INFO t2 on t1.FISH_TYPE=t2.FISH_TYPE
group by t1.FISH_TYPE, t2.FISH_NAME
order by 1 desc