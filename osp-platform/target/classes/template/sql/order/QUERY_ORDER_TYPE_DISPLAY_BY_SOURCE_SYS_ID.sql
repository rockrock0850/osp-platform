SELECT DISTINCT
    ORDER_TYPE_ID,
    ORDER_TYPE_NAME
FROM
    SYS_FLOW_SOURCE_MAP
WHERE
    SOURCE_SYS_ID = :SOURCE_SYS_ID