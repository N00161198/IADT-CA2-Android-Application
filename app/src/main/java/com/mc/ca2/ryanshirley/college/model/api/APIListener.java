package com.mc.ca2.ryanshirley.college.model.api;

import com.mc.ca2.ryanshirley.college.model.Course;
import com.mc.ca2.ryanshirley.college.model.Enrolment;
import com.mc.ca2.ryanshirley.college.model.Student;
import com.mc.ca2.ryanshirley.college.model.User;

import java.util.List;

public interface APIListener {
    void onLogin(User user);

    void onEnrolmentsLoaded(List<Enrolment> enrolments);
    void onEnrolmentStored(Enrolment storedEnrolment);
    void onEnrolmentUpdated(Enrolment updatedEnrolment);
    void onEnrolmentDeleted(Enrolment deletedEnrolment);

    void onCoursesLoaded(List<Course> courses);
    void onStudentsLoaded(List<Student> students);
}
