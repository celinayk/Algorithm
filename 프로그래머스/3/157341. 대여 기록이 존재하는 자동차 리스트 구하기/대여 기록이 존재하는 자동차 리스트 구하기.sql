-- 코드를 입력하세요
select distinct c.CAR_ID
from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.CAR_ID = h.CAR_ID
where c.CAR_TYPE = '세단' and MONTH(h.start_date) = '10'
order by 1 desc