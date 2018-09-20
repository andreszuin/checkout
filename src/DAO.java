public interface DAO {
    Produto search(String nome);
    void update(Produto produto);
    void insert(Produto produto);
    void delete(Produto produto);
}
