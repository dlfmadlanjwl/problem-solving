SELECT SUM(SCORE) AS SCORE, EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_GRADE
JOIN HR_EMPLOYEES USING (EMP_NO)
WHERE YEAR = 2022
GROUP BY EMP_NO
ORDER BY SCORE DESC
LIMIT 1