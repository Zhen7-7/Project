package org.zhen77;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

/**
 * @author : zhen77
 * @date: 2021/2/26 - 02 - 26 - 11:13
 * @Description: org.zhen77
 * @version: 1.0
 */
public class TestGenerator {
    @Test
    public void testGenerator() {
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();//一定导入generator的config
        globalConfig.setAuthor("lian")
                .setOutputDir("D:\\WebPro\\family_service_platform\\src\\main\\java")//设置输出路径
                .setFileOverride(true)//设置文件覆盖
                .setIdType(IdType.AUTO)//设置主键生成策略
                .setServiceName("%sService")//service接口的名称
                .setBaseResultMap(true)//基本结果集合
                .setBaseColumnList(true)//设置基本的列
                .setControllerName("%sController");

        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver").setUrl("jdbc:mysql://localhost:3306/family_service_platform?serverTimezone=UTC")
                .setUsername("root").setPassword("root");

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//设置全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                //.setTablePrefix("tbl_")//设置表名前缀
                .setInclude();

        //包名配置
        //mapper/service/controller/bean/mapper都会生成
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("org.zhen77").setMapper("mapper")
                .setService("service").setController("controller")
                .setEntity("bean").setXml("mapper");

        autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig).setPackageInfo(packageConfig);

        autoGenerator.execute();
    }
}
