package ra.repository;

import java.util.List;

public interface IShop<T> {
    void save(T t);
    void delete(T t);
    List<T> findAll();
    T findById(int id);
    int findByindex(int id);
}
