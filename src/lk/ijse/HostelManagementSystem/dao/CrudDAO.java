package lk.ijse.HostelManagementSystem.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    List<T> loadAll();
    T getObject(String id) throws Exception;
}
