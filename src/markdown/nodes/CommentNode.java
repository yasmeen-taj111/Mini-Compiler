package markdown.nodes;

import markdown.ASTNode;

public class CommentNode extends ASTNode {

  private final String comment;

  public CommentNode(String comment) {
    this.comment = comment;
  }

  @Override
  public String toHTML() {
    return comment;
  }

  @Override
  public void printTree(String indent) {
    System.out.println(indent + "Comment(\"" + comment + "\")");
  }

}
