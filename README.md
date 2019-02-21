# 随记

nacos程序地址：http://kim-file.oss-cn-beijing.aliyuncs.com/nacos-server-0.7.0.zip

sh startup.sh -m standalone

sentinel: http://kim-file.oss-cn-beijing.aliyuncs.com/sentinel-dashboard-1.4.0.jar

java -Dserver.port=7000 -Dcsp.sentinel.dashboard.server=localhost:7000 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.4.0.jar

## 项目规范

- 类注释-属性注释-方法注释
- 新建模块要包含README.md文件
- 在rest层使用http文件书写请求示例
- 写完功能后运行CheckStyle/FindBugs插件进行代码检查

## 要达成的目标

使用nio处理，扩大连接数

支持本地无配置化启动，测试生产配置自动化

swagger  flyway  自动代码生成 mybatisplus  webflux  spring   监控系统  任务调度系统   redis统一缓存   分库分表shardingjdbc  ldap集成  熔断降级(哨兵/hystrix+dashboard)   工具类的引入   oss的引入  异常的处理体系  swagger的标准 自动同步到yapi文档  支持动态log日志   支持http与dubbo调用

统一的包结构

测试http与dubbo的性能
