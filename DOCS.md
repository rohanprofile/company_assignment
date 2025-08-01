# company_assignment


Curls to use >>


1)

curl --location --request POST 'http://localhost:8080/webhook/payments' \
--header 'Content-Type: application/json' \
--header 'X-Razorpay-Signature: TEST_SIGNATURE' \
--data-raw '{
    "event": "payment.failed",
    "payload": {
      "payment": {
        "entity": {
          "id": "pay_001",
          "status": "failed",
          "amount": 1000,
          "currency": "INR"
        }
      }
    },
    "created_at": 1751886085,
    "id": "evt_fail_001"
  }'
  
  
  2)
  
  curl --location --request GET 'http://localhost:8080/payments/pay_001/events'
  
  