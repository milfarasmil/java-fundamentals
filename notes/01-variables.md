# Notes

I am using this project to build Java fundamentals step by step. Each part
contains small examples that I can compile, run, and improve as I learn.


## Java Variables & Long Suffix (L)

- **`int` vs `long`**: 
  - `int` handles 32-bit integers (up to ~2.1 billion).
  - `long` handles larger 64-bit integers.
- **Why use 'L'?**: Adding `L` at the end of a number (e.g., `100000L`) explicitly tells Java that the literal is a `long` type, which is mandatory when the number exceeds the `int` limit.
- **Example**:
  ```java
  int a = 100000;      // Valid (fits in int)
  long b = 100000;     // Valid (implicitly converted to long)
  long c = 3000000000L; // Required 'L' because it exceeds int limit

  ## Quick Summary: `final` in Primitive vs Reference Types

- **Primitive (`final int x = 10;`)**: 
  - Direct value is locked. Cannot change the value itself.
- **Reference (`final int[] arr = {1, 2, 3};`)**: 
  - Address/Reference is locked (cannot point to a new object/array).
  - Internal values/elements CAN be modified (`arr[0] = 99;` is allowed).

  ## Java Scanner Issue: `nextInt()` followed by `nextLine()`

- **Problem**: `nextInt()` reads only the numeric value and leaves the `\n` (Newline character from Enter key) in the input buffer.
- **Effect**: A subsequent `nextLine()` reads this remaining `\n` immediately as an empty line, skipping user input.
- **Solution**: Call an extra `scanner.nextLine()` immediately after `nextInt()` to consume and clear the leftover `\n`.

- **Example**:
  ```java
  int age = scanner.nextInt(); // Reads number, leaves '\n' in buffer
  scanner.nextLine();          // Clears the leftover '\n' from buffer
  
  String name = scanner.nextLine(); // Successfully waits for user input

  ## Scanner vs BufferedReader: Buffer & Newline Comparison

- **`Scanner`**: 
  - Directly reads types like `int` (`nextInt()`).
  - **Issue**: Leaves the Enter (`\n`) key in the buffer, causing subsequent `nextLine()` to skip input.
  - **Fix**: Add an empty `scanner.nextLine()` to clear the buffer.

- **`BufferedReader`**: 
  - Reads input line-by-line (`readLine()`).
  - **No Issue**: Consumes the entire line including `\n`, leaving the buffer clean. Numbers must be manually parsed (e.g., `Integer.parseInt()`).

### Code Comparison

**1. Scanner (Handling the Buffer Issue):**
```java
Scanner scanner = new Scanner(System.in);

int age = scanner.nextInt();      // Reads '25', leaves '\n' in buffer
scanner.nextLine();               // Clears leftover '\n'

String name = scanner.nextLine(); // Works correctly now!

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

int age = Integer.parseInt(reader.readLine()); // Reads line and parses to int
String name = reader.readLine();                // Clean read, no buffer issues


## Why Avoid `scanner.close()` on `System.in` (Visualized)

- **The Problem**: `System.in` is a shared global resource for the entire application. Closing a Scanner tied to `System.in` permanently shuts down the keyboard stream.
- **The Risk**: If Module A closes the scanner, Module B cannot read any further user input later in the app lifecycle, causing runtime crashes.
- **Example Scenario**:
  ```java
  // Module 1
  Scanner sc1 = new Scanner(System.in);
  String name = sc1.nextLine();
  sc1.close(); // DANGER: Closes global System.in stream!

  // Module 2 (Later in app)
  Scanner sc2 = new Scanner(System.in);
  int age = sc2.nextInt(); // CRASH! System.in is already dead/closed.

  