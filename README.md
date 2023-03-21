# Micronaut-pac4j

Micronaut 框架对接使用 pac4j 的适配组件。

## 说明

1. 当前支持 Java 11
2. 依赖 Pac4j 5.7.0
3. 依赖 Micronaut Security 3.9.3

## 快速开始

1. Micronaut 项目中引入依赖

```xml
<dependency>
    <groupId>fun.mortnon</groupId>
    <artifactId>micronaut-pac4j</artifactId>
    <version>${version}</version>
    <scope>compile</scope>
</dependency>
```

2. 如果指定了 Micronaut Security 配置，将会使用对应配置的 LoginHandler 实现；如果未启用，需要自行实现 LoginHandler，实现示例如下：

```java
@Singleton
public class DemoLoginHandler implements LoginHandler {
    @Override
    public MutableHttpResponse<?> loginSuccess(Authentication authentication, HttpRequest<?> request) {
        return HttpResponse.ok(authentication);
    }

    @Override
    public MutableHttpResponse<?> loginRefresh(Authentication authentication, String refreshToken, HttpRequest<?> request) {
        return null;
    }

    @Override
    public MutableHttpResponse<?> loginFailed(AuthenticationResponse authenticationResponse, HttpRequest<?> request) {
        return HttpResponse.badRequest("login fail");
    }
}
```

Demo 代码，参阅：https://github.com/mortise-and-tenon/micronaut-pac4j-demo
