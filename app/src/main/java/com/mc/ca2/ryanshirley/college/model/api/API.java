package com.mc.ca2.ryanshirley.college.model.api;

import com.mc.ca2.ryanshirley.college.model.Enrolment;

public interface API {
    void login(String email, String password, APIListener listener);

    void loadEnrolments(APIListener listener);
    void storeEnrolment(Enrolment enrolment, APIListener listener);
    void updateEnrolment(Enrolment enrolment, APIListener listener);
    void deleteEnrolment(Enrolment enrolment, APIListener listener);

    void loadCourses(APIListener listener);
    void loadStudents(APIListener listener);

}
