# Json Web Token Demo

JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object.

# What is the JSON Web Token structure?
  
 JSON Web Tokens consist of three parts separated by dots (.), which are:
  
  * io.github.mattshen.pgjwt.Header
  * Payload
  * Signature
  
  
# Steps
### Generating JWT
  1. define header
  2. define payload
  3. define secret
  4. get HMAC lib
  5. prepare signing function
        ```
        HMACSHA256(
          base64UrlEncode(header) + "." +
          base64UrlEncode(payload),
          secret)
        ```
### Consuming JWT
  1. decode base64
  2. verify signature
  3. reading content of payload
  
  
### JWT Diagram
![Diagram](docs/jwt-diagram.png "Logo Title Text 1")