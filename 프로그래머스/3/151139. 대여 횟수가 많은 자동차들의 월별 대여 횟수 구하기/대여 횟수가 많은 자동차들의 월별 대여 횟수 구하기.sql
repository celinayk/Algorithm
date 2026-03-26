select MONTH(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
        Select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE between '2022-08-01' and '2022-10-31'
        group by CAR_ID
        having count(HISTORY_ID) >=5 # 8~10월사이에 5회이상 대여된 차id 
        )
and START_DATE between '2022-08-01' and '2022-10-31' # 단골차량전체기록 중 다시한번 
group by MONTH, CAR_ID
order by MONTH asc, CAR_ID desc