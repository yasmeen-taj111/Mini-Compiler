package test.markdown;

import org.junit.jupiter.api.Test;

import markdown.Lexer;
import markdown.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class HtmlGenerationTest {

  @Test
  void testBoldAndItalic() {
    String input = "This is **bold** and *italic*\n";

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    String html = parser.parse().toHTML();

    assertTrue(html.contains("<strong>bold</strong>"));
    assertTrue(html.contains("<em>italic</em>"));
  }

  @Test
  void testCodeBlock() {
    String input = "```\nSystem.out.println(\"Hi\");\n```";

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    String html = parser.parse().toHTML();

    assertTrue(html.contains("<pre><code>"));
    assertTrue(html.contains("System.out.println"));
  }
}
