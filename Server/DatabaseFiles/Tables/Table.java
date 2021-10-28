package Server.DatabaseFiles.Tables;

import java.util.HashMap;

// C - create, R - read, U - update, D - delete
public class Table<T> {
    private HashMap<Long, T> data;

    Table() {
        data = new HashMap<>();
    }

    public T read(Long id) {
        return data.get(id);
    }

    public void update(Long id, T entity) {
        data.replace(id, entity);
    }

    public void create(Long id, T entity) {
        data.put(id, entity);
    }

    public void delete(Long id) {
        data.remove(id);
    }
}