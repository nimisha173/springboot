package com.example.StudentSubjectDto.controller;

import com.example.StudentSubjectDto.ExceptionHandling.StudentNotFoundException;
import com.example.StudentSubjectDto.dto.Studentdto;
import com.example.StudentSubjectDto.entity.Student;
import com.example.StudentSubjectDto.entity.Subject;
import com.example.StudentSubjectDto.repository.Studentrepo;
import com.example.StudentSubjectDto.repository.Subjectrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/studentsubject")
public class Controller {
    @Autowired
    private Studentrepo stdrepo;
    @Autowired
    private Subjectrepo subrepo;

   @PostMapping("/poststudent")
   public ResponseEntity<Student>poststudent(@RequestBody Studentdto stdto){
       Student student=new Student(0, stdto.getName(),stdto.getDept(), stdto.getAge());
       stdrepo.save(student);
       return ResponseEntity.ok().body(student);
   }

    @PostMapping("/postsubject")
    public ResponseEntity<Subject>postsubject(@RequestBody Subject subject){
        subrepo.save(subject);
       return ResponseEntity.ok().body(subject);
    }


    @GetMapping("getstudent/{rollno}")
    public ResponseEntity<Student>getstudent(@PathVariable Integer rollno)throws StudentNotFoundException{
       Optional<Student>op1=stdrepo.findById(rollno);
       if(op1.isPresent()){
           return ResponseEntity.ok().body(op1.get());
       }else{
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//           Optional<Student>op6=stdrepo.findById(rollno);
//           if(op6.isPresent()){
//               return ResponseEntity.ok().body(op6.get());
//           }
//           else{
               throw new StudentNotFoundException("student not found");
           //}
       }
    }

      @GetMapping("getsub/{id}")
      public ResponseEntity<Subject>getsub(@PathVariable Integer id)throws StudentNotFoundException{
       Optional<Subject>op2=subrepo.findById(id);
       if(op2.isPresent()){
           return ResponseEntity.ok().body(op2.get());
       }else{
           //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           Optional<Subject>op7=subrepo.findById(id);
           if(op7.isPresent()){
               return ResponseEntity.ok().body(op7.get());
           }else{
               throw new StudentNotFoundException("subject not found");
               }
           }
       }



       @PutMapping("updatestudent/{rollno}")
       public ResponseEntity<Student>updatestudent(@RequestBody Studentdto studentdto,@PathVariable Integer rollno){
       Optional<Student>op3=stdrepo.findById(rollno);
       if(op3.isPresent()){
           Student student;
           student=op3.get();
           student.setRollno(rollno);
           student.setName(studentdto.getName());
           student.setDept(studentdto.getDept());
           student.setAge(studentdto.getAge());
           stdrepo.save(student);
           return ResponseEntity.ok().body(student);

       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }

       }

       @PutMapping("updatesub/{id}")
       public ResponseEntity<Subject>updatesub(@RequestBody Subject subject){
       Optional<Subject>op4=subrepo.findById(subject.getId());
       if(op4.isPresent()){
           Subject subject1;
           subject1=op4.get();
           subject1.setId(subject.getId());
           subject1.setName(subject.getName());
           subrepo.save(subject1);
           return ResponseEntity.ok().body(subject1);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }

       }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deletestudet (@PathVariable Integer id){
            Optional<Student> op5 = stdrepo.findById(id);
            if (op5.isPresent()) {
                stdrepo.delete(op5.get());
                return ResponseEntity.ok().body("deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }

    }

