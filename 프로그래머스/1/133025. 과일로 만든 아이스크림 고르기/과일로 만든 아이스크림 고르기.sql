-- 코드를 입력하세요
SELECT t1.FLAVOR
from FIRST_HALF t1 inner join ICECREAM_INFO t2 on t1.FLAVOR = t2.FLAVOR
where t1.TOTAL_ORDER>=3000 and t2.INGREDIENT_TYPE = 'fruit_based'
order by t1.TOTAL_ORDER desc