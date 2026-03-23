-- 코드를 입력하세요
SELECT t1.title, t1.BOARD_ID, t2.REPLY_ID, t2.WRITER_ID, 
        t2.CONTENTS, date_format( t2.CREATED_DATE, "%Y-%m-%d")
from USED_GOODS_BOARD t1 inner join USED_GOODS_REPLY t2 
     on t1.BOARD_ID = t2.BOARD_ID
where t1.CREATED_DATE like '2022-10%' 
order by t2.CREATED_DATE, t1.TITLE