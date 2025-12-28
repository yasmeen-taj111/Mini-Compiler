package test.markdown;

import markdown.Lexer;
import markdown.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EdgeCaseTest {

  private String compile(String input) {
    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());
    return parser.parse().toHTML();
  }

  @Test
  void testEmptyInput() {
    String html = compile("");
    assertEquals("", html.trim());
  }

  @Test
  void testOnlyWhitespace() {
    String html = compile("   ");
    assertEquals("", html.trim());
  }

  @Test
  void testOnlySymbols() {
    String html = compile("****");
    // should not crash
    assertNotNull(html);
  }

  @Test
  void testLargeInput() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 1000; i++) {
      sb.append("Line ").append(i).append("\n");
    }

    String html = compile(sb.toString());
    assertTrue(html.length() > 1000);
  }

  @Test
  void testNewLinesHandling() {
    String input = "Line1\n\nLine2";
    String html = compile(input);

    assertTrue(html.contains("Line1"));
    assertTrue(html.contains("Line2"));
  }
}
