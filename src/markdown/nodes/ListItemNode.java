package markdown.nodes;

import markdown.ASTNode;
import markdown.InlineParser;

public class ListItemNode extends ASTNode {
  private final String text;

  public ListItemNode(String text) {
    this.text = InlineParser.parse(text);
  }

  @Override
  public String toHTML() {
    return "<li>" + text + "</li>";
  }
}
