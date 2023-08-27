package co.com.luloinc.api.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GenericHandler {

    public static final String SYSTEM_ERROR = "HUBO UN ERROR EN LA SOLICITUD";
    public static final String SYSTEM_TECHNICAL_ERROR = "Se presento un error tecnico, " +
            "por favor consultar con el administrador del sistema";



    protected ServerResponse.BodyBuilder bodyBuilder() {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON);
    }

    protected Mono<ServerResponse> bodyBuilder(Object object, Long count) {
        Response<Object> response = new Response<>();
        response.setData(object);
        response.setStatus(HttpStatus.OK);
        response.setCount(count);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(response);
    }

    protected Mono<ServerResponse> errorResponse(Throwable t,String uuid){
        Response<Object> response = new Response<>();
        response.getMessage().add(t.getMessage());
        return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue(response);
    }

    protected Mono<ServerResponse> errorResponse(Throwable t){
        Response<Object> response = new Response<>();
        response.getMessage().add(t.getMessage());
        return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue(response);
    }


}
