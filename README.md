# 我的编程项目

> 创建这个项目的初衷是为了系统性的学习spring、MySQL、Redis、k8s等技术

---

## springboot

> 根据2.5.2版本spring-boot-reference进行学习

---

### 创建spring项目

在项目的根目录创建pom文件

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.anger</groupId>
    <artifactId>coding-project</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.2</version>
    </parent>

</project>
```

执行maven package命令进行构建

``` bash
$ mvn package

Building jar: /Users/liuanglin/Projects/angers-coding-project/target/coding-project-0.0.1-SNAPSHOT.jar
```

查看依赖树

``` bash
$ mvn dependency:tree

[INFO] com.anger:coding-project:jar:0.0.1-SNAPSHOT
```

添加 spring-boot-starter-web 依赖

``` xml
    <dependencies>
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

---

### 编写代码

创建 `src/main/java` 目录

创建 `Application.java` 文件

``` java
package com.angers.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application {
    @RequestMapping("/")
        String home() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

**`@RestController`和`@RequestMapping`注解**

`spring`存在以下几种`stereotype annotation`：

1. `@Component`是用来标记任何被Spring管理的组件
2. `@Controller`用来标记表示层 `presentation layer` 的一个 `Controller Component`（比如web controller）
3. `@Repository`用来标记持久层`persistence layer`的DAO Component
4. `@Service`用来标记业务层 `persistence layer` 的 `Service Component`

`@RestController` 注解相当于 `@ResponseBody` ＋ `@Controller` 合在一起的作用。

`@ResponseBody` 注解用于将 `Controller` 的方法返回的对象，通过适当的 `HttpMessageConverter` 转换为指定格式后，写入到 `Response` 对象的 `body` 数据区，通常用来返回 `JSON` 或者 `XML` 数据，返回 `JSON` 数据的情况比较多。

> `Spring` 有一个在后台注册的 `HttpMessageConverters` 列表， `HTTPMessageConverter` 的职责是根据预定义的 `mime` 类型将请求主体转换为特定的类，然后再转换回响应主体。每当发出的请求点击 `@ResponseBody` 时，`Spring` 循环遍历所有已注册的 `HttpMessageConverters`，寻找第一个符合给定 `mime` 类型和类的请求，然后将其用于实际的转换。

`@RequestMapping` 用来映射 `http` 请求，解析路径为 `/` 下的请求映射到 `home()` 方法。

**`@EnableAutoConfiguration` 注解**