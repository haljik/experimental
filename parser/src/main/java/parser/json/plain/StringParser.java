package parser.json.plain;

import parser.json.ParseContext;
import parser.json.ParseFailure;
import parser.json.node.JsonNode;
import parser.json.node.StringNode;

public class StringParser {
    public StringParser() {
    }

    JsonNode parse(ParseContext context) {

        final String quoteSymbol = "\"";

        context.literal(quoteSymbol);

        StringBuilder buff = new StringBuilder();
        while (true) {
            context.checkEOF();


            context.save();
            try {
                context.literal("\\");
                char maybeEscaped = context.currentChar();
                context.forwardChar();
                buff.append(maybeEscaped);
            } catch (ParseFailure e) {
                context.restore();
                ;
            }

            context.save();
            try {
                context.literal(quoteSymbol);
                return new StringNode(buff.toString());
            } catch (ParseFailure e) {
                context.restore();
            }


            char partOfJString = context.currentChar();
            context.forwardChar();

            buff.append(partOfJString);
        }
    }
}
