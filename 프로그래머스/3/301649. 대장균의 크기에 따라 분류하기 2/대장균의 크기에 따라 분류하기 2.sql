SELECT 
    id,
    CASE
        WHEN t1.chml = 1 THEN 'LOW'
        WHEN t1.chml = 2 THEN 'MEDIUM'
        WHEN t1.chml = 3 THEN 'HIGH'
        ELSE 'CRITICAL'
    END AS colony_name
FROM 
    (SELECT 
        id,
        NTILE(4) OVER(ORDER BY size_of_colony) AS chml
    FROM ECOLI_DATA) AS t1
ORDER BY t1.id