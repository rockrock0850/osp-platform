SELECT
    FLOW_ID
FROM
    BUZ_FLOW
WHERE
    ORDER_TYPE_ID=:ORDER_TYPE_ID
AND SOURCE_SYS_ID=:SOURCE_SYS_ID