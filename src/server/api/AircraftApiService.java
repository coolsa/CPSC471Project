package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;


import org.openapitools.model.Aircraft;
import org.openapitools.model.AircraftSchedule;
import org.openapitools.model.Flight;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public interface AircraftApiService {
      Response addAircraft(Aircraft aircraft,SecurityContext securityContext)
      throws NotFoundException;
      Response addFlight(Flight flight,SecurityContext securityContext)
      throws NotFoundException;
      Response addScheduleForAircraft(Long aircraftId,AircraftSchedule aircraftSchedule,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteAircraft(Long aircraftId,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteFlight(Long flightId,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteFlightFromSchedule(Long aircraftId,Long flightId,SecurityContext securityContext)
      throws NotFoundException;
      Response getAircraftByID(Long aircraftId,SecurityContext securityContext)
      throws NotFoundException;
      Response getFlightByID(Long flightId,SecurityContext securityContext)
      throws NotFoundException;
      Response getScheduleForAircraft(Long aircraftId,SecurityContext securityContext)
      throws NotFoundException;
      Response updateAircraft(Long aircraftId,Aircraft aircraft,SecurityContext securityContext)
      throws NotFoundException;
      Response updateFlight(Long flightId,Flight flight,SecurityContext securityContext)
      throws NotFoundException;
}
