package com.vexor.commoninfra.jsonapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonApiServiceResponse<T> {
    private T data;
    private int status;
}
