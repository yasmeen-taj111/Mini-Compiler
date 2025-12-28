package markdown.nodes;

import markdown.ASTNode;
import java.util.*;

public class DocumentNode extends ASTNode {
  private final List<ASTNode> children = new ArrayList<>();

  public List<ASTNode> getChildren() {
    return children;
  }

  public void add(ASTNode node) {
    children.add(node);
  }

  @Override
  public String toHTML() {
    StringBuilder sb = new StringBuilder();
    for (ASTNode node : children) {
      sb.append(node.toHTML()).append("\n");
    }
    return sb.toString();
  }

  @Override
  public void printTree(String indent) {
    System.out.println(indent + "Document");

    for (ASTNode child : children) {
      child.printTree(indent + "  ");
    }
  }

}
