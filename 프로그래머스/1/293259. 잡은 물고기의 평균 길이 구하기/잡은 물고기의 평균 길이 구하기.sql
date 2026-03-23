-- 코드를 작성해주세요
select round(sum(ifnull(LENGTH, 10))/count(ID), 2) as AVERAGE_LENGTH
from FISH_INFO

