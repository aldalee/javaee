package com.aleecoder.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动生成实体类、mapper接口和映射文件
 * 失败了？？？？
 *
 * @author HuanyuLee
 * @date 2022/3/29
 */
public class GeneratorSqlMap {
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<>();
        File configFile = new File("D:\\WorkSpace\\JavaCore\\JavaEE\\ReverseEngineering\\target\\classes\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }

    public static void main(String[] args) {
        try {
            GeneratorSqlMap generatorSqlmap = new GeneratorSqlMap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
