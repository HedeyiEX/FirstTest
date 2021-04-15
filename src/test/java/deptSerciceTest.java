import cn.com.sise.Service.DeptService;
import cn.com.sise.dao.DeptDao;
import cn.com.sise.pojo.Dept;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class deptSerciceTest {
    private DeptDao mockDao;
    private DeptService deptService;


    @Before
    public void setUp()throws Exception{
        mockDao=mock(DeptDao.class);
        when(mockDao.getDept(404)).thenReturn(new Dept(404,"计算机系"));
        when(mockDao.update(isA(Dept.class))).thenReturn(1);//thenReturn 用来指定特定函数和参数调用的返回值。
        when(mockDao.select(404)).thenReturn(new Dept(404,"计算机系"));

        deptService = new DeptService(mockDao);
    }

    //修改
    @Test
    public void testUpdate() throws Exception{
        int result = deptService.update(404,"计算机学院");
        //Assert.assertEquals();及其重载方法:
        // 1. 如果两者一致, 程序继续往下运行.
        // 2. 如果两者不一致, 中断测试方法, 抛出异常信息 AssertionFailedError.
        assertEquals(1,result);//
        verify(mockDao,times(1)).getDept(eq(404));
        verify(mockDao,times(1)).update(isA(Dept.class));
        System.out.println("测试成功！");
    }


//    //查询
//    @Test
//    public void testSelect() throws Exception{
//        Dept dept = deptService.select(404);
//        Dept dept1 = new Dept();
//        dept1.setDeptId(404);
//        dept1.setDeptname("计算机系");
//        System.out.println(dept);
//        assertEquals(dept1,dept);
//        verify(mockDao,times(1)).select(eq(404));
//    }
//
//    //删除
//    @Test
//    public void testDelete() throws Exception{
//        int result = deptService.delete(408);
//        assertEquals(1,result);//
//        verify(mockDao,times(1)).getDept(eq(403));
//        verify(mockDao,times(1)).delete(eq(403));
//    }
//
//    //增加
//    @Test
//    public void insertDeptText()throws Exception{
//        int result=deptService.insert(407,"网络系");
//        assertEquals(1,result);
//        verify(mockDao,times(1)).getDept(eq(403));
//        verify(mockDao,times(1)).insert(isA(Dept.class));
//    }
//
//    public static void main(String[] args) {
//        System.out.println("测试！！");
//    }

}
