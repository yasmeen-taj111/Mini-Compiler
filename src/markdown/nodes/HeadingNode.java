package markdown.nodes;

import markdown.ASTNode;
import markdown.InlineParser;

public class HeadingNode extends ASTNode {
  private final int level;
  private final String text;

  public HeadingNode(int level, String text) {
    this.level = level;
    this.text = InlineParser.parse(text);
  }

  @Override
  public String toHTML() {
    return "<h" + level + ">" + text + "</h" + level + ">";
  }
}
