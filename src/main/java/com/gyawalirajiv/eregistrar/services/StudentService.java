package com.gyawalirajiv.eregistrar.services;

import com.gyawalirajiv.eregistrar.models.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);

    List<Student> findAll();

    Student findOne(Long id);

    void delete(Long id);
}
