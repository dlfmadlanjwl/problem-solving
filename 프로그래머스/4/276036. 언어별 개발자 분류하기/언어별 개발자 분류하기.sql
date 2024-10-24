WITH front_developer AS (SELECT *
FROM DEVELOPERS AS D
JOIN (SELECT CODE FROM SKILLCODES WHERE CATEGORY = 'Front End') AS S
ON D.SKILL_CODE & S.CODE)
,c_developer AS (SELECT *
FROM DEVELOPERS AS D
JOIN (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') AS S
ON D.SKILL_CODE & S.CODE)
,python_developer AS (SELECT *
FROM DEVELOPERS AS D
JOIN (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') AS S
ON D.SKILL_CODE & S.CODE)

SELECT *
FROM (SELECT 
    CASE
        WHEN (
            ID IN (SELECT ID FROM front_developer)
            AND ID IN (SELECT ID FROM python_developer)
        )
        THEN 'A'
        WHEN (
            ID IN (SELECT ID FROM c_developer)
        )
        THEN 'B'
        WHEN (
            ID IN (SELECT ID FROM front_developer)
        )
        THEN 'C'
        ELSE 'D'
    END AS GRADE, ID, EMAIL
FROM DEVELOPERS
ORDER BY GRADE, ID) AS RESULT
WHERE RESULT.GRADE != 'D'