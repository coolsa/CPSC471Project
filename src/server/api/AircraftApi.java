package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.AircraftApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Aircraft;
import org.openapitools.model.AircraftSchedule;
import org.openapitools.model.Flight;

import java.util.Map;
import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.inject.Inject;

import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/aircraft")


@io.swagger.annotations.Api(description = "the aircraft API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class AircraftApi  {

    @Inject AircraftApiService service;

    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "adds a new aircraft", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid aircraft response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response addAircraft(@ApiParam(value = "The new aircraft to add." ) @Valid Aircraft aircraft,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addAircraft(aircraft,securityContext);
    }
    @POST
    @Path("/flight/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a new flight", notes = "", response = Object.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid aircraft response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Object.class) })
    public Response addFlight(@ApiParam(value = "The new flight to add. As flight needs a referenced aircraft, this should be fine." ) @Valid Flight flight,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addFlight(flight,securityContext);
    }
    @POST
    @Path("/{aircraft_id}/schedule/")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "adds new schedual for an aircraft", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Success response", response = Void.class) })
    public Response addScheduleForAircraft( @PathParam("aircraft_id") Long aircraftId,@ApiParam(value = "The schedule to add for an aircraft." ,required=true) @NotNull @Valid AircraftSchedule aircraftSchedule,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addScheduleForAircraft(aircraftId,aircraftSchedule,securityContext);
    }
    @DELETE
    @Path("/{aircraft_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "delete an aircraft, based on its id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid aircraft response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response deleteAircraft( @PathParam("aircraft_id") Long aircraftId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteAircraft(aircraftId,securityContext);
    }
    @DELETE
    @Path("/flight/{flight_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "delete a flight by its id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid flight or aircraft", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Flight or aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response deleteFlight( @PathParam("flight_id") Long flightId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteFlight(flightId,securityContext);
    }
    @DELETE
    @Path("/{aircraft_id}/schedule/{flight_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes an instructor for a student.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Aircraft, Flight, or Schedule", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Aircraft, Schedule, or Flight not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response deleteFlightFromSchedule( @PathParam("aircraft_id") Long aircraftId, @PathParam("flight_id") Long flightId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteFlightFromSchedule(aircraftId,flightId,securityContext);
    }
    @GET
    @Path("/{aircraft_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "fetch an aircraft by its id.", notes = "", response = Object.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid aircraft response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Object.class) })
    public Response getAircraftByID( @PathParam("aircraft_id") Long aircraftId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getAircraftByID(aircraftId,securityContext);
    }
    @GET
    @Path("/flight/{flight_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "fetch an flight by its id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid flight or aircraft", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Flight or aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response getFlightByID( @PathParam("flight_id") Long flightId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getFlightByID(flightId,securityContext);
    }
    @GET
    @Path("/{aircraft_id}/schedule/")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "fetches schedual for an aircraft", notes = "", response = Object.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Success response", response = Object.class, responseContainer = "List") })
    public Response getScheduleForAircraft( @PathParam("aircraft_id") Long aircraftId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getScheduleForAircraft(aircraftId,securityContext);
    }
    @PUT
    @Path("/{aircraft_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "fetch an aircraft by its id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid aircraft response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response updateAircraft( @PathParam("aircraft_id") Long aircraftId,@ApiParam(value = "the updated aircraft" ,required=true) @NotNull @Valid Aircraft aircraft,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateAircraft(aircraftId,aircraft,securityContext);
    }
    @PUT
    @Path("/flight/{flight_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "update a flight", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid flight or aircraft", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Flight or aircraft not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response updateFlight( @PathParam("flight_id") Long flightId,@ApiParam(value = "The updated flight, replaces at the id passed" ,required=true) @NotNull @Valid Flight flight,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateFlight(flightId,flight,securityContext);
    }
}
