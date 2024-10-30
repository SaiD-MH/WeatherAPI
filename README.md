# Weather API Integration Project

This is a simple Spring Boot project that integrates with the Visual Crossing Weather API to retrieve weather information. It demonstrates how to interact with a third-party API, handle optional query parameters, and format responses for easy access.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Technologies Used](#technologies-used)
  
---

## Project Overview

This project connects to the Visual Crossing Weather API to retrieve weather data for specified locations and date ranges. Optional parameters like start date and end date are available, defaulting to the current date if left unspecified.

## Features

- **Date Range Validation**: Ensures that the end date is not before the start date.
- **Optional Query Parameters**: If no dates are provided, defaults to the current date.
- **Environment Variable Security**: API key stored securely as an environment variable.
- **Error Handling**: Catches and logs API request failures to prevent application crashes.

## Getting Started

### Prerequisites

- Java 11 or later
- Maven
- [Visual Crossing Weather API Key](https://www.visualcrossing.com/)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/SaiD-MH/WeatherAPI-External-Service
   cd WeatherAPI-External-Service
   ```

2. **Set up environment variables**:
  Configure your API key in the environment variables. For example, in a Unix-based system
   
    ```export API_KEY=your_visualcrossing_api_key```

3. **Build and run the project:**

    `mvn clean install`

    `mvn spring-boot:run`

### Configuration

  Ensure you have set the API_KEY as an environment variable. This key will be injected into the ThirdPartyImpl class to authenticate requests to the Visual Crossing Weather API.
  Alternatively, create an application.properties file and add:
  
  ```API_KEY=your_visualcrossing_api_key```


### Usage

  To retrieve weather data, make a GET request to the /weather endpoint, specifying the following parameters:

* location (required): The location for which you want weather data.
* startDate (optional): The start date in `yyyy-MM-dd` format.
* endDate (optional): The end date in `yyyy-MM-dd` format.


```
Example request:
GET api/weather?location=London&startDate=2024-10-20&endDate=2024-10-25
```

### API Endpoints
**`GET /weather`**: Retrieve weather data for a given location and date range.

| Parameter  | Type   | Description                          |
|------------|--------|--------------------------------------|
| location   | String | Required. Location for weather data. |
| startDate  | String | Optional. Start date in `yyyy-MM-dd`. |
| endDate    | String | Optional. End date in `yyyy-MM-dd`.   |



### Technologies Used

* Java 17
* Spring Boot: For creating REST API
* Jackson: To parse JSON responses from the Weather API
* Maven: Dependency management
