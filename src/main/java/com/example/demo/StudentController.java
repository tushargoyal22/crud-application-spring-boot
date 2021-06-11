package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private StudentService studentService;//member of StudentController

    @Autowired
    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getstudent(){
        return  studentService.getStudents();
    }

    @GetMapping("/addstudent")
    public  Long addstudent() {
        Long ans = studentService.addStudent();
        System.out.println(ans);
        return  ans;
    }

    @GetMapping("/liststudents")
    public  List<Student> liststudent() {
        List<Student> ans = studentService.liststudents();
        return  ans;
    }

    @Transactional
    @RequestMapping(value = "/deletestudents/{id}",method = RequestMethod.GET)
    public  List<Student> deletestudent(@PathVariable Long id) {
        Long success = studentService.deletestudents(id);
        List<Student> ans = studentService.liststudents();
        return  ans;
    }
}
