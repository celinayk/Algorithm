select count(t1.id) as FISH_COUNT
from FISH_INFO t1 inner join FISH_NAME_INFO t2 on t1.FISH_TYPE = t2.FISH_TYPE
where t2.FISH_NAME like '%BASS%' or t2.FISH_NAME like '%SNAPPER%' 