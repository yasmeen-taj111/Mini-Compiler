# Mini Markdown → HTML Compiler (Java)

## Overview

This project implements a **Mini Markdown Compiler** using **Java**.  
It converts a simplified Markdown input into HTML by following a **compiler-based approach**.

This project is designed for beginners to understand **how real compilers work internally**.

---

## What is Markdown?

Markdown is a lightweight markup language used to format text using simple symbols.

Examples:

- `# Heading`
- `**bold**`
- `_italic_`
- `- list item`
- Code blocks using triple backticks
- Comments(<!- This is a comment ->)

---

## Supported Features

- Headings (`#`, `##`, `###`)
- Bold text (`**bold**`)
- Italic text (`_italic_`)
- Paragraphs
- Unordered Lists (`- item`)
- Code Blocks (` `)
- Comments(<!- This is a comment ->)

---

## Compiler Architecture

```text
Markdown Input
      ↓
Lexer (Tokenization)
      ↓
Parser (Syntax Analysis)
      ↓
AST (Abstract Syntax Tree)
      ↓
HTML Generation
```

---

## Project Structure

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
│       └── HtmlGenerationTest.java
│
├── input.md
├── output.html   (auto-generated)
└── README.md

```

---

## Testing (JUnit 5)

All unit tests are implemented using the **JUnit 5** framework to ensure the reliability and correctness of the Markdown processing pipeline.

---

## 📊Test Coverage

The test suite provides comprehensive coverage for the following core components:

### 🔹 Lexer

- Validates accurate generation of tokens from raw input strings.

### 🔹 Parser

- Ensures the **Abstract Syntax Tree (AST)** is correctly constructed according to the defined language grammar.

### 🔹 HTML Generation

Verified output for the following Markdown elements:

- **Bold**  
  `**text**` → `<strong>text</strong>`

- _Italic_  
  `*text*` → `<em>text</em>`

- **Lists**
- **Code Blocks**

---
