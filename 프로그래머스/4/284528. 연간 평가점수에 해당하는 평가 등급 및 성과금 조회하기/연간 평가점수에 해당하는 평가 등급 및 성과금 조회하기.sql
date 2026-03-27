select e.EMP_NO, e.EMP_NAME,
        case when AVG(g.SCORE) >=96 then 'S'
             when AVG(g.SCORE) >=90 then 'A'
             when AVG(g.SCORE) >=80 then 'B'
             else 'C'
             end as GRADE,
        CASE
            WHEN AVG(g.SCORE) >= 96 THEN e.SAL * 0.2
            WHEN AVG(g.SCORE) >= 90 THEN e.SAL * 0.15
            WHEN AVG(g.SCORE) >= 80 THEN e.SAL * 0.1
        ELSE 0
    END AS BONUS
from HR_DEPARTMENT d join HR_EMPLOYEES e on d.DEPT_ID=e.DEPT_ID 
                    join HR_GRADE g on g.EMP_NO = e.EMP_NO
group by e.EMP_NO
order by e.EMP_NO
