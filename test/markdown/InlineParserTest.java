package test.markdown;

import markdown.InlineParser;
import markdown.CompilerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InlineParserTest {

  @Test
  void testPlainText() {
    assertEquals("hello world", InlineParser.parse("hello world"));
  }

  @Test
  void testBoldText() {
    assertEquals(
        "<strong>bold</strong>",
        InlineParser.parse("**bold**"));
  }

  @Test
  void testItalicWithStar() {
    assertEquals(
        "<em>italic</em>",
        InlineParser.parse("*italic*"));
  }

  @Test
  void testItalicWithUnderscore() {
    assertEquals(
        "<em>italic</em>",
        InlineParser.parse("_italic_"));
  }

  @Test
  void testBoldInsideSentence() {
    assertEquals(
        "this is <strong>bold</strong> text",
        InlineParser.parse("this is **bold** text"));
  }

  @Test
  void testItalicInsideSentence() {
    assertEquals(
        "this is <em>italic</em> text",
        InlineParser.parse("this is *italic* text"));
  }

  @Test
  void testMixedBoldAndItalic() {
    assertEquals(
        "<strong>bold</strong> and <em>italic</em>",
        InlineParser.parse("**bold** and *italic*"));
  }

  @Test
  void testMultipleInlineFormats() {
    assertEquals(
        "<strong>a</strong> <em>b</em> <strong>c</strong>",
        InlineParser.parse("**a** *b* **c**"));
  }

  @Test
  void testUnmatchedBoldThrowsException() {
    CompilerException ex = assertThrows(
        CompilerException.class,
        () -> InlineParser.parse("**bold"));
    assertTrue(ex.getMessage().contains("Unmatched"));
  }

  @Test
  void testUnmatchedItalicThrowsException() {
    CompilerException ex = assertThrows(
        CompilerException.class,
        () -> InlineParser.parse("*italic"));
    assertTrue(ex.getMessage().contains("Unmatched"));
  }
}
