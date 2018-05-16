package parser.json.node;

public class NullNode implements JsonNode {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NullNode{");
        sb.append('}');
        return sb.toString();
    }
}
