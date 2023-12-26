package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String pathToFile;

    public FileKV(String pathToFile, Map<String, String> db) {
        this.pathToFile = pathToFile;
        db.forEach(this::set);
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(pathToFile));
        data.put(key, value);
        Utils.writeFile(pathToFile, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(pathToFile));
        data.remove(key);
        Utils.writeFile(pathToFile, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(pathToFile));
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(Utils.unserialize(Utils.readFile(pathToFile)));
    }
}
// END
