package markdown.nodes;

import markdown.ASTNode;
import markdown.InlineParser;

public class ParagraphNode extends ASTNode {
  private final String text;

  public ParagraphNode(String text) {
    this.text = InlineParser.parse(text);
  }

  @Override
  public String toHTML() {
    return "<p>" + text + "</p>";
  }

  @Override
  public void printTree(String indent) {
    System.out.println(indent + "Paragraph(\"" + text + "\")");
  }

}
