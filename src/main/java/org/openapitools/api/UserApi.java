/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Admin;
import org.openapitools.model.Instructor;
import org.openapitools.model.MXEngineer;
import org.openapitools.model.Student;
import org.openapitools.model.User;
import io.swagger.annotations.*;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

@Validated
@Api(value = "user", description = "the user API")
public interface UserApi {

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	/**
	 * POST /user/admin : Add a new user to the system
	 *
	 * @param body User admin that needs to be added (optional)
	 * @return Permission Denied (status code 401) or Invalid input (status code
	 *         405) or successful operation (status code 200)
	 */
	@ApiOperation(value = "Add a new user to the system", nickname = "addAdmin", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 405, message = "Invalid input"),
			@ApiResponse(code = 200, message = "successful operation") })
	@RequestMapping(value = "/user/admin", consumes = { "application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addAdmin(
			@ApiParam(value = "User admin that needs to be added") @Valid @RequestBody(required = false) Object body) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /user/instructor : Add a new instructor to the system
	 *
	 * @param body User instructor that needs to be added (optional)
	 * @return Permission Denied (status code 401) or Invalid input (status code
	 *         405) or successful operation (status code 200)
	 */
	@ApiOperation(value = "Add a new instructor to the system", nickname = "addInstructor", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 405, message = "Invalid input"),
			@ApiResponse(code = 200, message = "successful operation") })
	@RequestMapping(value = "/user/instructor", consumes = { "application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addInstructor(
			@ApiParam(value = "User instructor that needs to be added") @Valid @RequestBody(required = false) Instructor body) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /user/mx_engineer : Add a new user to the system
	 *
	 * @param body User object that needs to be added (required)
	 * @return Permission Denied (status code 401) or Invalid input (status code
	 *         405) or successful operation (status code 200)
	 */
	@ApiOperation(value = "Add a new user to the system", nickname = "addMXEngineer", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 405, message = "Invalid input"),
			@ApiResponse(code = 200, message = "successful operation") })
	@RequestMapping(value = "/user/mx_engineer", consumes = { "application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addMXEngineer(
			@ApiParam(value = "User object that needs to be added", required = true) @Valid @RequestBody Object body) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /user/student : Add a new user to the system
	 *
	 * @param body User student that needs to be added (optional)
	 * @return Permission Denied (status code 401) or Invalid input (status code
	 *         405) or successful operation (status code 200)
	 */
	@ApiOperation(value = "Add a new user to the system", nickname = "addStudent", notes = "", tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 405, message = "Invalid input"),
			@ApiResponse(code = 200, message = "successful operation") })
	@RequestMapping(value = "/user/student", consumes = { "application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addStudent(
			@ApiParam(value = "User student that needs to be added") @Valid @RequestBody(required = false) Object body) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /user/student/{user_id}/teachers : adds new instructor for a student.
	 *
	 * @param userId     The user that needs to be fetched. Use 1 for testing.
	 *                   (required)
	 * @param instructor The Instructor to teach the student (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or success response (status code 200)
	 */
	@ApiOperation(value = "adds new instructor for a student.", nickname = "addTeacherForStudent", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/student/{user_id}/teachers", consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addTeacherForStudent(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "The Instructor to teach the student", required = true) @Valid @RequestBody Instructor instructor) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /user/instructor/{user_id}/teaching : adds new students that an
	 * instructor is teaching.
	 *
	 * @param userId  The user that needs to be fetched. Use 1 for testing.
	 *                (required)
	 * @param student The Student to add for the instructor. (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or Success response (status code 200)
	 */
	@ApiOperation(value = "adds new students that an instructor is teaching.", nickname = "addTeachingForInstructor", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "Success response") })
	@RequestMapping(value = "/user/instructor/{user_id}/teaching", consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Void> addTeachingForInstructor(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "The Student to add for the instructor.", required = true) @Valid @RequestBody Student student) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * POST /user : Add a new user to the system
	 *
	 * @param body User object that needs to be added (optional)
	 * @return Permission Denied (status code 401) or Invalid input (status code
	 *         405) or successful operation (status code 200)
	 */
	@ApiOperation(value = "Add a new user to the system", nickname = "addUser", notes = "", response = Object.class, responseContainer = "List", tags = {
			"user", })
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 405, message = "Invalid input"),
			@ApiResponse(code = 200, message = "successful operation", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/user", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<List<Object>> addUser(
			@ApiParam(value = "User object that needs to be added") @Valid @RequestBody(required = false) Object body) {
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
	 * DELETE /user/instructor/{user_id}/teaching/{student_id} : removes an
	 * instructor for a student.
	 *
	 * @param userId    The user that needs to be fetched. Use 1 for testing.
	 *                  (required)
	 * @param studentId (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or success response (status code 200)
	 */
	@ApiOperation(value = "removes an instructor for a student.", nickname = "deleteStudentFromTeacher", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/instructor/{user_id}/teaching/{student_id}", method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteStudentFromTeacher(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "", required = true) @PathVariable("student_id") Long studentId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * DELETE /user/student/{user_id}/teachers/{instructor_id} : removes an
	 * instructor for a student.
	 *
	 * @param userId       The user that needs to be fetched. Use 1 for testing.
	 *                     (required)
	 * @param instructorId (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or success response (status code 200)
	 */
	@ApiOperation(value = "removes an instructor for a student.", nickname = "deleteTeacherForStudent", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/student/{user_id}/teachers/{instructor_id}", method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteTeacherForStudent(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "", required = true) @PathVariable("instructor_id") Long instructorId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * DELETE /user/{user_id} : Delete user This can only be done by the logged in
	 * user. It also deletes associated admins, instructors, students, and
	 * MX-Engineers, and teacher/teaching relations.
	 *
	 * @param userId The name that needs to be deleted (required)
	 * @return Invalid user id supplied (status code 400) or Permission Denied
	 *         (status code 401) or User not found (status code 404) or User
	 *         successfully deleted (status code 200)
	 */
	@ApiOperation(value = "Delete user", nickname = "deleteUser", notes = "This can only be done by the logged in user. It also deletes associated admins, instructors, students, and MX-Engineers, and teacher/teaching relations.", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid user id supplied"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 200, message = "User successfully deleted") })
	@RequestMapping(value = "/user/{user_id}", method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteUser(
			@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("user_id") Long userId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user/admin/{user_id} : fetches information about an admin, from their
	 * id.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return admin not found (status code 400) or Permission Denied (status code
	 *         401) or Invalid admin supplied (status code 404) or Default response
	 *         (status code 200)
	 */
	@ApiOperation(value = "fetches information about an admin, from their id.", nickname = "getAdminByID", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "admin not found"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Invalid admin supplied"),
			@ApiResponse(code = 200, message = "Default response") })
	@RequestMapping(value = "/user/admin/{user_id}", method = RequestMethod.GET)
	default ResponseEntity<Void> getAdminByID(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user : Add a new user to the system
	 *
	 * @return Permission Denied (status code 401) or Invalid input (status code
	 *         405) or successful operation (status code 200)
	 */
	@ApiOperation(value = "Add a new user to the system", nickname = "getAllUsers", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 405, message = "Invalid input"),
			@ApiResponse(code = 200, message = "successful operation", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/user", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Object>> getAllUsers() {
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
	 * GET /user/instructor/{user_id} : fetches information about an instructor,
	 * from their id.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return instructor not found (status code 400) or invalid instructor response
	 *         (status code 404) or success response (status code 200)
	 */
	@ApiOperation(value = "fetches information about an instructor, from their id.", nickname = "getInstructorByID", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "instructor not found"),
			@ApiResponse(code = 404, message = "invalid instructor response"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/instructor/{user_id}", method = RequestMethod.GET)
	default ResponseEntity<Void> getInstructorByID(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user/mx_engineer/{user_id} : fetches information about MX Engineer, from
	 * their id.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return MX_Engineer not found. (status code 400) or Permission Denied (status
	 *         code 401) or invalid MX_Engineer (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "fetches information about MX Engineer, from their id.", nickname = "getMXEngineerByID", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "MX_Engineer not found."),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "invalid MX_Engineer"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/mx_engineer/{user_id}", method = RequestMethod.GET)
	default ResponseEntity<Void> getMXEngineerByID(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user/student/{user_id} : fetches information about student, from their
	 * id.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return invalid student. (status code 400) or student not found (status code
	 *         404) or success response (status code 200)
	 */
	@ApiOperation(value = "fetches information about student, from their id.", nickname = "getStudentByID", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "invalid student."),
			@ApiResponse(code = 404, message = "student not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/student/{user_id}", method = RequestMethod.GET)
	default ResponseEntity<Void> getStudentByID(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user/student/{user_id}/teachers : fetches instructors that a student is
	 * learning from.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return invalid student (status code 400) or Permission Denied (status code
	 *         401) or Student not found (status code 404) or successful operation
	 *         (status code 200)
	 */
	@ApiOperation(value = "fetches instructors that a student is learning from.", nickname = "getTeachersFromStudent", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "invalid student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Student not found"),
			@ApiResponse(code = 200, message = "successful operation", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/user/student/{user_id}/teachers", produces = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Object>> getTeachersFromStudent(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
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
	 * GET /user/instructor/{user_id}/teaching : fetches students that an instructor
	 * is teaching.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return Invalid Instructor or Student (status code 400) or Permission Denied
	 *         (status code 401) or Instructor or Student not found (status code
	 *         404) or Success response (status code 200)
	 */
	@ApiOperation(value = "fetches students that an instructor is teaching.", nickname = "getTeachingFromInstructor", notes = "", response = Object.class, responseContainer = "List", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Instructor or Student"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "Instructor or Student not found"),
			@ApiResponse(code = 200, message = "Success response", response = Object.class, responseContainer = "List") })
	@RequestMapping(value = "/user/instructor/{user_id}/teaching", produces = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Object>> getTeachingFromInstructor(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
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
	 * GET /user/{user_id} : Get user by user id
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @return Invalid user id supplied (status code 400) or Permission Denied
	 *         (status code 401) or User not found (status code 404) or successful
	 *         operation (status code 200)
	 */
	@ApiOperation(value = "Get user by user id", nickname = "getUserByID", notes = "", response = User.class, authorizations = {
			@Authorization(value = "airsched_auth") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid user id supplied"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 200, message = "successful operation", response = User.class) })
	@RequestMapping(value = "/user/{user_id}", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<User> getUserByID(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : 6, \"phone\" : \"phone\", \"id\" : 0, \"email\" : \"email\" }";
					ApiUtil.setExampleResponse(request, "application/json", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user/login : Logs user into the system
	 *
	 * @param email    The email of the user for login (required)
	 * @param password The password for login in clear text (required)
	 * @return successful operation (status code 200) or Invalid username/password
	 *         supplied (status code 400)
	 */
	@ApiOperation(value = "Logs user into the system", nickname = "loginUser", notes = "", response = String.class, tags = {
			"user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = String.class),
			@ApiResponse(code = 400, message = "Invalid username/password supplied") })
	@RequestMapping(value = "/user/login", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<String> loginUser(
			@NotNull @ApiParam(value = "The email of the user for login", required = true) @Valid @RequestParam(value = "email", required = true) String email,
			@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * GET /user/logout : Logs out current logged in user session
	 *
	 * @return Permission Denied (status code 401) or successful operation (status
	 *         code 200)
	 */
	@ApiOperation(value = "Logs out current logged in user session", nickname = "logoutUser", notes = "", tags = {
			"user", })
	@ApiResponses(value = { @ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 200, message = "successful operation") })
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	default ResponseEntity<Void> logoutUser() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /user/admin/{user_id} : updates information about an admin, from their
	 * id.
	 *
	 * @param userId The user that needs to be fetched. Use 1 for testing.
	 *               (required)
	 * @param admin  Updated user object (optional)
	 * @return admin not found (status code 400) or Invalid admin supplied (status
	 *         code 404) or Default response (status code 200)
	 */
	@ApiOperation(value = "updates information about an admin, from their id.", nickname = "updateAdmin", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "admin not found"),
			@ApiResponse(code = 404, message = "Invalid admin supplied"),
			@ApiResponse(code = 200, message = "Default response") })
	@RequestMapping(value = "/user/admin/{user_id}", consumes = { "application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateAdmin(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "Updated user object") @Valid @RequestBody(required = false) Admin admin) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /user/instructor/{user_id} : updates information about an instructor uses
	 * the instructor id, and a new attribute for the instructor, to update the
	 * instructor in question.
	 *
	 * @param userId     The user that needs to be fetched. Use 1 for testing.
	 *                   (required)
	 * @param instructor The updated instructor attributes. (required)
	 * @return instructor not found (status code 400) or invalid instructor response
	 *         (status code 404) or success response (status code 200)
	 */
	@ApiOperation(value = "updates information about an instructor", nickname = "updateInstructor", notes = "uses the instructor id, and a new attribute for the instructor, to update the instructor in question.", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "instructor not found"),
			@ApiResponse(code = 404, message = "invalid instructor response"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/instructor/{user_id}", consumes = { "application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateInstructor(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "The updated instructor attributes.", required = true) @Valid @RequestBody Instructor instructor) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /user/mx_engineer/{user_id} : updates information about MX Engineer, from
	 * their id.
	 *
	 * @param userId     The user that needs to be fetched. Use 1 for testing.
	 *                   (required)
	 * @param mxEngineer The updated mx_Engineer (required)
	 * @return MX_Engineer not found. (status code 400) or Permission Denied (status
	 *         code 401) or invalid MX_Engineer (status code 404) or success
	 *         response (status code 200)
	 */
	@ApiOperation(value = "updates information about MX Engineer, from their id.", nickname = "updateMXEngineer", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "MX_Engineer not found."),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "invalid MX_Engineer"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/mx_engineer/{user_id}", consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateMXEngineer(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "The updated mx_Engineer", required = true) @Valid @RequestBody MXEngineer mxEngineer) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /user/student/{user_id} : updates information about student, from their
	 * id, with new student.
	 *
	 * @param userId  The user that needs to be fetched. Use 1 for testing.
	 *                (required)
	 * @param student The new updated student. (required)
	 * @return invalid student. (status code 400) or student not found (status code
	 *         404) or success response (status code 200)
	 */
	@ApiOperation(value = "updates information about student, from their id, with new student.", nickname = "updateStudent", notes = "", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 400, message = "invalid student."),
			@ApiResponse(code = 404, message = "student not found"),
			@ApiResponse(code = 200, message = "success response") })
	@RequestMapping(value = "/user/student/{user_id}", consumes = { "application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateStudent(
			@ApiParam(value = "The user  that needs to be fetched. Use 1 for testing. ", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "The new updated student.", required = true) @Valid @RequestBody Student student) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * PUT /user/{user_id} : Updated user This can only be done by the logged in
	 * user.
	 *
	 * @param userId user that need to be updated (required)
	 * @param user   Updated user object (required)
	 * @return Invalid user supplied (status code 400) or Permission Denied (status
	 *         code 401) or User not found (status code 404) or Successful Update
	 *         (status code 200)
	 */
	@ApiOperation(value = "Updated user", nickname = "updateUser", notes = "This can only be done by the logged in user.", authorizations = {
			@Authorization(value = "airsched_auth") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid user supplied"),
			@ApiResponse(code = 401, message = "Permission Denied"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 200, message = "Successful Update") })
	@RequestMapping(value = "/user/{user_id}", consumes = { "application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Void> updateUser(
			@ApiParam(value = "user that need to be updated", required = true) @PathVariable("user_id") Long userId,
			@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User user) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

}
