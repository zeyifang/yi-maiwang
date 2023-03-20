package com.javacto.utils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator{
    public static void main(String[] args) {

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");  // (它自动去找到）获取当前项目根路径 user.dir : E:\IdeaProjects\JavaPrimary
        gc.setOutputDir(projectPath+"/src/main/java");		//生成位置
        gc.setAuthor("adam8831");
        gc.setOpen(false); //不打开生产的文件
        gc.setFileOverride(true); //不覆盖之前生成的文件
        //        //设置生成代码的名字
        //        gc.setEntityName("%sEntity")
        //                .setServiceName("%sService")
        //                .setServiceImplName("%sServiceImpl")
        //                .setMapperName("%sMapper")
        //                .setControllerName("%sController");
        gc.setServiceName("%sService");//前面%s一定要加，否则生成的service会存在- Adminervice
        gc.setIdType(IdType.AUTO);// 主键策略 自增  注意要和数据库中表实际情况对应
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/store?useUnicode=true&characterEncoding=utf8");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.javacto");
        pc.setController("controller");
        pc.setService("service");
        pc.setEntity("po");
        pc.setMapper("mapper");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);// 自动生成lombok注解  记住要有lombok依赖和对应的插件哈
        strategy.setRestControllerStyle(true); //rest风格controller
        // strategy.setInclude("t_user");
        //可以用同配符号:表示生成t_开头的对应库下所有表
        // strategy.setInclude("t"+"_\\w*");

        //        strategy.setTablePrefix("t_");//去掉t_这个前缀后生成类名
        //        strategy.setLogicDeleteFieldName("is_deleted");//设置逻辑删除字段 要和数据库中表对应哈
        //        // 设置创建时间和更新时间自动填充策略
        //        TableFill created_date = new TableFill("created_date", FieldFill.INSERT);
        //        TableFill updated_date = new TableFill("updated_date", FieldFill.INSERT_UPDATE);
        //        ArrayList<TableFill> tableFills = new ArrayList<>();
        //        tableFills.add(created_date);
        //        tableFills.add(updated_date);
        //        strategy.setTableFillList(tableFills);
        //        // 乐观锁策略
        //        strategy.setVersionFieldName("version");
        //        strategy.setRestControllerStyle(true);//采用restful 风格的api
        //        strategy.setControllerMappingHyphenStyle(true); // controller 请求地址采用下划线代替驼峰

        // strategy.setLogicDeleteFieldName("status"); //设置逻辑删除的字段名
        //填充字段配置
        //        List<TableFill> list = new ArrayList<>();
        //        list.add(new TableFill("createTime", FieldFill.INSERT));
        //        list.add(new TableFill("updateTime", FieldFill.INSERT_UPDATE));
        //        strategy.setTableFillList(list);

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setStrategy(strategy);
        mpg.setPackageInfo(pc);

        // 执行
        mpg.execute();
    }
}