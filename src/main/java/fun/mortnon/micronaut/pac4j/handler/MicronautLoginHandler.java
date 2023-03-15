package fun.mortnon.micronaut.pac4j.handler;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.handlers.LoginHandler;
import jakarta.inject.Singleton;

/**
 * @author dev2007
 * @date 2023/3/2
 */
@Singleton
//@Requires(beans = org.pac4j.core.config.Config.class)
public class MicronautLoginHandler implements LoginHandler {
    @Override
    public MutableHttpResponse<?> loginSuccess(Authentication authentication, HttpRequest<?> request) {
        return null;
    }

    @Override
    public MutableHttpResponse<?> loginRefresh(Authentication authentication, String refreshToken, HttpRequest<?> request) {
        return null;
    }

    @Override
    public MutableHttpResponse<?> loginFailed(AuthenticationResponse authenticationResponse, HttpRequest<?> request) {
        return null;
    }
}
