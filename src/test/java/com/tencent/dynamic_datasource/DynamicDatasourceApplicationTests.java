package com.tencent.dynamic_datasource;

import com.tencent.entity.Student;
import com.tencent.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicDatasourceApplicationTests {

    @Test
    void contextLoads() {

        Teacher teacher1 = new Teacher();
        teacher1.setId(1);
        teacher1.setTname("xiaofu");
        System.out.println(teacher1.hashCode());
        Teacher teacher2 = new Teacher();

        teacher2.setId(1);
        teacher2.setTname("xiaofu");
        System.out.println(teacher2.hashCode());
       /* System.err.println(teacher1.equals(teacher2));*/
    }

}
