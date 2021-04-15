package cn.com.sise.dao;

import cn.com.sise.pojo.Dept;

public interface DeptDao {

    Dept getDept(int deptId);

    int update(Dept dept);

    Dept select(int deptId);

    int delete(int deptId);

    int insert(Dept dept);

}
