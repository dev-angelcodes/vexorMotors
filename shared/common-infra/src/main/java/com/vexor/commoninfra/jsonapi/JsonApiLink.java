package com.vexor.commoninfra.jsonapi;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonApiLink {
    private String first;
    private String last;
    private String next;
    private String prev;
    private Long total;
}
