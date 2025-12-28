package markdown;

import markdown.nodes.DocumentNode;
import java.nio.file.*;
// import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {

    String input = Files.readString(Path.of("input.md"));

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer.tokenize());

    DocumentNode ast = parser.parse();
    String html = ast.toHTML();

    Files.writeString(Path.of("output.html"), html);
    System.out.println("HTML generated successfully");

    System.out.println("=== AST TREE ===");
    ast.printTree("");
  }
}
