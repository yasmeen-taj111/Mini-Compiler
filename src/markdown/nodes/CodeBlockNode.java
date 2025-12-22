package markdown.nodes;

import markdown.ASTNode;

public class CodeBlockNode extends ASTNode {
  private final String code;

  public CodeBlockNode(String code) {
    this.code = code;
  }

  @Override
  public String toHTML() {
    return "<pre><code>" + code + "</code></pre>";
  }
}
