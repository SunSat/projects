package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc;

import java.util.Date;
import java.util.List;

/**
 * Created by ssundar2 on 29-03-2017.
 */
public interface GeneralPersistorJdbc<T> {
    public int add(T t);
    public void edit(T t);
    public boolean delete(T t);
    public List<T> getByTrackingId(T t);
    public List<T> getByName(T t);
    public List<T> getByUserId(T t);
    public List<T> getAllByDate(T t, Date from, Date To);
    public List<T> getByColumnName(T t, String name);

}
