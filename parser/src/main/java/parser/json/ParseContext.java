package parser.json;

import parser.json.node.JsonNode;
import parser.json.plain.PlainJsonParser;

import java.util.function.Function;

public class ParseContext {
    public final String inputText;
    private int savedPosition;
    private int position;

    public ParseContext(String inputText) {
        this.inputText = inputText;
        this.position = 0;
    }

    public void save() {
        this.savedPosition = position;
    }

    public void restore() {
        this.position = this.savedPosition;
    }

    public char currentChar() {
        if (inputText.length() < position) {
            throw new ParseFailure("unexpected EOF " + this);
        }
        return inputText.charAt(position);
    }

    public String trunk(int length) {
        int endExclusveIndex = position + length;
        if (inputText.length() < endExclusveIndex) {
            return inputText.substring(position);
        }

        return inputText.substring(position, endExclusveIndex);
    }

    public void literal(String expected) {
        String actual = trunk(expected.length());
        if (!actual.equals(expected)) {
            throw new ParseFailure(String.format("expected %s but %s %s", expected, actual, this));
        }
        position += expected.length();
    }

    public int endOfDigitIndex() {
        for (int i = position; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if ('0' <= c && c <= '9') continue;
            return i;
        }
        return inputText.length();
    }

    public void checkEOF() {
        if (inputText.length() <= position) {
            throw new ParseFailure("unexpected EOF " + this.toString());
        }
    }

    public JsonNode or(Function<ParseContext, JsonNode>... parsers) {
        for (Function<ParseContext, JsonNode> parser : parsers) {
            int savePoint = position;
            try {
                return parser.apply(this);
            } catch (ParseFailure pe) {
                position = savePoint;
            }
        }
        throw new ParseFailure("unexpected EOF " + this.toString());
    }

    public void forwardChar() {
        position++;
    }

    public void forwardChar(int length) {
        position += length;
    }

    public boolean isCurrentPosition(int position) {
        return this.position == position;
    }

    public String fromCurrentUntilExclusive(int endExclusive) {
        if (isCurrentPosition(endExclusive)) {
            throw new ParseFailure("expected some but empty");
        }
        return this.inputText.substring(position, endExclusive);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParseContext{");
        sb.append("inputText='").append(inputText).append('\'');
        sb.append(", savedPosition=").append(savedPosition);
        sb.append(", position=").append(position);
        sb.append('}');
        return sb.toString();
    }
}
