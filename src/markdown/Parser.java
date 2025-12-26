package markdown;

import markdown.nodes.*;
import java.util.*;

public class Parser {

  private final List<Token> tokens;
  private int pos = 0;

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
  }

  private Token peek() {
    return tokens.get(pos);
  }

  private Token consume() {
    return tokens.get(pos++);
  }

  public DocumentNode parse() {
    DocumentNode doc = new DocumentNode();

    while (peek().type != TokenType.EOF) {

      switch (peek().type) {

        case HASH:
        case DOUBLE_HASH:
        case TRIPLE_HASH:
          doc.add(parseHeading());
          break;

        case LIST_MARKER:
          doc.add(parseList());
          break;

        case TRIPLE_BACKTICK:
          doc.add(parseCodeBlock());
          break;

        case TEXT:
          doc.add(new ParagraphNode(consume().value));
          break;
        case COMMENT:
          doc.add(new CommentNode(consume().value));
          break;

        default:
          consume();
      }
    }
    return doc;
  }

  private HeadingNode parseHeading() {
    Token t = consume();
    int level = t.type == TokenType.HASH ? 1 : t.type == TokenType.DOUBLE_HASH ? 2 : 3;

    if (peek().type != TokenType.TEXT) {
      throw new CompilerException("Malformed heading");
    }

    return new HeadingNode(level, consume().value);
  }

  private ListNode parseList() {
    ListNode list = new ListNode();

    while (peek().type == TokenType.LIST_MARKER) {
      consume(); // '-'
      list.add(new ListItemNode(consume().value));

      if (peek().type == TokenType.NEWLINE) {
        consume();
      }
    }

    return list;
  }

  private CodeBlockNode parseCodeBlock() {
    consume();

    StringBuilder sb = new StringBuilder();

    while (peek().type != TokenType.TRIPLE_BACKTICK) {
      if (peek().type == TokenType.EOF) {
        throw new CompilerException("Unclosed code block");
      }

      sb.append(consume().value);
    }

    consume();

    return new CodeBlockNode(sb.toString().strip());
  }

}
