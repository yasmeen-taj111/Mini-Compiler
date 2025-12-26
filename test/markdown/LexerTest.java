package test.markdown;

import org.junit.jupiter.api.Test;

import markdown.Lexer;
import markdown.Token;
import markdown.TokenType;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LexerTest {

  @Test
  void testHeadingTokenization() {
    Lexer lexer = new Lexer("# Title");
    List<Token> tokens = lexer.tokenize();

    assertEquals(TokenType.HASH, tokens.get(0).type);
    assertEquals("Title", tokens.get(1).value);
  }

  @Test
  void testCommentToken() {
    Lexer lexer = new Lexer("<!-- test comment -->");
    List<Token> tokens = lexer.tokenize();

    assertEquals(TokenType.COMMENT, tokens.get(0).type);
    assertEquals("<!-- test comment -->", tokens.get(0).value);
  }
}
