package parser.json.node;

public class StringNode implements JsonNode {
    private final String value;

    public StringNode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StringNode{");
        sb.append("value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
