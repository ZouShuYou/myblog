package com.zsy.blog.common.util;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-12-02 16:18
 */
public class CodeGeneratorUtils {

    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入 "+ tip + ":   ");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        String moduleName = scanner("模块名");
        String tableName = scanner("表名");
        String entityName = "";
        if (tableName.indexOf("_") > 0) {
            entityName = tableName.split("_")[1];
        } else {
            entityName = tableName;
        }

        System.out.println(entityName);

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //System.out.println(projectPath);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zsy");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ID_WORKER_STR);
        mpg.setGlobalConfig(gc);


        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/blog?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        PackageConfig pc =new PackageConfig();
        pc.setParent("com.zsy.blog.manage");
        pc.setModuleName(moduleName);
        mpg.setPackageInfo(pc);

        String finalEntityName = entityName;
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("entityName",finalEntityName);
                map.put("/urlPrefix","/admin");
                map.put("basePath","com.zsy.blog");
                this.setMap(map);
            }
        };
    }
}
