package com.aleecoder.proxytest;

import com.aleecoder.mapper.ProjectMapper;
import com.aleecoder.pojo.Project;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author HuanyuLee
 * @date 2022/3/29
 */
public class ProjectTest {
    private SqlSession sqlSession;
    private ProjectMapper projectMapper;

    @Before
    public void init() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession(true);
        projectMapper = sqlSession.getMapper(ProjectMapper.class);
    }

    @Test
    public void findProjectJoinEmpsByPid(){
        Project project = projectMapper.findProjectJoinEmpsByPid(2);
        System.out.println(project.show());
        project.getProjectRecords().forEach(System.out::println);
    }

    @After
    public void release() {
        sqlSession.close();
    }
}
