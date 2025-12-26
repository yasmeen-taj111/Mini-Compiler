package markdown;

public class InlineParser {

  public static String parse(String text) {
    StringBuilder result = new StringBuilder();
    int i = 0;

    while (i < text.length()) {

      // BOLD: **text**
      if (i + 1 < text.length() && text.charAt(i) == '*' && text.charAt(i + 1) == '*') {
        int end = text.indexOf("**", i + 2);
        if (end == -1) {
          throw new CompilerException("Unmatched ** detected");
        }
        String boldText = text.substring(i + 2, end);
        result.append("<strong>").append(boldText).append("</strong>");
        i = end + 2;
      }

      // ITALIC: *text*
      else if (text.charAt(i) == '*') {
        int end = text.indexOf("*", i + 1);
        if (end == -1) {
          throw new CompilerException("Unmatched * detected");
        }
        String italicText = text.substring(i + 1, end);
        result.append("<em>").append(italicText).append("</em>");
        i = end + 1;
      }

      // NORMAL TEXT
      else {
        result.append(text.charAt(i));
        i++;
      }
    }

    return result.toString();
  }
}
