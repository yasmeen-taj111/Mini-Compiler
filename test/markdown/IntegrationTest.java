package test.markdown;

import markdown.MarkdownCompiler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

  @Test
  void testFullMarkdownDocument() {

    String input = "# Title\n\n" +
        "This is **bold** and _italic_.\n\n" +
        "- item1\n" +
        "- item2\n\n" +
        "```\ncode\n```";

    String html = MarkdownCompiler.compile(input);

    assertTrue(html.contains("<h1>Title</h1>"));
    assertTrue(html.contains("<strong>bold</strong>"));
    assertTrue(html.contains("<em>italic</em>"));
    assertTrue(html.contains("<ul>"));
    assertTrue(html.contains("<pre><code>"));
  }
}
