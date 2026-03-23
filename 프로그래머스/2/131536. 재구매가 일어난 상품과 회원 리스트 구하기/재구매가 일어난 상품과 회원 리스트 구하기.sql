-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP by user_id, product_id
HAVING COUNT(*) >= 2
ORDER BY user_id, product_id desc