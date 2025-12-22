package markdown;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {
  protected List<ASTNode> children = new ArrayList<>();

  public void add(ASTNode node) {
    children.add(node);
  }

  public abstract String toHTML();

  public String toHtml() {
    throw new UnsupportedOperationException("Unimplemented method 'toHtml'");
  }
}
