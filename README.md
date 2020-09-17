# health-metrics-app
 MapStruct library and JPA ManyToOne example

## Requirements - HEALTH PLATFORM
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
### Problem Statement
We want to build a generic cloud based platform to record various health metric of a given user.
It has two main consumers.
1. User
2. Different Devices.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Please build an application that exposes following features to other applications
1. API to register user.
2. API to register a mobile number to a user.
3. API to push metric. Sample metrics should be (height, weight, heart-rate, calorie, calorie-burn). The type of metrics supported are predefined and new type of metrics can be added.
4. API to get all data points of a metric for a user across different devices in a given duration.
5. API to get an appropriate aggregate (max, min, average etc) in a time range for a metric across different devices for a given user.
6. User Interface, to do the following
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Ability for a user to login. Just username is enough. No need to worry about authentication.
2. Pull up user’s data in following cuts
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Daily metric average for all metrics.
2. Weekly metric for all metrics.
3. Screen showing all devices that have been registered against the user. 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### project build using gradle 
`gradle clean build`
### project build using maven
`mvn clean install`

### project launch
`mvn spring-boot:run`

## API input and output which I have tested.
----------------------------------------------------------------------------------------------------
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
POST: http://localhost:8080/mobile
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
    "hearthRatePerMinutes": 100,
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
    "averageHearthRatePerMinutes": 100,
    "averageCalories": 138.0,
    "averageCaloriesBurn": 34.0
}

