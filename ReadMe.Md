Tanishk Nalamolu | SHIFT App Beta

| App Description |
The SHIFT app takes a String and an Integer, then shifts the characters in the string by the amount of the integer starting with the ending characters first.

| What the App Does |  
1. React or Postman (Frontend) takes user input as a raw JSON body and sends it to the backend with an HTTP POST request.
2. ShiftController (Backend) recieves the request, mapping to a DTO
3. DTO (ShiftRequest.java) validates input to ensure correct format using Jakarta validation and stores it in Input (String) and Shift(integer)
4. GlobalEceptionHandle catches validation errors and returns formatted error responses
5. If validation passes, the ShiftController passes data to the App Logic (ShiftService.java)
6. The ShiftController returns the result (ShiftResponse.java) as Original(String) and Shifted(String), which is displayed on preferred frontend Postman or React.

| Flow |
Frontend → ShiftController → ShiftRequest (validation) → ShiftService (logic) → ShiftResponse → Frontend

| Instructions to Run the Program | 
System Requirements: JAVA (17 or higher), NODE JS (11.2.0 or higher) or POSTMAN
Clone Repository to a local folder
1. In CMD terminal navigate to 'CodingExerciseAMA\backend' and run './mvnw spring-boot:run' OR alternatively try 'mvnw spring-boot:run'
-- Server should be running if SPRING Lettering appears in the terminal --

2. Test the backend with POSTMAN by going to localhost:8080/api/shift and sending a POST request body raw JSON Object
-- EXAMPLE --
{
"input":"hello world",
"shift":5
}
Output should appear with original and shifted result i.e:
{
"original":"hello world",
"shifted":"helloworld "
}

For Front end Interactivity: 
3. In CMD navigate to 'frontend' and run 'npm run start'

| File Structure |
- backend - Spring boot framework JAVA 
    - Main\java\com\tanishk\codingExercise (Core App)
- frontend - REACT JS
    - App.js
- Tests
    - test\java\com\tanishk\codingExercise (can be run with ./mvnw test)

Jakarta Tests Successfully Validate:
- Shift Integer cannot be Negative
- Input String cannot be null
- Input String cannot be blank
- Input String cannot contain special characters or numbers 
Happy Paths:
- Input String with Spaces works 1x test case  
- Input String = shifted String works when string length = shift integer  
- Edge Cases: Input String at 20 digits and shift at 99 digits works, Input String of Single character with max Shift works
