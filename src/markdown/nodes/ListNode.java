package markdown.nodes;

import markdown.ASTNode;

public class ListNode extends ASTNode {

  @Override
  public String toHTML() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>\n");

    for (ASTNode item : children) {
      sb.append("  ").append(item.toHTML()).append("\n");
    }

    sb.append("</ul>\n");
    return sb.toString();
  }

}
