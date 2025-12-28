package markdown.nodes;

import markdown.ASTNode;

public class ListNode extends ASTNode {

  @Override
  public String toHTML() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>\n");

    for (ASTNode child : children) {
      sb.append("  ").append(child.toHTML()).append("\n");
    }

    sb.append("</ul>\n");
    return sb.toString();
  }

  @Override
  public void printTree(String indent) {
    System.out.println(indent + "List");

    for (ASTNode child : children) {
      child.printTree(indent + "  ");
    }
  }
}
