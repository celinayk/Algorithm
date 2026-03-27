with max as (
select m.MEMBER_ID, m.MEMBER_NAME, count(r.REVIEW_ID) as REVEW_COUNT
from MEMBER_PROFILE m join REST_REVIEW r on m.MEMBER_ID = r.MEMBER_ID
group by r.MEMBER_ID
order by count(r.REVIEW_ID)  desc
    limit 1
)

select m.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from max m join REST_REVIEW r on m.MEMBER_ID = r.MEMBER_ID
order by REVIEW_DATE, r.REVIEW_TEXT