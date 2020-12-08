/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Aircraft;
import org.openapitools.model.AircraftSchedule;
import org.openapitools.model.Flight;
import io.swagger.annotations.*;
import server.database.AdminMenu;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

@Validated
@Api(value = "aircraft", description = "the aircraft API")
public interface AircraftApi {

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	/**
	 * POST /aircraft : adds a new aircraft
	 *
	 * @param aircraft The new aircraft to add. (optional)
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or success response (status code 200)
	 */
	@ApiOperation(value = "adds a new aircraft", nickname = "addAircraft", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 200, message = "success response", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/aircraft", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<List<Object>> addAircraft(
			@ApiParam(value = "The new aircraft to add.") @Valid @RequestBody(required = false) Aircraft aircraft) {
    	try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
    				"something_fun");
        	AdminMenu am = new AdminMenu(con);
        	am.AddAircraft(aircraft, 8);
        	}catch(Exception e) {
        		System.out.println(e);
        	}
    	
    	return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /aircraft/flight/ : adds a new flight
	 *
	 * @param flight The new flight to add. As flight needs a referenced aircraft,
	 *               this should be fine. (optional)
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or Aircraft not found (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "adds a new flight", nickname = "addFlight", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Aircraft not found"),
			@ApiResponse(code = 200, message = "success response", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/aircraft/flight/", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<List<Object>> addFlight(
			@ApiParam(value = "The new flight to add. As flight needs a referenced aircraft, this should be fine.") @Valid @RequestBody(required = false) Flight flight) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });
        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
				"something_fun");
        	AdminMenu am = new AdminMenu(con);
        	am.AddFlight(flight, 8);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /aircraft/{aircraft_id}/schedule/ : adds new schedual for an aircraft
	 *
	 * @param aircraftId       The aircraft that needs to be fetched. Use 1 for
	 *                         testing. (required)
	 * @param aircraftSchedule The schedule to add for an aircraft. (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or Success response (status code 200)
	 */
	@ApiOperation(value = "adds new schedual for an aircraft", nickname = "addScheduleForAircraft", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "Success response") })
	@RequestMapping(value = "/aircraft/{aircraft_id}/schedule/", consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addScheduleForAircraft(
			@ApiParam(value = "The aircraft  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("aircraft_id") Long aircraftId,
			@ApiParam(value = "The schedule to add for an aircraft.", required = true) @Valid @RequestBody AircraftSchedule aircraftSchedule) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * DELETE /aircraft/{aircraft_id} : delete an aircraft, based on its id.
	 *
	 * @param aircraftId the id of the aircraft. (required)
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or Aircraft not found (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "delete an aircraft, based on its id.", nickname = "deleteAircraft", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Aircraft not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/aircraft/{aircraft_id}", method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteAircraft(
			@ApiParam(value = "the id of the aircraft.", required = true) @PathVariable("aircraft_id") Long aircraftId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * DELETE /aircraft/flight/{flight_id} : delete a flight by its id.
	 *
	 * @param flightId the id of the aircraft. (required)
	 * @return Invalid flight or aircraft (status code 400) or Permission Denied
	 *         (status code 401) or Flight or aircraft not found (status code 404)
	 *         or success response (status code 200)
	 */
	@ApiOperation(value = "delete a flight by its id.", nickname = "deleteFlight", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid flight or aircraft"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Flight or aircraft not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/aircraft/flight/{flight_id}", method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteFlight(
			@ApiParam(value = "the id of the aircraft.", required = true) @PathVariable("flight_id") Long flightId) {
    	try {
    	Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
				"something_fun");
    	AdminMenu am = new AdminMenu(con);
    	am.RemoveFlight(flightId.intValue(), 100, 8);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);


	}

	/**
	 * DELETE /aircraft/{aircraft_id}/schedule/{flight_id} : removes an instructor
	 * for a student.
	 *
	 * @param aircraftId The aircraft that needs to be fetched. Use 1 for testing.
	 *                   (required)
	 * @param flightId   the flight id to fetch, from the schedual (required)
	 * @return Invalid Aircraft, Flight, or Schedule (status code 400) or Permission
	 *         Denied (status code 401) or Aircraft, Schedule, or Flight not found
	 *         (status code 404) or success response (status code 200)
	 */
	@ApiOperation(value = "removes an instructor for a student.", nickname = "deleteFlightFromSchedule", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Aircraft, Flight, or Schedule"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Aircraft, Schedule, or Flight not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/aircraft/{aircraft_id}/schedule/{flight_id}", method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteFlightFromSchedule(
			@ApiParam(value = "The aircraft  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("aircraft_id") Long aircraftId,
			@ApiParam(value = "the flight id to fetch, from the schedual", required = true) @PathVariable("flight_id") Long flightId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /aircraft/{aircraft_id} : fetch an aircraft by its id.
	 *
	 * @param aircraftId the id of the aircraft. (required)
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or Aircraft not found (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "fetch an aircraft by its id.", nickname = "getAircraftByID", notes = "", response = Object.class, authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Aircraft not found"),
			@ApiResponse(code = 200, message = "success response", response = Object.class) })
	@RequestMapping(value = "/aircraft/{aircraft_id}", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<Object> getAircraftByID(
			@ApiParam(value = "the id of the aircraft.", required = true) @PathVariable("aircraft_id") Long aircraftId) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
					String exampleString = "";
					ApiUtil.setExampleResponse(request, "", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /aircraft : retrieves all aircrafts
	 *
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or success response (status code 200)
	 */
	@ApiOperation(value = "retrieves all aircrafts", nickname = "getAllAircraft", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 200, message = "success response", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/aircraft", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Object>> getAllAircraft() {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
					String exampleString = "";
					ApiUtil.setExampleResponse(request, "", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /aircraft/flight/ : retrieves all flights
	 *
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or Aircraft not found (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "retrieves all flights", nickname = "getAllFlights", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Aircraft not found"),
			@ApiResponse(code = 200, message = "success response", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/aircraft/flight/", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Object>> getAllFlights() {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
					String exampleString = "";
					ApiUtil.setExampleResponse(request, "", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /aircraft/flight/{flight_id} : fetch an flight by its id.
	 *
	 * @param flightId the id of the aircraft. (required)
	 * @return Invalid flight or aircraft (status code 400) or Permission Denied
	 *         (status code 401) or Flight or aircraft not found (status code 404)
	 *         or success response (status code 200)
	 */
	@ApiOperation(value = "fetch an flight by its id.", nickname = "getFlightByID", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid flight or aircraft"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Flight or aircraft not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/aircraft/flight/{flight_id}", method = RequestMethod.GET)
	default ResponseEntity<Void> getFlightByID(
			@ApiParam(value = "the id of the aircraft.", required = true) @PathVariable("flight_id") Long flightId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /aircraft/{aircraft_id}/schedule/ : fetches schedual for an aircraft
	 *
	 * @param aircraftId The aircraft that needs to be fetched. Use 1 for testing.
	 *                   (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or Success response (status code 200)
	 */
	@ApiOperation(value = "fetches schedual for an aircraft", nickname = "getScheduleForAircraft", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "Success response", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/aircraft/{aircraft_id}/schedule/", produces = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Object>> getScheduleForAircraft(
			@ApiParam(value = "The aircraft  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("aircraft_id") Long aircraftId) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
					String exampleString = "";
					ApiUtil.setExampleResponse(request, "", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /aircraft/{aircraft_id} : fetch an aircraft by its id.
	 *
	 * @param aircraftId the id of the aircraft. (required)
	 * @param aircraft   the updated aircraft (required)
	 * @return Invalid aircraft response (status code 400) or Permission Denied
	 *         (status code 401) or Aircraft not found (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "fetch an aircraft by its id.", nickname = "updateAircraft", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid aircraft response"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Aircraft not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/aircraft/{aircraft_id}", consumes = { "application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateAircraft(
			@ApiParam(value = "the id of the aircraft.", required = true) @PathVariable("aircraft_id") Long aircraftId,
			@ApiParam(value = "the updated aircraft", required = true) @Valid @RequestBody Aircraft aircraft) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /aircraft/flight/{flight_id} : update a flight
	 *
	 * @param flightId the id of the aircraft. (required)
	 * @param flight   The updated flight, replaces at the id passed (required)
	 * @return Invalid flight or aircraft (status code 400) or Permission Denied
	 *         (status code 401) or Flight or aircraft not found (status code 404)
	 *         or success response (status code 200)
	 */
	@ApiOperation(value = "update a flight", nickname = "updateFlight", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid flight or aircraft"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Flight or aircraft not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/aircraft/flight/{flight_id}", consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateFlight(
			@ApiParam(value = "the id of the aircraft.", required = true) @PathVariable("flight_id") Long flightId,
			@ApiParam(value = "The updated flight, replaces at the id passed", required = true) @Valid @RequestBody Flight flight) {
        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
				"something_fun");
        	AdminMenu am = new AdminMenu(con);
        	am.EditFlight(flight, 8);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        
	}

}
