package DAOS;

public interface DAO <T>{
    T get(Integer id);
    void update(T x);
    void insert(T x);
    void delete(T x);
}
