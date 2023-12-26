package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> db;
    private String pathToFile;

    public FileKV(String pathToFile, Map<String, String> db) {
        this.db = new HashMap<>(db);
        this.pathToFile = pathToFile;
    }

    @Override
    public void set(String key, String value) {
        db.put(key, value);
        Utils.writeFile(pathToFile, Utils.serialize(db));
    }

    @Override
    public void unset(String key) {
        db.remove(key);
        Utils.writeFile(pathToFile, Utils.serialize(db));
    }

    @Override
    public String get(String key, String defaultValue) {
        return db.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(Utils.unserialize(Utils.readFile(pathToFile)));
    }
}
// END
