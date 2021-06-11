package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository

public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public Long addStudent(Student std){
        Long std_id = null;
//        Student newstd = new Student("Piyush","piyush@gmail.com", LocalDate.now(),22);
        em.persist(std);
        std_id =  std.getId();
        return  std_id;
    }

    public Long deleteStudent(Long id){
        Student st = em.find(Student.class,id);
        em.remove(st);
        return  1L;
    }

    public List<Student> listallstudents()
    {
        Query q = em.createQuery("SELECT s FROM Student s");
        List<Student> ls = q.getResultList();
        return  ls;
        // Query q = entityManager.createNativeQuery("SELECT * FROM MY_TABLE");
    }
}
