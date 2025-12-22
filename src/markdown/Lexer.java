package markdown;

import java.util.*;

public class Lexer {
  private final String input;
  private int pos = 0;

  public Lexer(String input) {
    this.input = input;
  }

  public List<Token> tokenize() {
    List<Token> tokens = new ArrayList<>();

    while (pos < input.length()) {

      if (input.startsWith("```", pos)) {
        tokens.add(new Token(TokenType.TRIPLE_BACKTICK, "```"));
        pos += 3;
      } else if (input.startsWith("###", pos)) {
        tokens.add(new Token(TokenType.TRIPLE_HASH, "###"));
        pos += 3;
      } else if (input.startsWith("##", pos)) {
        tokens.add(new Token(TokenType.DOUBLE_HASH, "##"));
        pos += 2;
      } else if (input.charAt(pos) == '#') {
        tokens.add(new Token(TokenType.HASH, "#"));
        pos++;
      } else if (input.startsWith("**", pos)) {
        tokens.add(new Token(TokenType.DOUBLE_STAR, "**"));
        pos += 2;
      } else if (input.charAt(pos) == '*') {
        tokens.add(new Token(TokenType.STAR, "*"));
        pos++;
      } else if (input.charAt(pos) == '-') {
        tokens.add(new Token(TokenType.LIST_MARKER, "-"));
        pos++;
      } else if (input.charAt(pos) == '\n') {
        tokens.add(new Token(TokenType.NEWLINE, "\n"));
        pos++;
      } else {
        StringBuilder sb = new StringBuilder();
        while (pos < input.length()
            && input.charAt(pos) != '\n') {
          sb.append(input.charAt(pos++));
        }
        tokens.add(new Token(TokenType.TEXT, sb.toString().trim()));
      }
    }

    tokens.add(new Token(TokenType.EOF, ""));
    return tokens;
  }
}
