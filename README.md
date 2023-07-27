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

3. 配置相关客户端，示例如下：

```java
@Factory
public class Pac4jConfig {
    @Singleton
    public Config config() {
        GiteeClient giteeClient = new GiteeClient("client_id", "client_secret");
        Config config = new Config("http://localhost:8080/callback", giteeClient);
        return config;
    }
}
```

以上示例使用的是 `GiteeClient` 实现，使用的依赖为：

```xml
<dependency>
    <groupId>fun.mortnon.pac4j</groupId>
    <artifactId>oauth-gitee</artifactId>
    <version>1.0.0</version>
</dependency>
```

4. `application.yml` 中添加配置：

```yaml
mortnon:
  pac4j:
    global: false
    login-uri: /sso/login
    callback-uri: /callback
```

`global` 值说明：

- `true`：全局任意 URL 的访问都会触发 SSO 跳转逻辑
- `false`：只有 `login-uri` 配置的 URL 才能触发 SSO 跳转逻辑

`login-uri`：触发 SSO 逻辑的特定 URL，默认值为 `/sso/login`

`callback-uri`：SSO 的回调 URL 地址，默认值为 `/callback`

Demo 详情代码，参阅：https://github.com/mortise-and-tenon/micronaut-pac4j-demo
