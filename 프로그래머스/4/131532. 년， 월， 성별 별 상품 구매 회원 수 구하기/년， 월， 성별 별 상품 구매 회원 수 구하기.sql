SELECT 
    YEAR(SALES_DATE) 'YEAR',
    MONTH(SALES_DATE) 'MONTH', 
    GENDER, 
    COUNT(DISTINCT USER_INFO.USER_ID) 'USERS'
FROM ONLINE_SALE
JOIN USER_INFO ON 
    USER_INFO.USER_ID = ONLINE_SALE.USER_ID 
WHERE USER_INFO.GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER
ORDER BY YEAR, MONTH, GENDER