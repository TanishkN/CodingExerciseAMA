Tanishk Nalamolu | SHIFT App

App Description: The SHIFT app takes two inputs, a String and an Integer, returning an output with the original string shifted by the amount of the second integer 'starting with the ending characters first'. 
    The frontend React application(App.js) takes user input and sends it to the backend with an HTTP POST request. 
    The backend controller(ShiftController) handles the incoming reqest and maps it to a DTO. 
    The DTO (ShiftRequest.java) validates the user input to ensure it meets the data requirement and stores the information in two temporary variables: Input(String) and Shift(int). 
    GlobalExceptionHandler catches exceptions and formats errors into responses when they appear. 
    If the input is valid, the controller passes the data to the App Logic(ShiftService.java) and the controller returns the response (ShiftResponse.java) for display on the frontend Output (App.js)

Instructions to Run the Program: 
    System Requirements: JAVA 17 or higher
Extract both 1) Backend and 2)FrontEnd to a common local folder
1. In CMD navigate to 'backend' and run './mvnw spring-boot:run' OR 'mvnw spring-boot:run'

2. In CMD navigate to 'frontend' and run 'npm run start'

File Structure: 
- backend - Spring boot framework JAVA 
    - Main\java\com\tanishk\codingExercise (Core App)
    - Test\java\com\tanishk\codingExercise (Several Application Test Cases)
- frontend - REACT JS
    - App.js

Next Steps for QA:
- 