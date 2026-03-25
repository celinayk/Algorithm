select ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE,'%Y-%m-%d') AS OUT_DATE, 
        case when date_format(OUT_DATE, '%Y-%m-%d') <= '2022-05-01' then '출고완료'
             when date_format(OUT_DATE, '%Y-%m-%d') > '2022-05-01' then '출고대기'
             else '출고미정'
             end as '출고여부'
from FOOD_ORDER