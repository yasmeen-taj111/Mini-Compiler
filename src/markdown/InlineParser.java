package markdown;

public class InlineParser {

  public static String parse(String text) {
    if (text.contains("**") && text.split("\\*\\*").length % 2 == 0) {
      throw new CompilerException("Unmatched ** detected");
    }

    if (text.contains("*") && text.split("\\*").length % 2 == 0) {
      throw new CompilerException("Unmatched * detected");
    }

    text = text.replaceAll("\\*\\*(.*?)\\*\\*", "<strong>$1</strong>");

    text = text.replaceAll("_(.*?)_", "<em>$1</em>");

    text = text.replaceAll("\\*(.+?)\\*", "<em>$1</em>");

    return text;
  }
}
