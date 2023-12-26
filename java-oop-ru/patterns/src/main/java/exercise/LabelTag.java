package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private TagInterface tag;
    private String textValue;

    public LabelTag(String textValue, TagInterface tag) {
        this.tag = tag;
        this.textValue = textValue;
    }

    @Override
    public String render() {
        return "<label>" + textValue + tag.render() + "</label>";
    }
}
// END
