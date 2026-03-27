select h.FLAVOR
from FIRST_HALF h join (
select FLAVOR, sum(TOTAL_ORDER) as jj
            from JULY
            group by FLAVOR)j  on h.FLAVOR = j.FLAVOR
order by (h.TOTAL_ORDER+ j.jj) desc
limit 3