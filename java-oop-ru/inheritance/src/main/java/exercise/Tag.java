package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public  class Tag {
    private String tagName;
    private Map<String, String> attributes;

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String toString() {
        return "<" + getTagName() + collectTag(this);
    }

    protected String collectTag(Tag tag) {
        if (tag.getAttributes().isEmpty()) {
            return ">";
        } else {
            return tag.getAttributes().entrySet().stream()
                    .map(x -> x.getKey() + "=\"" + x.getValue() + "\"")
                    .collect(Collectors.joining(" ", " ", ">"));
        }
    }
}
// END
