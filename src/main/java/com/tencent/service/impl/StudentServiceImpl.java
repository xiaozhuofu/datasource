package com.tencent.service.impl;

import com.tencent.dao.StudentMapper;
import com.tencent.entity.Student;
import com.tencent.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAll() {
        return studentMapper.queryAll();
    }
}
