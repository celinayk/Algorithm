select i.REST_ID, i.REST_NAME, i.FOOD_TYPE,
       i.FAVORITES, i.ADDRESS, round(avg(REVIEW_SCORE), 2) as SCORE
from REST_INFO i join REST_REVIEW r on i.REST_ID = r.REST_ID
where i.ADDRESS like '서울%'
group by i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.ADDRESS, i.FAVORITES
order by round(avg(REVIEW_SCORE), 2) desc, i.FAVORITES desc