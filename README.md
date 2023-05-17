# Measurement Conversion

The Measurement Conversion API is designed to solve the problem of converting measurement input strings into a list of the total values of measured inflows for each package. The API provides a GET endpoint that accepts a query parameter "convert-measurements" containing the measurement input string. The endpoint parses the input string, converts the measurements into a list of the total value of measured inflows for each package, and returns the result in JSON format.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Environment Setup](#environment-setup)
- [Build Instructions](#build-instructions)
- [API Usage](#api-usage)
  - [Running the API with Docker](#running-the-api-with-docker)
  - [Running the API with Docker Compose](#running-the-api-with-docker-compose)
  - [Making API Requests](#making-api-requests)
- [Test this code logic using Python](#test-this-code-logic-using-python)

## Prerequisites

To run the application using Docker, make sure you have the following prerequisites installed:

- Docker
- Docker Compose (optional, for running multiple services)


## Environment Setup

1 - Clone the repository:
 ```
git clone https://github.com/BaraahAlKalbani/MeasurementConversion.git
 ```

2 - Navigate to the project directory:
 ```
cd MeasurementConversion
 ```
3 - move to the API Branch or the develop Branch
```
git checkout API
```
OR :
```
git checkout develop
```

## Build Instructions
 ```
docker build -t measurement-conversion-api .
 ```

# API Usage

## Running the API with Docker

1 - Start the API container:
 ```
docker run -p 8080:8080 -d measurement-conversion-api
 ```

The API will be accessible at http://localhost:8080/api/convert-measurements

## Running the API with Docker Compose

1 - Start the services defined in the Docker Compose file:
 ```
docker-compose up -d
 ```

The API will be accessible at http://localhost:8080/api/convert-measurements

2 - Stop the services:
 ```
docker-compose down
 ```

## Making API Requests

To convert measurements, make a GET request to the /api/convert-measurements endpoint with the measurement input string as a query parameter. The API will parse the input string, convert the measurements, and return the result in JSON format.

Example request:
GET
http://localhost:8080/api/convert-measurements?input=dz_a_aazzaaa

Example response:
 ```
{
    "converted_value": [
        28,
        53,
        1
    ],
    "input": "dz_a_aazzaaa",
    "status": "Success"
}
 ```
If the input is invalid, the API will return an error message in the response:
 ```
{
    "converted_value": null,
    "input": "aav",
    "status": "Invalid input: Invalid input. Input calculation is not adding up!"
}
 ```
 
 That's it! You have successfully set up and run the Measurement Conversion API using Docker.
 
# Test this code logic using Python
run:
```
import requests

url = 'http://localhost:8080/api/convert-measurements'  # Update the URL with the correct port

expected_io = [
    ('aa', [1]),
    ('abbcc', [2, 6]),
    ('dz_a_aazzaaa', [28, 53, 1]),
    ('_', [0]),
    ('', []),
    ('a_', [0]),
    ('abcdabcdab', [2, 7, 7]),
    ('abcdabcdab_', [2, 7, 7, 0]),
    ('zdaaaaaaaabaaaaaaaabaaaaaaaabbaa', [34]),
    ('zza_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_', [26]),
    ('za_a_a_a_a_a_a_a_a_a_a_a_azaaa', [40, 1])
]

for req_inp, expected_output in expected_io:
    response = requests.get(url, params={'input': req_inp})
    output = response.json()

    assert output['converted_value'] == expected_output, "Unexpected Output"

print("All test cases passed successfully!")
```
