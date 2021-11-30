# testInterseguro

curl --location --request POST 'localhost:8080/payment/v1/session' \
--header 'Content-Type: application/json' \
--data-raw '{
   "amount": 1.00,
   "clientIP": "10.29.1.75",
    "currency": "PEN",
    "channel": "web"
}'
