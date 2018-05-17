package parser.json.plain;


import parser.json.ParseContext;
import parser.json.node.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parser.json.ParseFailure;

//jvalue = jobject | jarray | jboolean
//       | jnull | parse | jnumber;
//jobject = '{'
//  [parse ':' jvalue {',' parse ':' jvalue}]
//'}';
//jarray = '[' [jvalue {',' jvalue}] ']';
//jboolean = 'true' | 'false';
//jnull = 'null';
//parse = '"' ... '"';
//jnumber = integer;
public class PlainJsonParser {

    private final StringParser stringParser = new StringParser();

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


    private final ParseContext context;

    public PlainJsonParser(String input) {
        this.context = new ParseContext(input);
    }

    public JsonNode parse() {
        return jvalue(context);
    }

    JsonNode jvalue(ParseContext context) {
        return context.or(
                this::jobject,
                this::jarray,
                this::jboolean,
                this::jnull,
                stringParser::parse,
                this::jnumber
        );
    }

    JsonNode jobject(ParseContext context) {
        context.literal("{");

        Map<String, JsonNode> properties = new HashMap<>();
        while(true) {
            try {
                String propertyName = ((StringNode) stringParser.parse(context)).value();

                context.literal(":");

                JsonNode jvalue = jvalue(context);
                properties.put(propertyName, jvalue);

                context.literal(",");

            } catch (ParseFailure e) {
                context.literal("}");
                return new ObjectNode(properties);
            }
        }
    }

    JsonNode jarray(ParseContext context) {
        context.literal("[");

        List<JsonNode> array = new ArrayList<>();
        while(true) {
            try {
                JsonNode jvalue = jvalue(context);
                array.add(jvalue);
                context.literal(",");
            } catch (ParseFailure e)  {
                context.literal("]");
                return new ArrayNode(array);
            }
        }
    }



    JsonNode jnull(ParseContext context) {
        context.literal("null");
        return new NullNode();
    }

    JsonNode jnumber(ParseContext context) {
        int numberEnd = context.endOfDigitIndex();
        String maybeNumber = context.fromCurrentUntilExclusive(numberEnd);
        try {
            int value = Integer.parseInt(maybeNumber);
            context.forwardChar(maybeNumber.length());
            return new NumberNode(value);
        } catch (NumberFormatException e) {
            throw new ParseFailure("not a number " + e.getMessage() + " " + context);
        }
    }

    JsonNode jboolean(ParseContext context) {
        return context.or(
                this::jbooleanTrue,
                this::jbooleanFalse
        );
    }

    private JsonNode jbooleanTrue(ParseContext context) {
        context.literal("true");
        return new BooleanNode(true);
    }

    private JsonNode jbooleanFalse(ParseContext context) {
        context.literal("false");
        return new BooleanNode(false);
    }




}
