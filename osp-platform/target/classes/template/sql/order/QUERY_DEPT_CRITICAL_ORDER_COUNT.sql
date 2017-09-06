SELECT
    COUNT(*) AS COUNT
FROM
    ORDER_MAIN_OSP T1
JOIN
    (
        SELECT
            T2.ORDER_TYPE_ID
        FROM
            SYS_SKILL_MEMBER_REF T1
        JOIN
            SYS_SKILL_ORDER_TYPE_MAP T2
        ON
            T1.SKILL_ID = T2.SKILL_ID
        WHERE
            T1.EMPNO = '$P{USER_ID}' ) SKILL_ITEM
ON
    T1.ORDER_TYPE_ID = SKILL_ITEM.ORDER_TYPE_ID
WHERE
    $P{CONDITION}
AND T1.ORDER_STATUS = '000'
AND T1.CRITICAL_FLAG = 'Y'