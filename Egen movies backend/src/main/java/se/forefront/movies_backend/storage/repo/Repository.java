package se.forefront.movies_backend.storage.repo;

public interface Repository<T> {

    void add(T t);
    void delete(String id);
    void update(String id, T t);
    T get(String id);

}
