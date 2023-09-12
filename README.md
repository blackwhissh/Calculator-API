## Calculator API Documentation
# Overview
This documentation provides details about the Calculator API, which allows users to perform various mathematical operations. The API supports addition, subtraction, multiplication, division, and factorial calculations.

# Endpoints
# 1. Addition
Endpoint: /add

HTTP Method: POST
Description: This endpoint allows you to perform addition between two operands.
Input:
operand1 (numeric): The first operand.
operand2 (numeric): The second operand.
Response:
message (string): An optional message describing the result.
error (boolean): Indicates whether an error occurred during the operation.
result (numeric): The result of the addition.
Example Request
json
POST /add
{
  "operand1": 5,
  "operand2": 3
}
Example Response
json
{
  "message": "",
  "error": false,
  "result": 8
}
# 2. Subtraction
Endpoint: /subtract

HTTP Method: POST
Description: This endpoint allows you to perform subtraction between two operands.
Input:
operand1 (numeric): The first operand.
operand2 (numeric): The second operand.
Response: (Same structure as the /add endpoint)
# 3. Multiplication
Endpoint: /multiply

HTTP Method: POST
Description: This endpoint allows you to perform multiplication between two operands.
Input:
operand1 (numeric): The first operand.
operand2 (numeric): The second operand.
Response: (Same structure as the /add endpoint)
Edge cases: One or more operand should not be null.
# 4. Division
Endpoint: /divide

HTTP Method: POST
Description: This endpoint allows you to perform division between two operands.
Input:
operand1 (numeric): The dividend.
operand2 (numeric): The divisor.
Response: (Same structure as the /add endpoint)
Edge cases: Number can not be divided by 0.
# 5. Factorial
Endpoint: /factorial

HTTP Method: POST
Description: This endpoint calculates the factorial of a given integer.
Input:
operand1 (integer): The integer for which the factorial is calculated.
operand2 (null): Should always be null for this operation.
Response: (Same structure as the /add endpoint)
Edge cases: Second operand should be null. Main operand should be a positive integer.
# Error Handling
In case of invalid input or errors during operation, the API will return an error message with error set to true and an appropriate error message in the message field.
Specific error scenarios are documented for each endpoint.
