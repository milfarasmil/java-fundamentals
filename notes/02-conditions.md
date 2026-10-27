## Part 1B: Conditions & Decision Making

- **`if-else if-else`**: Best for checking ranges (e.g., marks >= 75).
- **Ternary Operator**: Short-hand for simple if-else.
  - Syntax: `String result = (marks >= 40) ? "Pass" : "Fail";`
- **Switch Statements**:
  - Best for exact matching of discrete values (integers, strings, enums).
  - **Old Style**: Requires `break` to prevent *fall-through*.
  - **Modern Switch (Java 14+)**: Uses arrow `->` syntax, no `break` needed, and can return values directly into variables.
  - **Example**:
    ```java
    String type = switch (day) {
        case 6, 7 -> "Weekend";
        default -> "Weekday";
    };
    ```
    - **Senior Developer Tips**:
  - **Avoid Deep Nesting**: Too many nested `if` statements make code unreadable. Use Guard Clauses instead.
  - **Switch vs If-Else**: Prefer `switch` over chained `if-else` when checking a single variable against multiple discrete values for cleaner code.