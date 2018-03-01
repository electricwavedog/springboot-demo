package com.example.test.service.cache;

/**
 * @author liuyiqian
 */
public interface CacheService {

    void saveString(String key, String value);

    String getString(String key);

    void saveObject(Object key, Object obj);

    Object getObject(Object key);
}
