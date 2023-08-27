package co.com.luloinc.api.user;

import co.com.luloinc.api.common.GenericHandler;
import co.com.luloinc.api.common.Response;
import co.com.luloinc.api.request.UserRequest;
import co.com.luloinc.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@RestController
@RequiredArgsConstructor
public class UserHandler extends GenericHandler {
    private final UserUseCase userUseCase;

    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserRequest.class).flatMap(UserRequest -> userUseCase.createUser(UserRequest.toModel()))
                .flatMap(data -> ServerResponse.ok().bodyValue(new Response<>(data, HttpStatus.OK)))
                .onErrorResume(e->this.errorResponse(e,"reqUUID"));
    }
}

