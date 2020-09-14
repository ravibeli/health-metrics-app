# health-metrics-app
 MapStruct library and JPA ManyToOne example
### project build using gradle 
`gradle clean build`
### project build using maven
`mvn clean install`

### project launch
`mvn spring-boot:run`

## API input and output which I have tested.
-----------------------------------------------------------------------------------------------------
POST:  http://localhost:8080/users
#### Input:
{
    "emailId":"ravi@gmail.com",
    "firstName":"ravi",
    "lastName":"beli",
    "age": 38
}   
#### Output:
{
    "createdDate": "2020-09-13T03:45:52.543+00:00",
    "updatedDate": "2020-09-13T03:45:52.543+00:00",
    "userId": 1,
    "emailId": "ravi@gmail.com",
    "firstName": "ravi",
    "lastName": "beli",
    "age": 38
}

-----------------------------------------------------------------------------------------------------
POST: http://localhost:8080/device
#### Input:
{
    "emailId": "ravi@gmail.com",
    "mobileNumber": "1111111000"
}
#### Output:
{
    "createdDate": "2020-09-13T03:45:54.791+00:00",
    "updatedDate": "2020-09-13T03:45:54.791+00:00",
    "deviceId": 1,
    "userId": 1,
    "emailId": "ravi@gmail.com",
    "mobileNumber": 1111111000,
    "deviceType": "MOBILE"
}

-----------------------------------------------------------------------------------------------------
POST: http://localhost:8080/health_metrics
#### Input: (Post this input multiple times for more health record against the same mobile number)
{
	  "mobileNumber": 1111111000,
	  "height": 111,
	  "weight": 67,
	  "hearthRatePerMinutes": 90,
	  "calories": 130,
	  "caloriesBurn": 10
}
#### Output:
{
    "userHealthParamId": 4,
    "userId": 1,
    "mobileNumber": 1111111000,
    "deviceId": 2
    "height": 130,
    "weight": 70,
    "hearthRatePerMinutes": 120,
    "calories": 130,
    "caloriesBurn": 10,
    "createdDate": "2020-09-13T03:46:18.209+00:00",
    "updatedDate": "2020-09-13T03:46:18.209+00:00"
}

----------------------------------------------------------------------------------------------
GET: http://localhost:8080/health_metrics/aggregation?mobileNumber=1111111000
#### Output: (Aggregates for the health records for the mobile number the user owns it)
{
    "mobileNumber": 1111111000,
    "averageHeight": 111.0,
    "averageWeight": 67.0,
    "averageCalories": 138.0,
    "averageCaloriesBurn": 34.0
}

