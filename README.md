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

---

### 运行应用

在根目录执行命令

``` bash
$ mvn spring-boot:run

2021-07-09 17:55:10.306  INFO 86862 --- [           main] com.angers.project.Application           : Started Application in 1.27 seconds (JVM running for 1.604)
```

在浏览器中输入 <http://localhost:8080/> ，展示服务运行结果 `Hello World!` 。

---

### 创建可执行的Jar包

在 `pom` 文件中添加 `spring-boot-maven-plugin` 插件，在 `<dependencies>` 部分之后:

``` xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

执行打包命令：

``` bash
$ mvn package

Building jar: /Users/liuanglin/Projects/angers-coding-project/target/coding-project-0.0.1-SNAPSHOT.jar
```

通过 `jar` 运行应用

``` bash

java -jar target/coding-project-0.0.1-SNAPSHOT.jar

```

在浏览器中输入 <http://localhost:8080/> ，展示服务运行结果 `Hello World!` 。

---

### 应用的可用性

应用部署后，需要向应用所部署和运行的基础设施（比如 `kubernetes` ）及时上报应用服务的可用性， `Spring Boot` 提供了比较常用的 **liveness** 和 **readiness** 健康检查机制。

---

#### Liveness 状态

**Liveness** 状态表示应用内部服务可以正常的运作，或者能够从暂时的失败中恢复，如果应用无法正常运作，需要重启应用服务来恢复应用。

---

#### Readiness 状态

**Readiness** 状态表示应用能够地处理服务请求，通常的使用场景是：应用在启动过程中， `CommandLineRunner` 和 `ApplicationRunner` 还没有启动完成，无法正常的处理请求，或者在任何应用繁忙无法处理更多请求的场景。

> 如果期望在启动过程中执行某项操作，应当使用 `CommandLineRunner` 和 `ApplicationRunner` 组件。

---

#### 管理应用的状态

我们可以监听应用的状态，当状态发生变化时，对于应用的健康检测探针作相应的操作，这样，基础设施就能及时发现应用的状态并进行相应的处理。

在应用就绪时创建探针，无法正常接收请求时销毁探针:

``` java
package com.angers.project.tools;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationReadinessStateReporter {
    public final static String FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project"; 
    public final static String FILE_NAME = "ApplicationReady.txt";
    @EventListener
    public void onStateChanged(AvailabilityChangeEvent<ReadinessState> event){
        switch(event.getState()){
            case ACCEPTING_TRAFFIC:
            log.info("应用启动成功，可以正常接收请求
            break;
            case REFUSING_TRAFFIC:
            log.info("应用内部发生异常，无法正常接收请求！");
            break;
        }
    }
}
```

在应用无法正常恢复时更新应用的状态：

``` java
package com.angers.project.tools;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationLocalCacheVerifier {

    public final static String FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project"; 

    public final static String FILE_NAME = "ApplicationLive.txt";

    private final ApplicationEventPublisher publisher;

    public ApplicationLocalCacheVerifier(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    public void checkApplicationLocalCache(){
        try {
            //创建应用存活探针
            log.info("应用启动成功，可以正常接收请求
        } catch (Exception e) {
            AvailabilityChangeEvent.publish(publisher, e, LivenessState.BROKEN);
        }
    }
}
```

---

### ApplicationEvent 和 Listener

spring框架除了发送一些常规的事件，例如 `ContextRefreshedEvent` , `SpringApplication` 还会发送一些额外的事件。

> 有一些事件在 `ApplicationContext` 创建之前就会触发，在这之前你还无法将这些事件的 `Listener` 作为一个 `@Bean` 来进行注册，可以使用 `SpringApplication.addListeners()` 或者 `SpringApplicationBuilder.listeners()` 来进行添加。  
> 还有一种方式，在项目中创建 `META-INFO/spring.factories` 文件，使用 `org.springframework.context.ApplicationListener` 作为key，添加对应的 `Listener` 到文件中, `Listener` 即可以实现自动注册，如下所示：  

``` properties
org.springframework.context.ApplicationListener=com.angers.project.tools.ApplicationReadinessStateReporter
```

`Application` 事件的发送顺序如下：

1. `ApplicationStartingEvent` 在启动后，任何其它的程序处理前发送（除了注册 `Listener` 和 `Initializer` 的操作）。
2. `ApplicationEnvironmentPreparedEvent` 在已知上下文所使用的环境，但上下文还未创建前发送。
3. `ApplicationContextInitializedEvent` 在 `ApplicationContext` 已经准备好，而且 `ApplicationContextInitializers` 已经被调起之后，但是还没有 `@Bean` 被装载之前发送。
4. `ApplicationPreparedEvent` 在刷新开始之后，但是还没有 `@Bean` 被装载之前发送。
5. `ApplicationStartedEvent` 在上下文被刷新后，但是还没有 `application` 和 `command-line runners` 被调用之前发送。
6. `AvailabilityChangeEvent` 在 `LivenessState.CORRECT` 应用可以被视为运行中之后发送。
7. `ApplicationReadyEvent` 在任意 `application` 和 `command-line runners` 被调起后发送。
8. `AvailabilityChangeEvent` 在 `ReadinessState.ACCEPTING_TRAFFIC` 应用可以正常接收请求后发送。
9. `ApplicationFailedEvent` 在应用启动发生异常时发送。

上述都属于 `SpringApplicationEvent` 的事件，除此之外，下面的事件也会在 `ApplicationPreparedEvent` 之后， `ApplicationStartedEvent` 之前发送：

* `WebServerInitializedEvent` 在 `WebServer` 就绪之后， `ServletWebServerInitializedEvent` 和 `ReactiveWebServerInitializedEvent` 分别为 `servlet` 和 `reactive` 时发送。

* `ContextRefreshedEvent` 在 `ApplicationContext` 刷新完成之后发送。

<!-- TODO -->
> `Event listeners` 应当尽量避免用于处理耗时比较长的任务，因为它们默认都是使用同一个线程的，作为替代，可以使用 `ApplicationRunner` 和 `CommandLineRunner`

### `ApplicationRunner` 和 `CommandLineRunner`

可以通过实现 `ApplicationRunner` 和 `CommandLineRunner` 在spring启动开始运行一些特定的代码，这两个接口都有一个 `run` 方法，我们只需要实现这个方法即可，二者的区别为：`ApplicationRunner` 中的 `run` 方法参数为 `ApplicationArguments` , `CommandLineRunner` 中的 `run` 方法的参数为 `String` 数组，如果有多个 `runner` ，需要添加注解 `@Order` 指定执行顺序。

``` java
@Slf4j
@Order(value = 1)
@Component
public class FirstApplicationRunner implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("first application runner");    
    }
    
}
```

> 要使 `runner` 生效需要在 `Application` 指定注解 `@SpringBootApplication`  
> `runner` 的运行时机在应用启动后，开始处理请求之前。  

``` log
2021-07-12 09:11:00.252  INFO 24906 --- [           main] c.a.p.runner.FirstApplicationRunner      : first application runner
2021-07-12 09:11:00.252  INFO 24906 --- [           main] c.a.p.runner.SecondApplicationRunner     : second application runner
2021-07-12 09:11:00.252  INFO 24906 --- [           main] c.a.p.runner.FirstCommandlineRunner      : first commandline runner
2021-07-12 09:11:00.252  INFO 24906 --- [           main] c.a.p.runner.SecondCommandLineRunner     : second commandline runner
2021-07-12 09:11:00.255  INFO 24906 --- [           main] .a.p.l.ApplicationReadinessStateReporter : ACCEPTING_TRAFFIC应用启动成功，可以正常接收请求！
2021-07-12 09:11:00.257  INFO 24906 --- [           main] .a.p.l.ApplicationReadinessStateReporter : ACCEPTING_TRAFFIC应用启动成功，可以正常接收请求！
2021-07-12 09:11:00.259  INFO 24906 --- [           main] .a.p.l.ApplicationReadinessStateReporter : 应用启动成功，可以正常接收请求!
```
