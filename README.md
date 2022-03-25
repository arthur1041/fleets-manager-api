

# API Documentation

## Endpoints

### Contracts
**GET /contracts**
This endpoint returns an array of contracts with this schema:

```ts
{
    id: number,
    description: string,
    payload: Array<Resource>,
    originPlanet: string,
    destinationPlanet: string,
    value: number,
    pilot: Pilot,
    resourcesTotalWeight: number
}
```
**GET /contracts/:id**
This endpoint returns a contract with this schema:
```ts
{
    id: number,
    description: string,
    payload: Array<Resource>,
    originPlanet: string,
    destinationPlanet: string,
    value: number,
    pilot: Pilot,
    resourcesTotalWeight: number
}
```
**GET /contracts/open**
This endpoint returns an array of open contracts with this schema:
```ts
{
    id: number,
    description: string,
    payload: Array<Resource>,
    originPlanet: string,
    destinationPlanet: string,
    value: number,
    pilot: Pilot,
    resourcesTotalWeight: number
}
```
**POST /contracts**
This endpoint creates a contract by sending the following schema as request body:
```ts
{
    description: string,
    payload: Array<Resource>,
    originPlanet: string,
    destinationPlanet: string,
    value: number,
    pilot: {
		id: number
	},
    resourcesTotalWeight: number
}
```
**PUT /contracts/accept/:id**
This endpoint accepts a contract and returns a message with this schema:
```ts
{

message: string

}
```
**PUT /contracts/execute/:id**
This endpoint executes a contract  and returns a message with this schema:
```ts
{

message: string

}
```

### Pilots
**GET /pilots**
This endpoint returns an array of pilots with this schema:

```ts
{
    id: number,
    pilotCertification: string,
    name: string,
    birthDate: Date,
    credits: number,
    locationPlanet: string,
    age: number
}
```
**GET /pilots/:id**
This endpoint returns a pilot with this schema:

```ts
{
    id: number,
    pilotCertification: string,
    name: string,
    birthDate: Date,
    credits: number,
    locationPlanet: string,
    age: number
}
```
**POST /pilots**
This endpoint creates a pilot by sending the following schema as request body:

```ts
{
    pilotCertification: string,
    name: string,
    birthDate: Date,
    credits: number,
    locationPlanet: string
}
```

### Reports
**GET /reports/weightmovimentation**
This endpoint returns the total weight in tons of each resource sent and received by each planet with this schema:
```ts
{
	received: {
		food: number,
		water: number,
		minerals: number
	},
	sent: {
		food: number,
		water: number,
		minerals: number
	}
}
```

**GET /reports/pilotspercentages**
This endpoint returns the percentage of resource type transported by each pilot with this schema:
```ts
{
    name: string,
    minerals: string,
    food: string,
    water: string
}
```
**GET /reports/transactions**
This endpoint returns the percentage of resource type transported by each pilot with this schema:
```ts
{
    value: number,
    transactionDescription: number
}
```
### Resources
**GET /resources**
This endpoint returns an array of resources with this schema:
```ts
{
    id: number,
    name: number,
    weight: number,
    contract_id: number
}
```

**GET /resources/:id**
This endpoint returns a resource with this schema:
```ts
{
    id: number,
    name: number,
    weight: number,
    contract_id: number
}
```
**POST /resources**
This endpoint creates a contract by sending the following schema as request body:
```ts
{
    name: number,
    weight: number,
    contract_id: number
}
```

### Ships
**GET /ships**
This endpoint returns an array of ships with this schema:
```ts
{
    id: number,
    fuelCapacity: number,
    fuelLevel: number,
    weightCapacity: number,
    pilot: Pilot
}
```

**GET /ships/:id**
This endpoint returns a ships with this schema:
```ts
{
    id: number,
    fuelCapacity: number,
    fuelLevel: number,
    weightCapacity: number,
    pilot: Pilot
}
```

**POST /ships**
This endpoint creates a ship by sending the following schema as request body:
```ts
{
    fuelCapacity: number,
    fuelLevel: number,
    weightCapacity: number,
    pilot: Pilot
}
```
**PUT /ships/refuel/:id**
This endpoint refuels a ship by sending the following schema as request body:
```ts
{
	value: number
}
```

### Travel
**PUT /travel/from/:idFrom/to/:idTo/withpilot/:idPilot**
This endpoint does a free travel by passing the origin planet id, th destination planet id and the pilot id, then, if everything goes well, a success message is returned with the following schema :
```ts
{

message: string

}
```

# Running the application

### In order to run the application you will need the following tools:
[Java JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) or newer  

[SpringToolSuite IDE 4 Eclipse version](https://spring.io/tools) (you may be able to run the solution using another IDE such as Eclipse, IntelliJ IDEA or Visual Studio Code, but it's strongly recommended that you use STSTool4)  

[Postman API Client](https://www.postman.com/product/api-client/) (not required, just good for testing)  

[MySql](https://dev.mysql.com/downloads/installer/) (version 10.4.22-MariaDB is recommended, because is the one that I used)  

**Tip:** make mysql installation easier and quicker by using [Xampp](https://www.apachefriends.org/pt_br/index.html)  


### Starting the aplication:
Assuming that you installed all needed softwares, we can now proceed to executing the application:

#### 1. Clone the project from github using "git clone"
#### 2. Start your MySql instance
#### 3. Start Spring Tool Suite and import the project using the following path: *File -> Import -> Maven -> Existing Maven Projects*
![Spring Tool Suite - import project](https://i.imgur.com/sW64Gev.png)
#### 3.  Open the file */fleets-manager-api/src/main/resources/application.properties* and setup your MysSql connection credentials
![Spring Tool Suite - configuring db credentials](https://i.imgur.com/qFEfaY6.png)
#### 4.  Now all you need to do is run the application by doing the following: 
![Spring Tool Suite - starting app](https://i.imgur.com/hXovJpr.png)

#### And *voilà*! Now the application should be up and running. Now you can start to use the endpoints

## Using the application's functionalities
1. You can ddd pilots and their ships to the system by using these endpoints: **POST /pilots; POST /ships**
2. Publish transport contracts by using this endpoint: **POST /contracts**
3. Freely travel between planets by using this endpoint: **PUT /travel/from/:idFrom/to/:idTo/withpilot/:idPilot**
4. List open contracts by using this endpoint: **GET /contracts/open**
5. Accept transport contracts by using this endpoint: **PUT /contracts/accept/:id**, then you can execute it using the endpoin **PUT /contracts/execute/:id** and the system will make the travel right away and grant credits to the pilot.
6. Register a refill of the fuel using the endpoint: **PUT /ships/refuel/:id**.
7. Generate reports using the endpoints: **GET /reports/weightmovimentation**, **GET /reports/pilotspercentages** and **GET /reports/transactions**


## Notes
1. Every time that the application is started the database is recreated, you can change it at */fleets-manager-api/src/main/resources/application.properties*.
2. The file  */fleets-manager-api/src/main/resources/import.sql* is loaded every time that the system is started and placeholder data is inserted in the database, if it doesn't load automatically for you, you can run it manually.


**That's all, folks😁!**
