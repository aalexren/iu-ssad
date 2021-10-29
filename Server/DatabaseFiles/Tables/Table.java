package Server.DatabaseFiles.Tables;

import java.util.HashMap;

// C - create, R - read, U - update, D - delete
public class Table<K, V> {
    private HashMap<K, V> data;

    Table() {
        data = new HashMap<>();
    }

    public V read(K id) {
        return data.get(id);
    }

    public V update(K id, V entity) {
        return data.replace(id, entity);
    }

    public void create(K id, V entity) {
        data.put(id, entity);
    }

    public void delete(K id) {
        data.remove(id);
    }
}