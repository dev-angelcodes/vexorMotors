package com.vexor.commoninfra.jsonapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonApiObject<T> {
    private int count;
    private String input;
    private List<T> result;
    private JsonApiLink links;
    private Object included;

    public JsonApiObject(int count, List<T> result) {
        this.count = count;
        this.result = result;
    }

}
