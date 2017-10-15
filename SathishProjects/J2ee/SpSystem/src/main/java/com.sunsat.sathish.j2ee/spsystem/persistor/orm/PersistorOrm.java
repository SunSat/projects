package com.sunsat.sathish.j2ee.spsystem.persistor.orm;

/**
 * Created by ssundar2 on 29-03-2017.
 */
public interface PersistorOrm<T> {
    public int save(T t);
    public void update(T t);
    public boolean delete(T t);
    public T findObject(String id);
}
