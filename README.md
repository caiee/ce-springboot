[![Build Status](https://img.shields.io/travis/whitewallpaper/ce-springboot/master.svg)](https://travis-ci.org/whitewallpaper/ce-springboot)
[![codecov](https://codecov.io/gh/whitewallpaper/ce-springboot/branch/master/graph/badge.svg)](https://codecov.io/gh/whitewallpaper/ce-springboot)

1
2
3
4
# Boot Template #
一个 `SpringBoot` 的模板， 集成了一个后端理应具备的功能。
如果你发现还缺了些什么，欢迎补充：）

# 需求 #
- [x] 启动 `HelloWorld`
- [x] 提升 `Spring` 整体版本， 使用 4.3.2.RELEASE
    - [x] 版本提高后 原来 RequestMapping(value = , RequestMethod = ) 可以直接 用 GetMapping()，较为直观。
- [x] 完成 `全局返回值` 增强(格式统一)
- [x] 完成 `全局异常捕捉`
- [ ]  图片`上传`，`大小`限制， (`格式`限制？)
- [x] 自定义监听端口，访问路径
- [x] 完成与各中间件集成
    - [x] `Mybatis`
    - [x] Mybatis 插件， `分页`插件 PageHelper 与 `自动生成代码`插件
    - [ ] Redis
    - [ ] Mongo
    - [ ] Kafka
- [ ] 集成 Swagger API文档
- [ ] 实现单元测试(web, dao)
    - [x] `web` 测试
    - [x] `dao` 测试
- [x] `多环境` 配置文件 与 `打包`
    - [x] 多环境配置文件使用
- [x] 日志
    - [x] 集成`ELK`(ElasticSearch, LogStash, Kafka)组件
    - [ ] logback.xml 使用 groovy 语法
- [ ] 添加 Jenkins `CI` 功能
- [ ] 是否可以 学习 并 使用 并集成 Spring Security ?

# 项目启动 #

``` java
git clone

// 第一种做法
mvn spring:run
// 第二种
运行 Application.java 中的 main 方法
```


# 如何使用 #

## 单元测试 ##
两个快捷键：
* Run context configuration, 用于设置运行类， 可以把鼠标放在 类上，方法上，包上，直接运行所有测试类与方法
* Run, 在修改代码后可以直接跑之前的测试用例，用于快速运行单元测试来确保代码无误。

我们在测试目录中提供了 **基础测试类**: `ApplicationBaseTest`。

它做了三件事：
* @Runwith(SpringJunitRunner.class) 告诉 Junit 以 Spring的环境 运行测试
* @SpringApplicationConfiguration(classes = Application.class)， 加载所有项目类
* 初始化MockMvc对象

你可以在你自己的类中继承它(extends ApplicationBaseTest)，从而进行单元测试的操作。

**(还没做但希望做到的事情)**：

通过Mockito来实现Service调用，可以保证数据的正确性(CRUD会导致数据库查询错乱)。

#### web层测试 ####

~~~ java
public class UserControllerBaseTestCaseTemplate extends ApplicationBaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        Assert.assertNotNull(mockMvc);

        // Get请求, 无参数, 返回单个元素
        // 封装请求， 请求方法为 get， 路径为 /a， 这里不需要考虑 context-path
        mockMvc.perform(get("/a"))
                // 判断 HttpCode
                .andExpect(status().isOk())
                // 可以打印
                .andDo(print())
                // 比较返回的 contentType
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                // 比较返回数据的值(语法)
                .andExpect(jsonPath("$.name").value("user name"))
                .andExpect(jsonPath("$.age").value(20));

    }
}
~~~
For more details, `Refer to`
[UserControllerBaseTestCaseTemplate](https://git.zhai.me/spring-boot/template/blob/develop/src/test/java/com/zhaimi/springboot/controller/UserControllerTestCaseTemplate.java):

资料：

https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/

http://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/html/integration-testing.html#spring-mvc-test-framework

#### Dao层测试 ####

与原来的测试相同， 注入相应的Mapper 作断言即可
~~~ java
public class UserMapperBaseTestCaseTemplate extends ApplicationBaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        final List<User> allUsers = userMapper.findAllUsers();
        assertNotNull(allUsers);
        assertEquals(allUsers.size(), 5);
    }
}
~~~

## 多环境配置与打包 ##

#### 打包 ####
`mvn package` 将项目打成一个可执行的Fat Jar包

推荐使用 `mvn clean package -Dmaven.test.skip=true` 跳过测试打包

#### 启动脚本 ####
java -jar target/springboot-template-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
#### 参数解释 ####
**spring.profiles.active**：指定运行的环境。

现在有多环境(dev、test、prod)，在启动时则是不同的参数脚本。

SpringBoot会默认先加载 application.yml，而后再去加载 application-{profiles}.yml。

#### 配置文件注入 ####

> @ConfigurationProperties(prefix = "person", locations = "classpath:${spring.profiles.active}/config.yml")

通过 `${spring.profiles.active}` placeholder 来 获取 当前的 环境参数。

## 数据分页查询 ##
集成了 `PageHelper`，在查询前指定 **page** 和 **size** 即可。

~~~ java
    @Test
    public void testSelectPage() {
        PageHelper.startPage(2, 6);
        final List<User> allUsers = userMapper.selectUsers();
        final Page page = Page.toPage(allUsers);

        assertNotNull(allUsers);
        assertEquals(2, page.getCurrent());
        assertEquals(6, page.getPer());
        assertEquals(28, page.getCount());
    }
~~~
参考资料：
http://git.oschina.net/free/Mybatis_PageHelper
