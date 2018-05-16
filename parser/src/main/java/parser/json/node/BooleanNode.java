package parser.json.node;

public class BooleanNode implements JsonNode {
    private boolean value;

    public BooleanNode(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BooleanNode{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
