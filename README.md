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

---

## Supported Features

- Headings (`#`, `##`, `###`)
- Bold text (`**bold**`)
- Italic text (`_italic_`)
- Paragraphs
- Unordered Lists (`- item`)
- Code Blocks (` `)

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
│       ├── ASTNode.java
│       └── nodes/
│           ├── DocumentNode.java
│           ├── HeadingNode.java
│           ├── ParagraphNode.java
│           ├── ListNode.java
│           ├── ListItemNode.java
│           └── CodeBlockNode.java
│
├── input.md
├── output.html   (auto-generated)
└── README.md
```
