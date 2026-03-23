-- 코드를 입력하세요
SELECT count(USER_ID)
FROM USER_INFO
WHERE JOINED like '2021%' and ( age >=20 and age <=29)