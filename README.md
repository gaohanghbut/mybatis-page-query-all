# mybatis-page-query-all
mybatis dao自动分页查询。如果在系统启动时需要将各种不同的基础数据全部加载到内存中，可以使用分页查询的方式，但是会有大量处理分页查询的代码，此插件用于自动执行分页

# 使用
配置mybatis插件:
```xml
<plugin interceptor="cn.yxffcode.mybatispagequeryall.PageQueryAllInterceptor"></plugin>
```
对于DAO,需要使用此插件的查询方法上加上注解@Paged
```java
@Select({
        "select id, name from user"
})
@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name")
})
@Paged
List<User> selectAll();
```
@Paged注解可以标记在类或者接口的方法上,value属性表示一页的大小,默认为100

创建DAO代理,用于处理分页上下文
```java
UserDao userDao = DaoProxy.wrapNotNull(sqlSession.getMapper(UserDao.class))
```

# 使用Spring
在Dao上使用任何注解标记,例如@Repository
spring中配置DaoPageQueryAllBeanPostProcessor
```xml
<bean class="cn.yxffcode.mybatispagequeryall.DaoPageQueryAllBeanPostProcessor">
    <constructor-arg value="org.springframework.stereotype.Repository"/>
</bean>
```
