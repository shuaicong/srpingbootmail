Spring boot中对邮件的发送也提供了支持，本篇文章只要是介绍sringboot中如何发送邮件。
如果对springboot很熟悉，那么这个熟悉起来也很快的。

## pom文件
```
  <properties>
        <java.version>1.8</java.version>
        <thymeleaf.version>3.0.0.RELEASE</thymeleaf.version>
        <thymeleaf-layout-dialect.version>2.0.0</thymeleaf-layout-dialect.version>
    </properties>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.1.RELEASE</version>
        <relativePath/>
    </parent>

    <dependencies>

        <!-- spring boot 配置 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- spring boot 热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>


        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
    </dependencies>
```  
所需要的依赖全都在这里了。

### application.properties
这个配置文件需要配置一些，发送邮件所需要的配置
```
spring.mail.host=smtp.qq.com
spring.mail.port=587
spring.mail.username=xxxxxx
spring.mail.password=xxxxxx

spring.thymeleaf.cache=false

```  
推荐使用qq邮箱，163的会频繁报错，抽风。

