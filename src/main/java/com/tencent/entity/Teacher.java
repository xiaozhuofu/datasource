package com.tencent.entity;

import java.util.Objects;

public class Teacher {

    private Integer id;
    private String tname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id.equals(teacher.id) &&
                tname.equals(teacher.tname);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(id, tname);
    }
}
