package repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T,I> implements ICrudRepository<T,I> {
    public InMemoryRepository(List<T> repoList) {
        this.repoList = repoList;
    }

    public List<T> repoList;

    public InMemoryRepository() {
        this.repoList = new ArrayList<>();
    }

    @Override
    public T create(T obj) {
        this.repoList.add(obj);
        return obj;
    }

    @Override
    public List<T> getAll() {
        return this.repoList;
    }

    @Override
    public void delete(T obj) {
        this.repoList.remove(obj);
    }




}