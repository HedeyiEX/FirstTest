package cn.com.sise.pojo;

import java.util.List;



/**
 * 系别类
 */
public class Dept{
    private Integer deptId;//系别ID
    private String deptname;//系名


    //添加无参构造函数
    public Dept(){}

    //添加有参构造函数，构造系的编码和名称信息
    public Dept(Integer deptId) {
        this.deptId = deptId;
    }

    public Dept(Integer deptId, String deptname) {
        this.deptId = deptId;
        this.deptname = deptname;
    }


    //为属性提供setter和getter方法
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dept dept = (Dept) o;
        return deptId.equals(dept.deptId) &&
                deptname.equals(dept.deptname);
    }


    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptname='" + deptname + '}';
    }
}