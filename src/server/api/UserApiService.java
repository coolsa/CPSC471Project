package server.api;

import server.api.*;
import server.model.*;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public interface UserApiService {
      Response addAdmin(Object body,SecurityContext securityContext)
      throws NotFoundException;
      Response addInstructor(Object body,SecurityContext securityContext)
      throws NotFoundException;
      Response addMXEngineer(Object body,SecurityContext securityContext)
      throws NotFoundException;
      Response addStudent(Object body,SecurityContext securityContext)
      throws NotFoundException;
      Response addTeacherForStudent(Long userId,Instructor instructor,SecurityContext securityContext)
      throws NotFoundException;
      Response addTeachingForInstructor(Long userId,Student student,SecurityContext securityContext)
      throws NotFoundException;
      Response addUser(Object body,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteStudentFromTeacher(Long userId,Long studentId,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteTeacherForStudent(Long userId,Long instructorId,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteUser(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getAdminByID(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getInstructorByID(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getMXEngineerByID(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getStudentByID(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getTeachersFromStudent(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getTeachingFromInstructor(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response getUserByID(Long userId,SecurityContext securityContext)
      throws NotFoundException;
      Response loginUser(String email,String password,SecurityContext securityContext)
      throws NotFoundException;
      Response logoutUser(SecurityContext securityContext)
      throws NotFoundException;
      Response updateAdmin(Long userId,Admin admin,SecurityContext securityContext)
      throws NotFoundException;
      Response updateInstructor(Long userId,Instructor instructor,SecurityContext securityContext)
      throws NotFoundException;
      Response updateMXEngineer(Long userId,MXEngineer mxEngineer,SecurityContext securityContext)
      throws NotFoundException;
      Response updateStudent(Long userId,Student student,SecurityContext securityContext)
      throws NotFoundException;
      Response updateUser(Long userId,User user,SecurityContext securityContext)
      throws NotFoundException;
}
