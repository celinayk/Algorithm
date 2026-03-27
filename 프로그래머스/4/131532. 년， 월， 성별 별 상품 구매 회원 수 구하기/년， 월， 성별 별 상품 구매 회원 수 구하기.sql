Select YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, 
        GENDER, count(distinct u.user_id) as USERS
from USER_INFO u join ONLINE_SALE s on u.USER_ID = s.USER_ID
where GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER