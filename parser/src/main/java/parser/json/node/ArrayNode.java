package parser.json.node;

import java.util.List;

public class ArrayNode implements JsonNode {
    private List<JsonNode> array;

    public ArrayNode(List<JsonNode> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayNode{");
        sb.append("array=").append(array);
        sb.append('}');
        return sb.toString();
    }
}
