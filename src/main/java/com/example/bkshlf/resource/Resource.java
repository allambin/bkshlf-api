package com.example.bkshlf.resource;

import com.example.bkshlf.model.BaseModel;

import java.util.*;
import java.util.stream.Collectors;

abstract public class Resource<M extends BaseModel>
{
    private String resourceWrapper;
    private String collectionWrapper;

    public Resource()
    {
        this("data", "data");
    }

    public Resource(String resourceWrapper, String collectionWrapper)
    {
        this.resourceWrapper = resourceWrapper;
        this.collectionWrapper = collectionWrapper;
    }

    public Map<String, Object> toResource(M model)
    {
        Map<String, Object> response = new HashMap<>();
        response.put(resourceWrapper, toArray(model));

        return response;
    }

    public Map<String, Object> toCollection(List<M> models, Map<String, Object> meta)
    {
        List<M> collection = new ArrayList<>(models);

        Map<String, Object> response = new HashMap<>();
        response.put(collectionWrapper, collection.stream().map(this::toArray).collect(Collectors.toList()));

        if (!meta.isEmpty()) {
            response.put("meta", meta);
        }

        return response;
    }

    public Map<String, Object> toCollection(List<M> models)
    {
        return toCollection(models, Collections.emptyMap()); // Default empty meta map
    }

    abstract public Map<String, Object> toArray(M model);
}
