package test.markdown;

import org.junit.jupiter.api.Test;

import markdown.Lexer;
import markdown.Parser;

import static org.junit.jupiter.api.Assertions.*;
// import java.util.*;

public class ParserTest {

  @Test
  void testHeadingParsing() {
    Lexer lexer = new Lexer("# Hello\n");
    Parser parser = new Parser(lexer.tokenize());

    var doc = parser.parse();
    assertEquals(1, doc.getChildren().size());
  }

  @Test
  void testListParsing() {
    String input = "- One\n- Two\n";
    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    var doc = parser.parse();
    assertEquals(1, doc.getChildren().size());
  }
}
