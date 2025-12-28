package test.markdown;

import markdown.Lexer;
import markdown.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

  @Test
  void testHeadingLevel1() {
    String input = "# Title";

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    String html = parser.parse().toHTML();

    assertEquals("<h1>Title</h1>", html.trim());
  }

  @Test
  void testHeadingLevel2() {
    String input = "## Subtitle";

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    String html = parser.parse().toHTML();

    assertEquals("<h2>Subtitle</h2>", html.trim());
  }

  @Test
  void testParagraph() {
    String input = "This is a paragraph.";

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    String html = parser.parse().toHTML();

    assertEquals("<p>This is a paragraph.</p>", html.trim());
  }

  @Test
  void testUnorderedList() {
    String input = "- item1\n- item2";

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    String html = parser.parse().toHTML();

    assertTrue(html.contains("<ul>"));
    assertTrue(html.contains("<li>item1</li>"));
    assertTrue(html.contains("<li>item2</li>"));
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
