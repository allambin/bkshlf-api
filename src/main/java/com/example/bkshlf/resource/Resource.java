package com.example.bkshlf.resource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract public class Resource<M, R extends Resource<M, R>>
{
    public static String resourceWrapper = "data";
    public static String collectionWrapper = "data";

    public static <M, R extends Resource<M, R>> Map<String, Object> toResource(M model, Class<R> resourceClass)
    {
        R resource = createResource(model, resourceClass);

        Map<String, Object> response = new HashMap<>();
        response.put(getResourceWrapper(resourceClass), resource);

        return response;
    }

    public static <M, R extends Resource<M, R>> Map<String, Object> toCollection(List<M> models, Class<R> resourceClass, Map<String, Object> meta)
    {
        List<R> collection = models.stream()
                .map(model -> createResource(model, resourceClass))
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put(getCollectionWrapper(resourceClass), collection);

        if (!meta.isEmpty()) {
            response.put("meta", meta);
        }

        return response;
    }

    public static <M, R extends Resource<M, R>> Map<String, Object> toCollection(List<M> models, Class<R> resourceClass)
    {
        return toCollection(models, resourceClass, Collections.emptyMap()); // Default empty meta map
    }

    private static <M, R extends Resource<M, R>> R createResource(M model, Class<R> resourceClass)
    {
        try {
            R resource = resourceClass.getDeclaredConstructor().newInstance();
            return resource.toArray(model);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert model to resource", e);
        }
    }

    private static <R extends Resource<?, R>> String getResourceWrapper(Class<R> resourceClass)
    {
        try {
            return (String) resourceClass.getField("resourceWrapper").get(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get resourceWrapper from class " + resourceClass.getName(), e);
        }
    }

    private static <R extends Resource<?, R>> String getCollectionWrapper(Class<R> resourceClass)
    {
        try {
            return (String) resourceClass.getField("collectionWrapper").get(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get collectionWrapper from class " + resourceClass.getName(), e);
        }
    }

    abstract public R toArray(M model);

    //protected abstract BookResource toNakedResource(Book model);
}
