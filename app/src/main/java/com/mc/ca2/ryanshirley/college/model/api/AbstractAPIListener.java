package com.mc.ca2.ryanshirley.college.model.api;

import com.mc.ca2.ryanshirley.college.model.Course;
import com.mc.ca2.ryanshirley.college.model.Enrolment;
import com.mc.ca2.ryanshirley.college.model.Student;
import com.mc.ca2.ryanshirley.college.model.User;

import java.util.List;

public abstract class AbstractAPIListener implements APIListener {
    @Override
    public void onLogin(User user) { }

    @Override
    public void onEnrolmentsLoaded(List<Enrolment> enrolments) { }

    @Override
    public void onCoursesLoaded(List<Course> courses) { }

    @Override
    public void onStudentsLoaded(List<Student> students) { }

    @Override
    public void onEnrolmentStored(Enrolment storedEnrolment) { }

    @Override
    public void onEnrolmentUpdated(Enrolment updatedEnrolment) { }

    @Override
    public void onEnrolmentDeleted(Enrolment deletedEnrolment) { }
}
