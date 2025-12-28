# Mini Markdown → HTML Compiler (Java)

## Overview

This project implements a **Mini Markdown Compiler** using **Java**, following a **real compiler-style architecture** instead of simple string replacements.

It takes a simplified Markdown input, processes it through **lexical analysis, parsing, AST construction**, and finally generates valid **HTML output**.

The goal of this project is to help understand **how real compilers work internally**, including grammar handling, tree-based representation, and structured code generation.

---

## What is Markdown?

Markdown is a lightweight markup language used to format text using simple symbols.

### Examples

- `# Heading`
- `## Subheading`
- `**bold**`
- `_italic_`
- `- list item`
- Code blocks using triple backticks
- HTML-style comments  
  `<!-- This is a comment -->`

---

## Supported Features

### Block-Level Elements

- Headings (`#`, `##`, `###`)
- Paragraphs
- Unordered Lists (`- item`)
- Code Blocks (```)
- Comments (`<!-- comment -->`)

### Inline Elements

- Bold text (`**bold**`)
- Italic text (`_italic_`)

---

## Compiler Architecture

The compiler follows a **multi-stage pipeline**, similar to real-world compilers:

````text
Markdown Input
      ↓
Lexer (Tokenization)
      ↓
Parser (Syntax Analysis)
      ↓
AST (Abstract Syntax Tree)
      ↓
HTML Generation


## Why AST?

- Ensures **correct structure before rendering**
- Separates **syntax from presentation**
- Makes the compiler **extensible and maintainable**
- Mirrors how **real-world compilers** (like those for Java/C++) work internally

---

## Abstract Syntax Tree (AST)

Each Markdown construct is converted into a **semantic AST node** instead of directly generating HTML.

### AST Node Types

- `DocumentNode`
- `HeadingNode`
- `ParagraphNode`
- `ListNode`
- `ListItemNode`
- `CodeBlockNode`
- `CommentNode`

Each node represents a meaningful unit of the language and knows **how to generate its own HTML**.

This approach enables:
- Clean traversal of the document structure
- Accurate and predictable HTML generation
- Easy addition of new features without breaking existing code

##Project Structure
```text
MiniMarkdownCompiler/
│
├── src/
│   └── markdown/
│       ├── Main.java
│       ├── Lexer.java
│       ├── Parser.java
│       ├── InlineParser.java
│       ├── Token.java
│       ├── TokenType.java
│       ├── CompilerException.java
│       └── nodes/
│           ├── ASTNode.java
│           ├── DocumentNode.java
│           ├── HeadingNode.java
│           ├── ParagraphNode.java
│           ├── BoldNode.java
│           ├── ItalicNode.java
│           ├── ListNode.java
│           ├── ListItemNode.java
│           ├── CodeBlockNode.java
│           └── CommentNode.java
│
├── test/
│   └── markdown/
│       ├── LexerTest.java
│       ├── ParserTest.java
│       ├── InlineParserTest.java
│       ├── HtmlGenerationTest.java
│       ├── ErrorHandlingTest.java
│       ├── EdgeCaseTest.java
│       └── IntegrationTest.java
│
├── input.md
├── output.html   (auto-generated)
└── README.md

## 🧪 Testing (JUnit 5)

All tests are written using **JUnit 5** to validate correctness across the **entire compiler pipeline**, from raw Markdown input to final HTML output.

---

## 📊 Test Coverage

### 🔹 Lexer Tests (`LexerTest.java`)

These tests validate **tokenization**, ensuring raw input is correctly converted into tokens.

Covered cases:
- Correct token generation for:
  - Headings (`#`, `##`, `###`)
  - Lists (`- item`)
  - Code blocks (```)
  - Inline symbols (`**`, `*`)
  - Comments (`<!-- comment -->`)
- Handling of newlines and whitespace
- End-of-file (`EOF`) token generation

---

### 🔹 Parser Tests (`ParserTest.java`)

These tests verify **syntax analysis** and **AST construction**.

Covered cases:
- Proper creation of AST nodes
- Correct grouping of list items into a single `ListNode`
- Accurate hierarchy:
  - `DocumentNode` → child nodes
  - Headings, paragraphs, lists, code blocks
- Ensures parser skips irrelevant tokens safely

---

### 🔹 Inline Parser Tests (`InlineParserTest.java`)

Focused on **inline formatting logic**.

Covered cases:
- Bold conversion
  `**text** → <strong>text</strong>`
- Italic conversion
  `_text_ / *text* → <em>text</em>`
- Mixed inline formatting in the same line
- Detection of unmatched symbols

---

### 🔹 HTML Generation Tests (`HtmlGenerationTest.java`)

These tests validate **code generation** from AST to HTML.

Verified output for:
- **Bold**
  `**text** → <strong>text</strong>`
- *Italic*
  `_text_ → <em>text</em>`
- Unordered lists rendered inside a single `<ul>`
- Code blocks rendered as:
  ```html
  <pre><code>...</code></pre>

### 🗨️ Comments Preserved in HTML Output

The compiler preserves HTML-style comments from Markdown input and emits them unchanged in the final HTML output.

---

## 🔹 Error Handling Tests (`ErrorHandlingTest.java`)

These tests ensure the compiler fails **safely and predictably**.

### Covered Cases

- Unmatched `**` or `*`
- Unclosed code blocks
- Malformed headings
- Invalid list syntax
- Errors thrown using `CompilerException`

---

## 🔹 Edge Case Tests (`EdgeCaseTest.java`)

Focused on **robustness** against unusual or minimal inputs.

### Covered Cases

- Empty input
- Input with only whitespace
- Multiple blank lines
- Comments-only input
- Trailing newlines
- Mixed valid and invalid syntax

---

## 🔹 Integration Tests (`IntegrationTest.java`)

These tests validate the **entire pipeline end-to-end**:

```text
Markdown Input → Lexer → Parser → AST → HTML Output

## 🔹 Covered Scenarios

- Realistic Markdown files with all supported features
- Combined usage of:
  - Headings
  - Inline formatting
  - Lists
  - Code blocks
  - Comments

### Ensures

- No unexpected exceptions
- Correct final HTML output
- All components integrate correctly

---

## ⚠️ Error Handling

The compiler includes **grammar-level error handling**, such as:

- Unmatched `**` or `_`
- Invalid or malformed structures
- Unclosed code blocks
- Robust handling of whitespace and edge cases

All errors are reported using a custom `CompilerException`, making failures **explicit and debuggable**.

---

## 📚 Key Learnings

- How **lexers** and **parsers** work internally
- Why **ASTs** are critical in compiler design
- Clear separation of:
  - Tokenization
  - Syntax analysis
  - Code generation
- Writing **clean, testable Java code**
- Designing systems beyond simple string replacement
- Importance of **unit tests vs integration tests**

---

## 🚀 Future Improvements

- Ordered lists (`1. item`)
- Links and images
- Nested inline formatting
- HTML escaping for security
- Performance optimizations
- CLI flags and file-based input/output

---

## 👩‍💻 Author

**Yasmeen Taj**
B.Tech CSE
````
