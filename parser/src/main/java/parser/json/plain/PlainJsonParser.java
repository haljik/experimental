package parser.json.plain;


import parser.json.node.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import parser.json.ParseFailure;

//jvalue = jobject | jarray | jboolean
//       | jnull | jstring | jnumber;
//jobject = '{'
//  [jstring ':' jvalue {',' jstring ':' jvalue}]
//'}';
//jarray = '[' [jvalue {',' jvalue}] ']';
//jboolean = 'true' | 'false';
//jnull = 'null';
//jstring = '"' ... '"';
//jnumber = integer;
public class PlainJsonParser {

    public static void main(String...args) {
        System.out.println(new PlainJsonParser("\"Java\"").parse());
        System.out.println(new PlainJsonParser("1000234335").parse());
        System.out.println(new PlainJsonParser("true").parse());
        System.out.println(new PlainJsonParser("false").parse());
        System.out.println(new PlainJsonParser("null").parse());
        System.out.println(new PlainJsonParser("[null,1,true,false]").parse());
        System.out.println(new PlainJsonParser("[{\"name\":\"haljik\",\"number\":1},null,1,true,false]").parse());
        System.out.println(new PlainJsonParser("[null,1,true,false,{\"name\":\"haljik\",\"number\":1}]").parse());
        System.out.println(new PlainJsonParser("{\"name\":\"haljik\",\"number\":1}").parse());
        System.out.println(new PlainJsonParser("{\"name\":\"haljik\",\"number\":{\"name\":\"haljik\",\"number\":1}}").parse());
        System.out.println(new PlainJsonParser("{\"name\":\"haljik\",\"number\":[null,1,true,false,{\"name\":\"haljik\",\"number\":1}]}").parse());
    }

    private final String input;
    private int position = 0;

    public PlainJsonParser(String input) {
        this.input = input;
    }

    public JsonNode parse() {
        return jvalue();
    }

    JsonNode or(Supplier<JsonNode>... parsers) {
        for (Supplier<JsonNode> parser : parsers) {
            int savePoint = this.position;
            try {
                return parser.get();
            } catch (ParseFailure pe) {
                this.position = savePoint;
            }
        }
        throw new ParseFailure("unexpected EOF");
    }

    JsonNode jstring() {
        final String quoteSymbol = "\"";

        literal(quoteSymbol);

        StringBuilder buff = new StringBuilder();
        while (position < input.length()) {
            String escapeChar = "\\";

            int savePoint = this.position;
            try {
                literal(escapeChar);
                buff.append(escapeChar);
                char maybeEscaped = currentChar();
                this.position++;
                buff.append(maybeEscaped);
            } catch(ParseFailure e) {
                this.position = savePoint;
            }



            char maybeElement = currentChar();
            if (maybeElement == quoteSymbol.charAt(0)) {
                this.position++;
                return new StringNode(buff.toString());
            }

            buff.append(maybeElement);
            this.position++;
        }

        throw new ParseFailure("unexpected EOF");
    }

    JsonNode jnull() {
        literal("null");
        return new NullNode();
    }

    JsonNode jnumber() {
        int numberEnd = endOfNumberIndex();
        if (position == numberEnd) {
            throw new ParseFailure("expected digit but empty");
        }
        String substring = input.substring(position, numberEnd);
        try {
            int value = Integer.parseInt(substring);
            position += substring.length();
            return new NumberNode(value);
        } catch (NumberFormatException e) {
            throw new ParseFailure("not a number " + e.getMessage());
        }
    }

    JsonNode jboolean() {
        return or(this::jbooleanTrue, this::jbooleanFalse);
    }

    JsonNode jarray() {
        literal("[");

        List<JsonNode> array = new ArrayList<>();
        while(true) {
            try {
                JsonNode jvalue = jvalue();
                array.add(jvalue);
                literal(",");
            } catch (ParseFailure e)  {
                literal("]");
                return new ArrayNode(array);
            }
        }
    }

    JsonNode jobject() {
        literal("{");

        Map<String, JsonNode> properties = new HashMap<>();
        while(true) {
            try {
                String propertyName = ((StringNode)jstring()).value();

                literal(":");

                JsonNode jvalue = jvalue();
                properties.put(propertyName, jvalue);

                literal(",");

            } catch (ParseFailure e) {
                literal("}");
                return new ObjectNode(properties);
            }
        }

    }

    JsonNode jvalue() {
        return or(
                this::jobject,
                this::jarray,
                this::jboolean,
                this::jnull,
                this::jstring,
                this::jnumber
        );
    }

    int endOfNumberIndex() {
        for (int i = position; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('0' <= c && c <= '9') continue;
            return i;
        }
        return input.length();
    }

    private JsonNode jbooleanTrue() {
        literal("true");
        return new BooleanNode(true);
    }

    private JsonNode jbooleanFalse() {
        literal("false");
        return new BooleanNode(false);
    }

    private void literal(String expected) {
        String actual = trunk(expected.length());
        if (!actual.equals(expected)) {
            throw new ParseFailure(String.format("expected %s but %s", expected, actual));
        }
        position += expected.length();
    }

    private String trunk(int length) {
        int endExclusveIndex = position + length;
        if (input.length() < endExclusveIndex) {
            return input.substring(position);
        }

        return input.substring(position, endExclusveIndex);
    }

    private char currentChar() {
        if (input.length() < position) {
            throw new ParseFailure("unexpected EOF");
        }
        return input.charAt(position);
    }


}
