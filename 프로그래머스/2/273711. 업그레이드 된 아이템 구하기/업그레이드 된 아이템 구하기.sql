select t1.ITEM_ID, t1.ITEM_NAME, t1.RARITY
from ITEM_INFO t1 join ITEM_TREE t2 on t1.ITEM_ID = t2.ITEM_ID
                  join ITEM_INFO t3 on t2.PARENT_ITEM_ID = t3.ITEM_ID
where t3.RARITY = 'RARE'  
order by 1 desc