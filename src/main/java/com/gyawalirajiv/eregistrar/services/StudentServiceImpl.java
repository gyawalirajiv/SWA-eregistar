package com.gyawalirajiv.eregistrar.services;

import com.gyawalirajiv.eregistrar.models.Student;
import com.gyawalirajiv.eregistrar.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findOne(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
