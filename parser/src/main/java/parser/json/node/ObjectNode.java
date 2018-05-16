package parser.json.node;

import java.util.Map;

public class ObjectNode implements JsonNode {
    private final Map<String, JsonNode> properties;

    public ObjectNode(Map<String, JsonNode> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjectNode{");
        sb.append("properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }
}
