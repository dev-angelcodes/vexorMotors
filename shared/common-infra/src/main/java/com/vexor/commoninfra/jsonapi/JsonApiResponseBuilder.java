package com.vexor.commoninfra.jsonapi;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JsonApiResponseBuilder<T> {
    private int count;
    private String input;
    private List<T> result;
    private JsonApiLink links;
    private Object included;

    public static <T> JsonApiResponseBuilder<T> builder() {
        return new JsonApiResponseBuilder<>();
    }

    public JsonApiResponseBuilder<T> count(int count) {
        this.count = count;
        return this;
    }

    public JsonApiResponseBuilder<T> input(String input) {
        this.input = input;
        return this;
    }

    public JsonApiResponseBuilder<T> result(List<T> result) {
        this.result = result;
        return this;
    }

    public JsonApiResponseBuilder<T> links(JsonApiLink links) {
        this.links = links;
        return this;
    }

    public JsonApiResponseBuilder<T> included(Object included) {
        this.included = included;
        return this;
    }

    public JsonApiObject<T> build() {
        JsonApiObject<T> obj = new JsonApiObject<>();
        obj.setCount(count);
        obj.setInput(input);
        obj.setResult(result);
        obj.setLinks(links);
        obj.setIncluded(included);
        return obj;
    }
}
