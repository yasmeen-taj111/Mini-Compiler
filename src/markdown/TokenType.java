package markdown;

public enum TokenType {
  HASH, DOUBLE_HASH, TRIPLE_HASH,
  LIST_MARKER,
  DOUBLE_STAR, STAR,
  TRIPLE_BACKTICK,
  TEXT,
  NEWLINE,
  EOF
}
