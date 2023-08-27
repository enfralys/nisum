package co.com.luloinc.api.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Response<T> {

    private Long count;
    private T data;
    private LocalDateTime date;
    private HttpStatus status;
    private List<String> message = new ArrayList<>();

    public Response(T data, HttpStatus status){
        this.data = data;
        this.status = status;
        this.date = LocalDateTime.now();
        this.message = new ArrayList<>();
    }

    public Response(Long count, T data) {
        this.count = count;
        this.data = data;
        this.status = HttpStatus.OK;
    }
}