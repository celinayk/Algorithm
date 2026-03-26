select p.PRODUCT_ID, p.PRODUCT_NAME, sum(o.AMOUNT*p.price) as TOTAL_SALES 
from FOOD_PRODUCT p join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID 
where p.PRODUCT_ID in ( # 22, 23, 24
    select p.PRODUCT_ID 
    from FOOD_PRODUCT p join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID 
    where o.PRODUCE_DATE like '2022-05%' )  and  o.PRODUCE_DATE like '2022-05%'
group by p.PRODUCT_ID order by TOTAL_SALES desc, p.PRODUCT_ID