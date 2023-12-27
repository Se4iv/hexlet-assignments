package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    private String tagBody;
    private List<Tag> childs;

    public String getTagBody() {
        return tagBody;
    }

    public List<Tag> getChilds() {
        return childs;
    }

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody,
                     List<Tag> childs) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.childs = childs;
    }

    public String toString() {
        return super.toString() + collectChild() + getTagBody() + "</" + getTagName() + ">";
    }
    protected String collectChild() {
        String result = "";
        for (Tag x: getChilds()) {
            result = result + "<" + x.getTagName() + super.collectTag(x);
        }
        return result;
    }

}
// END
