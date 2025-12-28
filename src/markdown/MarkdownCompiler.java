package markdown;

public class MarkdownCompiler {

  public static String compile(String input) {
    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());
    return parser.parse().toHTML();
  }
}
