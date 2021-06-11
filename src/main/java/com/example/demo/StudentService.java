package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private  StudentDAO stdao;
    public List<Student> getStudents() {
        return  List.of(
                new Student(
                        1L,
                        "Tushar Goyal - IIT MANDI",
                        "tushar22.tg.tg@gmail.com",
                        LocalDate.of(2000,12,22),
                        22
                )
        );
    }

    @Autowired
    public StudentService(StudentDAO stdao) {
        this.stdao = stdao;
    }

    @Transactional
    public  Long addStudent(){
//        Student std;
         Student newstd = new Student("Piyush","piyush@gmail.com", LocalDate.now(),22);
         return  stdao.addStudent(newstd);
    }

    @Transactional
    public Long addStudent(Student std) {
        return  stdao.addStudent(std);
    }

    List<Student> liststudents(){
        return  stdao.listallstudents();
    }

    @Transactional
    Long deletestudents(Long id){
        return stdao.deleteStudent(id);
    }

}
