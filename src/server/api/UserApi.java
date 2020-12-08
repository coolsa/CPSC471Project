package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.UserApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Admin;
import org.openapitools.model.Instructor;
import org.openapitools.model.MXEngineer;
import org.openapitools.model.Student;
import org.openapitools.model.User;

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

@Path("/user")


@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class UserApi  {

    @Inject UserApiService service;

    @POST
    @Path("/admin")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a new user to the system", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response addAdmin(@ApiParam(value = "User admin that needs to be added" ) @Valid Object body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addAdmin(body,securityContext);
    }
    @POST
    @Path("/instructor")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a new instructor to the system", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response addInstructor(@ApiParam(value = "User instructor that needs to be added" ) @Valid Object body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addInstructor(body,securityContext);
    }
    @POST
    @Path("/mx_engineer")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a new user to the system", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response addMXEngineer(@ApiParam(value = "User object that needs to be added" ,required=true) @NotNull @Valid Object body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addMXEngineer(body,securityContext);
    }
    @POST
    @Path("/student")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a new user to the system", notes = "", response = Void.class, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response addStudent(@ApiParam(value = "User student that needs to be added" ) @Valid Object body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addStudent(body,securityContext);
    }
    @POST
    @Path("/student/{user_id}/teachers")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "adds new instructor for a student.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response addTeacherForStudent( @PathParam("user_id") Long userId,@ApiParam(value = "The Instructor to teach the student" ,required=true) @NotNull @Valid Instructor instructor,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addTeacherForStudent(userId,instructor,securityContext);
    }
    @POST
    @Path("/instructor/{user_id}/teaching")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "adds new students that an instructor is teaching.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Success response", response = Void.class) })
    public Response addTeachingForInstructor( @PathParam("user_id") Long userId,@ApiParam(value = "The Student to add for the instructor." ,required=true) @NotNull @Valid Student student,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addTeachingForInstructor(userId,student,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a new user to the system", notes = "", response = Void.class, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response addUser(@ApiParam(value = "User object that needs to be added" ) @Valid Object body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.addUser(body,securityContext);
    }
    @DELETE
    @Path("/instructor/{user_id}/teaching/{student_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes an instructor for a student.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response deleteStudentFromTeacher( @PathParam("user_id") Long userId, @PathParam("student_id") Long studentId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteStudentFromTeacher(userId,studentId,securityContext);
    }
    @DELETE
    @Path("/student/{user_id}/teachers/{instructor_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes an instructor for a student.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response deleteTeacherForStudent( @PathParam("user_id") Long userId, @PathParam("instructor_id") Long instructorId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteTeacherForStudent(userId,instructorId,securityContext);
    }
    @DELETE
    @Path("/{user_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user. It also deletes associated admins, instructors, students, and MX-Engineers, and teacher/teaching relations.", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user id supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "User successfully deleted", response = Void.class) })
    public Response deleteUser( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteUser(userId,securityContext);
    }
    @GET
    @Path("/admin/{user_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "fetches information about an admin, from their id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "admin not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid admin supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Default response", response = Void.class) })
    public Response getAdminByID( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getAdminByID(userId,securityContext);
    }
    @GET
    @Path("/instructor/{user_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "fetches information about an instructor, from their id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "instructor not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "invalid instructor response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response getInstructorByID( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getInstructorByID(userId,securityContext);
    }
    @GET
    @Path("/mx_engineer/{user_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "fetches information about MX Engineer, from their id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "MX_Engineer not found.", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "invalid MX_Engineer", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response getMXEngineerByID( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getMXEngineerByID(userId,securityContext);
    }
    @GET
    @Path("/student/{user_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "fetches information about student, from their id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid student.", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response getStudentByID( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getStudentByID(userId,securityContext);
    }
    @GET
    @Path("/student/{user_id}/teachers")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "fetches instructors that a student is learning from.", notes = "", response = Object.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class, responseContainer = "List") })
    public Response getTeachersFromStudent( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getTeachersFromStudent(userId,securityContext);
    }
    @GET
    @Path("/instructor/{user_id}/teaching")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "fetches students that an instructor is teaching.", notes = "", response = Object.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Instructor or Student", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Instructor or Student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Success response", response = Object.class, responseContainer = "List") })
    public Response getTeachingFromInstructor( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getTeachingFromInstructor(userId,securityContext);
    }
    @GET
    @Path("/{user_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get user by user id", notes = "", response = User.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user id supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = User.class) })
    public Response getUserByID( @PathParam("user_id") Long userId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getUserByID(userId,securityContext);
    }
    @GET
    @Path("/login")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Logs user into the system", notes = "", response = String.class, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username/password supplied", response = Void.class) })
    public Response loginUser( @NotNull  @QueryParam("email") String email, @NotNull  @QueryParam("password") String password,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.loginUser(email,password,securityContext);
    }
    @GET
    @Path("/logout")
    
    
    @io.swagger.annotations.ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response logoutUser(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.logoutUser(securityContext);
    }
    @PUT
    @Path("/admin/{user_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "updates information about an admin, from their id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "admin not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid admin supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Default response", response = Void.class) })
    public Response updateAdmin( @PathParam("user_id") Long userId,@ApiParam(value = "Updated user object" ) @Valid Admin admin,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateAdmin(userId,admin,securityContext);
    }
    @PUT
    @Path("/instructor/{user_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "updates information about an instructor", notes = "uses the instructor id, and a new attribute for the instructor, to update the instructor in question.", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "instructor not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "invalid instructor response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response updateInstructor( @PathParam("user_id") Long userId,@ApiParam(value = "The updated instructor attributes." ,required=true) @NotNull @Valid Instructor instructor,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateInstructor(userId,instructor,securityContext);
    }
    @PUT
    @Path("/mx_engineer/{user_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "updates information about MX Engineer, from their id.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "MX_Engineer not found.", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "invalid MX_Engineer", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response updateMXEngineer( @PathParam("user_id") Long userId,@ApiParam(value = "The updated mx_Engineer" ,required=true) @NotNull @Valid MXEngineer mxEngineer,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateMXEngineer(userId,mxEngineer,securityContext);
    }
    @PUT
    @Path("/student/{user_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "updates information about student, from their id, with new student.", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid student.", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "student not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "success response", response = Void.class) })
    public Response updateStudent( @PathParam("user_id") Long userId,@ApiParam(value = "The new updated student." ,required=true) @NotNull @Valid Student student,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateStudent(userId,student,securityContext);
    }
    @PUT
    @Path("/{user_id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "airsched_auth")
    }, tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful Update", response = Void.class) })
    public Response updateUser( @PathParam("user_id") Long userId,@ApiParam(value = "Updated user object" ,required=true) @NotNull @Valid User user,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateUser(userId,user,securityContext);
    }
}
