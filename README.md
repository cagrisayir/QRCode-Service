# QRCode Service

This project utilizes QR codes - 2D barcodes that can store large amounts of data and are easily read by smartphones.

### Technologies
* Java 17
* Spring Boot
* zxing Library: To generate QRCode 
* BufferImage

`http://localhost:8181/api/qrcode?contents=url`

<img width="860" alt="image" src="https://github.com/cagrisayir/QRCode-Service/assets/44059539/e1fe40c4-a8e5-46f3-b9c5-1ea392f23d5b">

optional parameters: 
* size: 250 (150<size<350),
* correction: L (Q, L, M, H),
* type: png (png, jpeg, gif).
