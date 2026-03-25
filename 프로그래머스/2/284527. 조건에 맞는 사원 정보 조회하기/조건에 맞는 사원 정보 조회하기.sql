select sum(t3.score) as score, t2.EMP_NO, t2.EMP_NAME, t2.POSITION, t2.EMAIL
from HR_DEPARTMENT t1 inner join HR_EMPLOYEES t2 on t1.DEPT_ID = t2.DEPT_ID
                      inner join HR_GRADE t3 on t2.EMP_NO = t3.EMP_NO
where t3.YEAR = '2022'
group by t2.EMP_NO
order by score desc limit 1