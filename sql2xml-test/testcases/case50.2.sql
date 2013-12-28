
SELECT customer_id, cust_address_ntab
FROM customers_demo
WHERE '8768 N State Rd 37'
NOT MEMBER OF cust_address_ntab
ORDER BY customer_id;
