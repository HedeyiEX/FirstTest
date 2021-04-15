package cn.com.sise.Service;

import cn.com.sise.dao.DeptDao;
import cn.com.sise.pojo.Dept;

public class DeptService{
    private DeptDao deptDao;
    private Dept dept;

    public DeptService(DeptDao deptDao){
        this.deptDao=deptDao;
    }

    public int update(int deptId ,String deptname){
        Dept dept = deptDao.getDept(deptId);
        if(dept==null){
            return 0;
        }
        Dept deptUpdate=new Dept(dept.getDeptId(),deptname);
        return deptDao.update(deptUpdate);
    }


    public Dept select(int deptId){
        return deptDao.getDept(deptId);
    }


    public int delete(int deptId){
        Dept dept = deptDao.getDept(deptId);
        if(dept==null){
            return 0;
        }
        return deptDao.delete(deptId);
    }

    public int insert(int deptId,String deptname){
        Dept dept=deptDao.getDept(deptId);
        if(dept!=null){
            return 0;
        }else{
            Dept deptInsert=new Dept(deptId,deptname);
            return deptDao.insert(deptInsert);
        }

    }


}
