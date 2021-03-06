package com.baowj.dao.impl;

import com.baowj.dao.StudentDao;
import com.baowj.domain.Student;
import com.baowj.uils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        //1. 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.baowj.dao.StudentDao.selectStudents";
        //2. 执行sql语句
        List<Student> students = sqlSession.selectList(sqlId);
        //3. 关闭
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.baowj.dao.StudentDao.insertStudent";
        int tmp = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return tmp;
    }
}
