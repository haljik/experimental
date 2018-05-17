package parser.json.plain;public class StringParser{	public StringParser()	{	}parser.json.node.JsonNode jstring(parser.json.ParseContext context) {

        final java.lang.String quoteSymbol = "\"";

        context.literal(quoteSymbol);

        java.lang.StringBuilder buff = new java.lang.StringBuilder();
        while (true) {
            context.checkEOF();


            context.save();
            try {
                context.literal("\\");
                char maybeEscaped = context.currentChar();
                context.forwardChar();
                buff.append(maybeEscaped);
            } catch (parser.json.ParseFailure e) {
                context.restore();
                ;
            }

            context.save();
            try {
                context.literal(quoteSymbol);
                return new parser.json.node.StringNode(buff.toString());
            } catch (parser.json.ParseFailure e) {
                context.restore();
            }


            char partOfJString = context.currentChar();
            context.forwardChar();

            buff.append(partOfJString);
        }
    }}
