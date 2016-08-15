# Spring boot #
Convention over configuration (约定大于配置)

# 个人想法 #
鉴于目前 Spring Boot 非常火，我就想倒腾倒腾，
将一些项目中所必备的基础都先搭好，留一个架子，看以后是否有机会可以用到。

# 需求 #

* √ 启动 `HelloWorld`
* √ 提升 `Spring` 整体版本， 使用 4.3.2.RELEASE
    * 版本提高后 原来 RequestMapping(value = , RequestMethod = ) 可以直接 用 GetMapping()，较为直观。
* √ `HttpMessageConverter` 修改为 `FastJson`
* √ 完成 `全局返回值` 增强(格式统一)
* √ 完成 `全局异常捕捉`
* 图片`上传`，`大小`限制， (`格式`限制？)
* 完成与各中间件集成
    * `Mybatis`
    * Mybatis 插件， `分页`插件 PageHelper 与 `自动生成代码`插件
    * Redis
    * Mongo
    * Kafka (zm-koper)
* 实现单元测试(web, dao)
    * `web` 测试
    * `dao` 测试
* `多环境` 配置文件 与 `打包`
* 日志
    * 集成`ELK`(ElasticSearch, LogStash, Kafka)组件
* 添加 Jenkins `CI` 功能

# 项目启动 #

``` java
git clone

// 第一种做法
mvn spring:run
// 第二种
运行 Application.java 中的 main 方法
```
