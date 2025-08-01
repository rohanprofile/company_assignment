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





<img width="2112" height="1451" alt="image" src="https://github.com/user-attachments/assets/f38b4a34-440d-4f8f-977a-62d127570c7b" />

  
<img width="1787" height="1443" alt="image" src="https://github.com/user-attachments/assets/7d52aa4c-44ff-4103-9eec-17b30e2aeecd" />



**Invalid Json Curl as currency is null
**

<img width="1968" height="1210" alt="image" src="https://github.com/user-attachments/assets/c348d45d-7845-4309-a26d-b65d21125400" />


**Dudupe Check
**
<img width="1960" height="1327" alt="image" src="https://github.com/user-attachments/assets/b0e7fb90-c5bd-480d-a669-f40720a9d8e6" />



**Database 
**

<img width="2076" height="1025" alt="image" src="https://github.com/user-attachments/assets/7a7e550b-0735-44d0-8544-162f1c94acd3" />



  

  
  
