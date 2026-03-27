select a.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, a.APNT_YMD
from PATIENT p join APPOINTMENT a on a.PT_NO = p.PT_NO
               join DOCTOR d on a.MDDR_ID = d.DR_ID
where APNT_YMD like '2022-04%' and APNT_CNCL_YMD is null and a.MCDP_CD='CS'
order by a.APNT_YMD