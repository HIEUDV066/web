package com.ducnm.btl1.service;

import com.ducnm.btl1.entities.Student;
import com.ducnm.btl1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getListStudent(){
        return studentRepository.findAll();
    }

    public Student getStudent(String id){
        try {
            return studentRepository.findById(id).get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Student updateStudent(Student student){
        try{
            return studentRepository.save(student);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public Student insertStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id){
        Student student = getStudent(id);
        studentRepository.delete(student);
    }
}
