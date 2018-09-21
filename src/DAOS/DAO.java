package DAOS;

public interface DAO {
    Object search(Integer id);
    void update(Object x);
    void insert(Object x);
    void delete(Object x);
}
