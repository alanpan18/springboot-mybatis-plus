package com.alan.smpdemo.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;

/**
 * @author alanpan
 * @title: MainGenerator
 * @projectName springboot-mybatis-plus
 * @description: TODO
 * @date 2019/4/1414:38
 */
public class MainGenerator {

    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();

        AutoGenerator autoGenerator =new AutoGenerator();


        //全局变量
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setAuthor("alan");

        globalConfig.setOutputDir(System.getProperty("user.dir")+ File.separator +"src/main/java");
        globalConfig.setFileOverride(false);// 是否覆盖同名文件，默认是false
        globalConfig.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        globalConfig.setEnableCache(false);// XML 二级缓存
        globalConfig.setBaseResultMap(true);// XML ResultMap
        globalConfig.setBaseColumnList(false);// XML columList
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert(){
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/smp_demo?useUnicode=true&characterEncoding=utf8");
        autoGenerator.setDataSource(dataSourceConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 表前缀处理
        strategyConfig.setTablePrefix(new String[]{"sys_"});
        //表名生成策略
        strategyConfig.setNaming(NamingStrategy.nochange);
        //需要生成的表
        strategyConfig.setInclude(new String[]{"sys_user"});
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);

        autoGenerator.setStrategy(strategyConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();

        packageConfig.setParent("com.alan.smpdemo");

        autoGenerator.setPackageInfo(packageConfig);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        // InjectionConfig cfg = new InjectionConfig() {
        // @Override
        // public void initMap() {
        // Map<String, Object> map = new HashMap<String, Object>();
        // map.put("abc", this.getConfig().getGlobalConfig().getAuthor() +
        // "-mp");
        // this.setMap(map);
        // }
        // };
        //
        // // 自定义 xxList.jsp 生成
        // List<FileOutConfig> focList = new ArrayList<>();
        // focList.add(new FileOutConfig("/template/list.jsp.vm") {
        // @Override
        // public String outputFile(TableInfo tableInfo) {
        // // 自定义输入文件名称
        // return "D://my_" + tableInfo.getEntityName() + ".jsp";
        // }
        // });
        // cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);
        //
        // // 调整 xml 生成目录演示
        // focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
        // @Override
        // public String outputFile(TableInfo tableInfo) {
        // return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
        // }
        // });
        // cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);
        //
        // // 关闭默认 xml 生成，调整生成 至 根目录
        // TemplateConfig tc = new TemplateConfig();
        // tc.setXml(null);
        // mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        autoGenerator.execute();
    }
}
