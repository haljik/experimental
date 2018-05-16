package parser.json.node;

public class NumberNode implements JsonNode {
    final int value;

    public NumberNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NumberNode{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
