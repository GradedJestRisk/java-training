SELECT id, content->'reference' AS reference, content FROM item;
SELECT jsonb_pretty(i.content) FROM inventory i;
SELECT plain.* FROM inventory i, JSON_TABLE( i.content, '$.items[*]' COLUMNS ( id FOR ORDINALITY, reference TEXT PATH '$.reference')) AS plain ORDER BY plain.id;