package com.java.version.features.java_17.records;

/**
 *
 The Three Types of Record Constructors

 Records support three constructor forms to handle initialization and validation, as outlined in the Oracle Java Documentation.
 • Canonical Constructor. This constructor has the exact same parameter list as the record's components. The compiler generates it automatically unless you explicitly define it yourself.
 • Compact Constructor. This is a shorthand way to write the canonical constructor without repeating the parameter list or field assignments. It is primarily used for validating or normalizing inputs before the fields are assigned.
 • Non-Canonical (Overloaded) Constructors. These are custom constructors with different parameter lists. They allow you to provide default values or accept alternative input types.
 *
 *
 *
 Key Rules to Remember

 • Mandatory Delegation. Overloaded constructors cannot assign fields directly using this.field = value. They must call this(...) so that any validation logic in the canonical constructor is always executed.
 • No-Argument Constructors. You can create a no-argument constructor public User() only if it calls this(...) with default values for all record components. Do not confuse public User() with the compact constructor syntax public User {}.
 • Static Factory Methods. If you need complex object creation logic before calling this(...), consider using public static factory methods instead of overloaded constructors. Static methods can run multiple statements and conditional logic before invoking new User(...)
 *
 */
public record User(String username, String role, boolean active) {

    // 1. Compact canonical constructor (validates all inputs)
    public User {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
        if (role == null) {
            role = "USER"; // Normalizes null to a default value
        }
    }

    // 2. Overloaded constructor with default values
    public User(String username) {
        // Must delegate to the canonical constructor
        this(username, "USER", true);
    }

    // 3. Overloaded constructor chaining to another constructor
    public User(String username, String role) {
        // Delegates to the canonical constructor (or another overloaded one that does)
        this(username, role, true);
    }

    /**
     * Static factory methods allow you to run complex logic, parse data, or return cached instances before calling a record's constructor. Because overloaded record constructors require this(...) to be the very first statement, static factory methods are the standard workaround when you need to execute multiple lines of code prior to object creation.
     *
     * Why Use Static Factory Methods with Records?
     *
     * • Bypassing the First-Line Rule. Overloaded constructors cannot perform multi-step transformations before calling this(...). A static method has no such restriction and can compute values first.
     * • Descriptive Naming. Unlike constructors, static methods can have clear names like of(...), from(...), or createGuest() that explain what kind of instance is being built.
     * • Same-Signature Overloads. If you need two ways to build a record using the same parameter types (such as two String inputs), static methods let you use distinct names instead of running into compiler signature conflicts.
     *
     * @param csvLine
     * @return
     */

    // 1. Factory method for multi-step parsing before construction
    public static User fromCsv(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid CSV format");
        }
        String parsedUser = parts[0].trim();
        String parsedRole = parts[1].trim().toUpperCase();

        // Invokes the canonical constructor after processing
        return new User(parsedUser, parsedRole, true);
    }

    // 2. Descriptive factory method for specific roles
    public static User createAdmin(String username) {
        return new User(username, "ADMIN", true);
    }

    // 3. Factory method avoiding signature collisions (both take a single String)
    public static User fromEmail(String email) {
        String extractedUsername = email.substring(0, email.indexOf('@'));
        return new User(extractedUsername, "USER", true);
    }
}

