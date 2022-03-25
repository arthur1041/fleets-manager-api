
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