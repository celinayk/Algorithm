-- 코드를 작성해주세요
select t2.item_id, t1.ITEM_NAME
from ITEM_INFO t1 inner join ITEM_TREE t2 on t1.ITEM_ID = t2.ITEM_ID
where t2.PARENT_ITEM_ID is null 