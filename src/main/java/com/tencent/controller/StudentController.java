package com.tencent.controller;

import com.tencent.entity.Student;
import com.tencent.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/list")
    public String queryAll(Model model){
        List<Student> studentList = studentService.queryAll();
        model.addAttribute("studentList",studentList);
        return "stulist";
    }


}
