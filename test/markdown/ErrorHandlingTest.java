package test.markdown;

import markdown.Lexer;
import markdown.Parser;
import markdown.CompilerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorHandlingTest {

  @Test
  void testUnclosedCodeBlock() {
    String input = "```\ncode";

    CompilerException ex = assertThrows(
        CompilerException.class,
        () -> {
          Lexer lexer = new Lexer(input);
          Parser parser = new Parser(lexer.tokenize());
          parser.parse();
        });

    assertTrue(ex.getMessage().toLowerCase().contains("code"));
  }

  @Test
  void testInvalidHeading() {
    String input = "####### too many hashes";

    CompilerException ex = assertThrows(
        CompilerException.class,
        () -> {
          Lexer lexer = new Lexer(input);
          Parser parser = new Parser(lexer.tokenize());
          parser.parse();
        });

    assertNotNull(ex);
  }

  @Test
  void testEmptyListItem() {
    String input = "- ";

    CompilerException ex = assertThrows(
        CompilerException.class,
        () -> {
          Lexer lexer = new Lexer(input);
          Parser parser = new Parser(lexer.tokenize());
          parser.parse();
        });

    assertNotNull(ex);
  }
}
