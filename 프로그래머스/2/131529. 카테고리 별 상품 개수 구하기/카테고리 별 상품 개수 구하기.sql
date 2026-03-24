-- 코드를 입력하세요
SELECT substr(PRODUCT_CODE, 1, 2) as CATEGORY,
       count(distinct PRODUCT_ID) as PRODUCTS
from PRODUCT
group by 1