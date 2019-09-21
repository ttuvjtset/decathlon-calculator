
# Assignment Decathlon Calculator

### REST API:
`http://localhost:8080/calculatePointsAPI`

Request:

 - POST
 - Sample JSON request:

   
   `   { "event": 1,
        "rawPerformance": 11    }`
    
Example OK Response:

 - `{   "points": 861 }`

Example Error Response:
`{
  "errors": [
    {
      "code": "Min.eventAndRawPerformance.rawPerformance",
      "arguments": [
        "0"
      ],
      "message": "Raw score must be a positive number"
    }
  ]
}`
   
------------
### WEB UI

`http://localhost:8080/` - home page

`http://localhost:8080/calculate` - page with conversion result

 - GET Request
   
   
 - Sample Request:  `?event=1&rawPerformance=15`