/**
 *
 java records with multiple constructors

 Yes, Java records can have multiple constructors. Every additional constructor must delegate directly or indirectly to the record's primary canonical constructor using this(...) on its first line.

 The Three Types of Record Constructors

 Records support three constructor forms to handle initialization and validation, as outlined in the Oracle Java Documentation.
 • Canonical Constructor. This constructor has the exact same parameter list as the record's components. The compiler generates it automatically unless you explicitly define it yourself.
 • Compact Constructor. This is a shorthand way to write the canonical constructor without repeating the parameter list or field assignments. It is primarily used for validating or normalizing inputs before the fields are assigned.
 • Non-Canonical (Overloaded) Constructors. These are custom constructors with different parameter lists. They allow you to provide default values or accept alternative input types.

 Code Example

 The following example combines a compact constructor for validation with two overloaded constructors for convenience:
 java
 public record User(String username, String role, boolean active) {

 // 1. Compact canonical constructor (validates all inputs)
 public User {
 if (username == null || username.isBlank()) {
 throw new IllegalArgumentException("Username cannot be blank");
 }
 if (role == null) {
 role = "USER"; // Normalizes null to a default value
 }
 }

 // 2. Overloaded constructor with default values
 public User(String username) {
 // Must delegate to the canonical constructor
 this(username, "USER", true);
 }

 // 3. Overloaded constructor chaining to another constructor
 public User(String username, String role) {
 // Delegates to the canonical constructor (or another overloaded one that does)
 this(username, role, true);
 }
 }
 Use code with caution.

 Key Rules to Remember

 • Mandatory Delegation. Overloaded constructors cannot assign fields directly using this.field = value. They must call this(...) so that any validation logic in the canonical constructor is always executed.
 • No-Argument Constructors. You can create a no-argument constructor public User() only if it calls this(...) with default values for all record components. Do not confuse public User() with the compact constructor syntax public User {}.
 • Static Factory Methods. If you need complex object creation logic before calling this(...), consider using public static factory methods instead of overloaded constructors. Static methods can run multiple statements and conditional logic before invoking new User(...).
 Would you like to see examples of static factory methods for complex initialization, or how constructor validation interacts with JSON deserialization libraries like Jackson?
 +5
 •
 Stack Overflow
 With the new Java 14 Record functionality, is it possible of ...
 August 26, 2020 — # 1 Answer With Java 14, records couldn't have multiple constructors (reference: Java 14 - JEP 359: Records (Preview)). As of Java...
 •
 mikemybytes.com
 Java records & compact constructors | Mike my bytes
 February 16, 2022 — # Record construction Recent versions of Java come with concise syntax for declaring records: record Mapping(String from, String t...
 •
 HappyCoders.eu
 Java Records: The Complete Guide (with Examples)
 September 1, 2026 — # Why Do We Need Records? * You can compare two points, for example, as follows: * Java Record Constructors In the previous sectio...
 Show all


 static factory methods

 Static factory methods allow you to run complex logic, parse data, or return cached instances before calling a record's constructor. Because overloaded record constructors require this(...) to be the very first statement, static factory methods are the standard workaround when you need to execute multiple lines of code prior to object creation.

 Why Use Static Factory Methods with Records?

 • Bypassing the First-Line Rule. Overloaded constructors cannot perform multi-step transformations before calling this(...). A static method has no such restriction and can compute values first.
 • Descriptive Naming. Unlike constructors, static methods can have clear names like of(...), from(...), or createGuest() that explain what kind of instance is being built.
 • Same-Signature Overloads. If you need two ways to build a record using the same parameter types (such as two String inputs), static methods let you use distinct names instead of running into compiler signature conflicts.

 Code Example

 The following example shows a User record using static factory methods to handle parsing and pre-construction logic:
 java
 public record User(String username, String role, boolean active) {

 // Compact constructor still enforces core invariants
 public User {
 if (username == null || username.isBlank()) {
 throw new IllegalArgumentException("Username cannot be blank");
 }
 if (role == null) {
 role = "USER";
 }
 }

 // 1. Factory method for multi-step parsing before construction
 public static User fromCsv(String csvLine) {
 String[] parts = csvLine.split(",");
 if (parts.length < 2) {
 throw new IllegalArgumentException("Invalid CSV format");
 }
 String parsedUser = parts[0].trim();
 String parsedRole = parts[1].trim().toUpperCase();

 // Invokes the canonical constructor after processing
 return new User(parsedUser, parsedRole, true);
 }

 // 2. Descriptive factory method for specific roles
 public static User createAdmin(String username) {
 return new User(username, "ADMIN", true);
 }

 // 3. Factory method avoiding signature collisions (both take a single String)
 public static User fromEmail(String email) {
 String extractedUsername = email.substring(0, email.indexOf('@'));
 return new User(extractedUsername, "USER", true);
 }
 }
 Use code with caution.

 Usage

 Calling static factory methods reads cleanly and keeps initialization logic contained inside the record:
 java
 User admin = User.createAdmin("alice");
 User csvUser = User.fromCsv("bob, moderator");
 User emailUser = User.fromEmail("charlie@example.com");
 Use code with caution.

 Constructors vs. Static Factory Methods


 Feature	Overloaded Constructors	Static Factory Methods
 Pre-creation Logic	Limited to single-line expressions inside this(...)	Full multi-line statements, loops, and try-catch blocks
 Naming	Fixed to the record's class name	Custom, descriptive names (e.g., of, from, parse)
 Validation	Automatically runs canonical constructor checks	Automatically runs canonical constructor checks via new
 Return Type	Always returns a brand-new instance	Can return cached instances or Optional<Record>

 Would you like to see how to make the canonical constructor private to enforce factory-only creation, or explore builder patterns for records with many fields?

 canonical constructor private

 No, you cannot make a Java record's canonical constructor private. The Java Language Specification strictly mandates that the canonical constructor must be at least as accessible as the record itself.

 Why Private Canonical Constructors Are Forbidden

 • Access Level Rule. If a record is declared public, its canonical constructor must also be public. If a record is package-private, the canonical constructor can be package-private or public, but never private or protected.
 • Design Philosophy. Records are transparent data carriers whose state is fully exposed by their components. Because anyone can read all fields via accessor methods and reconstruct an identical copy, hiding the canonical constructor goes against how records are designed to work.
 • Serialization and Reflection. Java's built-in serialization and reflection APIs rely on the canonical constructor being accessible to safely recreate record instances without bypassing validation.

 Workarounds for Factory-Only Creation

 If you strictly want to prevent external callers from invoking new Record(...) directly, you have three practical options:
 • Use a Standard final Class. Replace the record with a final class that has private final fields, getter methods, and a private constructor. This gives you complete control over instantiation at the cost of writing equals, hashCode, and toString yourself.
 • Wrap the Record in a Sealed Interface. Declare a public sealed interface that exposes the accessor methods and permit a package-private (or private nested) record implementation. External callers only see the interface and must use your static factory methods on the interface to create instances.
 • Keep the Record Package-Private. Place the record in an internal package and expose only a public factory class or interface to the rest of your application.

 Sealed Interface Example

 The sealed interface pattern lets you keep all the benefits of records while completely hiding the constructor from outside packages:
 java
 public sealed interface User permits UserImpl {
 String username();
 String role();

 // Public static factory method is the only entry point for external callers
 static User createAdmin(String username) {
 return new UserImpl(username, "ADMIN");
 }
 }

 // Package-private record cannot be instantiated outside this package
 record UserImpl(String username, String role) implements User {
 UserImpl {
 if (username == null || username.isBlank()) {
 throw new IllegalArgumentException("Username cannot be blank");
 }
 }
 }
 Use code with caution.

 Constructor Access Rules Summary


 Record Declaration	Allowed Canonical Constructor Access	Allowed Non-Canonical Constructor Access
 public record	public only	public, protected, package-private, private
 record (package-private)	public or package-private	public, protected, package-private, private
 private record (nested)	public, protected, package-private, private	public, protected, package-private, private

 Would you like to see how to implement a builder pattern for records with many fields, or how sealed interfaces and records work together for domain modeling?

 */