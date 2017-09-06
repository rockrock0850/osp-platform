SELECT DISTINCT
    T1.ORDER_M_ID,
    T1.OSP_CREATE_TIME,
    T1.UPDATE_DATE,
    T1.MSISDN,
    T2.STATUS_NAME,
    T3.REASON_TEXT,
    T1.COMMMENT
FROM
    ORDER_MAIN_OSP T1
LEFT JOIN
    SYS_ORDER_STATUS_SETTING T2
ON
    T1.ORDER_STATUS=T2.STATUS_ID
LEFT JOIN
    SYS_REASON T3
ON
    T1.PROCESS_REASON = T3.REASON_ID
WHERE
    $P{CONDITION}
ORDER BY
    T1.OSP_CREATE_TIME