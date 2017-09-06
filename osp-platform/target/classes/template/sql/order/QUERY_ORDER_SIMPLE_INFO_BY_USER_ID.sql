SELECT
    T1.ORDER_TYPE_ID           AS ORDER_TYPE_ID,
    T1.ORDER_TYPE_NAME         AS ORDER_TYPE_NAME,
    T1.ORDER_TYPE_SUM          AS ORDER_TYPE_SUM,
    NVL(T2.CRITICAL_COUNT, 0 ) AS CRITICAL_COUNT,
    NVL(T3.OVERDUE_CUNT, 0 )   AS OVERDUE_CUNT
FROM
    (
        SELECT
            COUNT(ORDER_TYPE_ID) AS ORDER_TYPE_SUM,
            ORDER_TYPE_ID        AS ORDER_TYPE_ID,
            ORDER_TYPE_NAME      AS ORDER_TYPE_NAME
        FROM
            ORDER_MAIN_OSP
        WHERE
            PROCESS_USER_ID = :PROCESS_USER_ID
        AND ORDER_STATUS IN ('010',  '020',  '030',  '040',  '050',  '060')
        GROUP BY
            ORDER_TYPE_ID,
            ORDER_TYPE_NAME) T1
LEFT JOIN
    (
        SELECT
            COUNT(ORDER_M_ID) AS CRITICAL_COUNT,
            ORDER_TYPE_ID     AS ORDER_TYPE_ID
        FROM
            ORDER_MAIN_OSP
        WHERE
            PROCESS_USER_ID = :PROCESS_USER_ID
        AND CRITICAL_FLAG = 'Y'
        GROUP BY
            ORDER_TYPE_ID ) T2
ON
    T1.ORDER_TYPE_ID = T2.ORDER_TYPE_ID
LEFT JOIN
    (
        SELECT
            COUNT(T1.ORDER_M_ID) AS OVERDUE_CUNT,
            T1. ORDER_TYPE_ID    AS ORDER_TYPE_ID
        FROM
            ORDER_MAIN_OSP T1
        LEFT JOIN
            SYS_ORDER_TYPE_SETTING T2
        ON
            T1.ORDER_TYPE_ID = T2.ORDER_TYPE_ID
        WHERE
            T1.PROCESS_USER_ID = :PROCESS_USER_ID
        AND T1.ORDER_STATUS IN ('010',  '020',  '030',  '040',  '050',  '060')
        AND (
                T1.EXPECT_COMPLETE_TIME - T2.OVERTIME / (24 * 60)) - SYSDATE < 0
        GROUP BY
            T1.ORDER_TYPE_ID ) T3
ON
    T1.ORDER_TYPE_ID = T3.ORDER_TYPE_ID
ORDER BY
    T1.ORDER_TYPE_ID