SELECT
    COUNT(*) AS COUNT
FROM
    ORDER_MAIN_OSP T1
LEFT JOIN
    SYS_ORDER_TYPE_SETTING T2
ON
    T1.ORDER_TYPE_ID = T2.ORDER_TYPE_ID
WHERE
    $P{CONDITION}
AND (
        T1.EXPECT_COMPLETE_TIME - T2.OVERTIME / (24 * 60)) - SYSDATE < 0