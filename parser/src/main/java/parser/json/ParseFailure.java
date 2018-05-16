package parser.json;

public class ParseFailure extends RuntimeException {
    public ParseFailure(String message) {
        super(message);
    }
}
