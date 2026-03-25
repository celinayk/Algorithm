select b.CATEGORY, sum(s.SALES) as TOTAL_SALES
from BOOK b join BOOK_SALES s on b.book_id = s.book_id
where s.SALES_DATE like '2022-01%'
group by b.CATEGORY
order by b.CATEGORY