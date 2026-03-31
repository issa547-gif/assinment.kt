
// ============================================================
// SECTION 1: Variables & Data Types
// ============================================================

// Task 1.1: Student record variables
var studentName = "Issa Lemah"          // mutable
val studentId = 129608                  // immutable
var gpa = 4.89                           // mutable
val isEnrolled = true                    // immutable
val middleInitial = 'Y'                  // immutable

// Task 1.2: String template output
fun task1_2() {
    // String template combining all student fields
    println("Student: $studentName $middleInitial. (ID: $studentId) has GPA $gpa and is enrolled: $isEnrolled")
}

// Task 1.3: Nullable variable with safe print
fun task1_3() {
    var phoneNumber: String? = null
    // Safe print using Elvis operator: prints null if phoneNumber is null
    println("Phone: ${phoneNumber ?: "null"}")
}


// ============================================================
// SECTION 2: Functions
// ============================================================

// Task 2.1: Non-parameterized function that displays a menu
fun displayMenu() {
    println("=== MENU ===")
    println("1. View Profile")
    println("2. Edit Settings")
    println("3. Logout")
    println("============")
}

// Task 2.2: Calculates the price after applying a discount percentage
fun calculateDiscount(price: Double, discountPercent: Double): Double {
    return price - (price * discountPercent / 100)
}

// Task 2.3: Returns a letter grade based on a numeric score
fun getGrade(score: Int): String {
    return when {
        score in 80..100 -> "A"
        score in 65..79  -> "B"
        score in 50..64  -> "C"
        score in 35..49  -> "D"
        else             -> "F"
    }
}

// Task 2.4: Single-expression function — returns true if number is even
fun isEven(number: Int): Boolean = number % 2 == 0


// ============================================================
// SECTION 3: Conditional Statements
// ============================================================

// Task 3.1: if-else chain for temperature categories
fun task3_1() {
    val temperatures = listOf(35, 25, 15)
    for (temperature in temperatures) {
        if (temperature > 30) {
            println("$temperature°C → Hot day")
        } else if (temperature in 20..30) {
            println("$temperature°C → Perfect weather")
        } else {
            println("$temperature°C → Cool day")
        }
    }
}

// Task 3.2: when expression replacing an if-else chain for days of week
fun task3_2() {
    val dayOfWeek = "Monday"
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("Weekend! Time to relax")
        "Monday"             -> println("Back to work")
        "Friday"             -> println("TGIF!")
        else                 -> println("Regular weekday")
    }
}

// Task 3.3: when expression assigning a value to a variable
fun task3_3() {
    val trafficLight = "RED"
    val trafficAction = when (trafficLight) {
        "RED"    -> "STOP"
        "YELLOW" -> "CAUTION"
        "GREEN"  -> "GO"
        else     -> "INVALID"
    }
    println("Traffic light is $trafficLight → $trafficAction")
}


// ============================================================
// SECTION 4: Loops
// ============================================================

// Task 4.1: while loop printing 1 to 10
fun task4_1() {
    var i = 1
    while (i <= 10) {
        println(i)
        i++
    }
}

// Task 4.2: do-while countdown from 5 to 1
fun task4_2() {
    var count = 5
    do {
        println("Countdown: $count")
        count--
    } while (count >= 1)
    println("Blast off!")
}

// Task 4.3: for-in loop with index over a shopping list
fun task4_3() {
    val shoppingList = listOf("Milk", "Eggs", "Bread", "Butter", "Coffee")
    // forEachIndexed gives us both the 0-based index and the item
    shoppingList.forEachIndexed { index, item ->
        println("[${index + 1}] $item")   // display as 1-based index
    }
}

// Task 4.4: Range-based loops
fun task4_4() {
    // All numbers 1 to 20 inclusive
    println("1 to 20 inclusive:")
    for (n in 1..20) print("$n ")
    println()

    // 1 to 20 excluding 20 (until stops before the end)
    println("1 to 20 excluding 20:")
    for (n in 1 until 20) print("$n ")
    println()

    // Even numbers 2 to 20 using step
    println("Even numbers 2 to 20:")
    for (n in 2..20 step 2) print("$n ")
    println()

    // Letters A to Z
    println("Letters A to Z:")
    for (ch in 'A'..'Z') print("$ch ")
    println()
}


// ============================================================
// SECTION 5: Statements vs Expressions
// ============================================================

/*
 * Task 5.1 — Explanation (answer in comments):
 *
 * A STATEMENT performs an action but does not produce a value.
 *   Example:  println("Hello")
 *   This prints to the console but the line itself has no value you can store.
 *
 * An EXPRESSION evaluates to a value that can be stored or used elsewhere.
 *   Example:  val result = 3 + 5
 *   The expression "3 + 5" evaluates to 8, which is then stored in result.
 *
 * Key difference: if you can assign it to a variable, it's an expression.
 */

// Task 5.2: Convert the if-else statement into an if-else expression
fun task5_2() {
    val age = 20
    // The entire if-else is now an expression whose value is assigned directly
    val status = if (age >= 18) "Adult" else "Minor"
    println("Age $age → $status")
}

// Task 5.3: if-else expression to find the larger of two numbers
fun task5_3() {
    val a = 42
    val b = 77
    val maxNumber = if (a > b) a else b
    println("Max of $a and $b is $maxNumber")
}


// ============================================================
// SECTION 6: Integration Challenge — Student Management System
// ============================================================

val students = listOf(
    "Musa"   to 85,
    "phil"     to 42,
    "Abdi" to 67,
    "Issa"   to 91,
    "Lemah"   to 38
)

// 1. Print all students and their scores
fun displayAllStudents() {
    println("--- All Students ---")
    for ((name, score) in students) {
        println("$name: $score")
    }
}

// 2. Return the average score across all students
fun getAverageScore(): Double {
    val total = students.sumOf { it.second }   // sum of all scores
    return total.toDouble() / students.size
}

// 3. Return the name of the student with the highest score
fun findTopStudent(): String {
    // maxByOrNull returns the pair with the largest second value
    return students.maxByOrNull { it.second }?.first ?: "No students"
}

// 4. Print each student's name, score, and grade
fun classifyStudents() {
    println("--- Student Classifications ---")
    for ((name, score) in students) {
        val grade = getGrade(score)
        println("Name: $name, Score: $score, Grade: $grade")
    }
}


// ============================================================
// BONUS: Simple Calculator
// ============================================================

fun calculator() {
    println("\n=== Simple Calculator ===")
    print("Enter first number: ")
    val a = readln().toDoubleOrNull() ?: run {
        println("Invalid number."); return
    }

    print("Enter second number: ")
    val b = readln().toDoubleOrNull() ?: run {
        println("Invalid number."); return
    }

    print("Enter operation (+, -, *, /): ")
    val op = readln().trim()

    val result = when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> if (b == 0.0) {
            println("Error: Division by zero is not allowed.")
            return
        } else a / b
        else -> {
            println("Error: Unknown operation '$op'.")
            return
        }
    }

    println("$a $op $b = $result")
}


// ============================================================
// MAIN — Demonstrates all tasks
// ============================================================

fun main() {

    // ---- Section 1 ----
    println("========== SECTION 1 ==========")
    task1_2()
    task1_3()

    // ---- Section 2 ----
    println("\n========== SECTION 2 ==========")
    displayMenu()
    println("Discounted price: ${calculateDiscount(200.0, 15.0)}")
    println("Grade for 85: ${getGrade(85)}")
    println("Grade for 50: ${getGrade(50)}")
    println("Grade for 20: ${getGrade(20)}")
    println("Is 4 even? ${isEven(4)}")
    println("Is 7 even? ${isEven(7)}")

    // ---- Section 3 ----
    println("\n========== SECTION 3 ==========")
    task3_1()
    task3_2()
    task3_3()

    // ---- Section 4 ----
    println("\n========== SECTION 4 ==========")
    println("-- while: 1 to 10 --")
    task4_1()
    println("-- do-while: countdown --")
    task4_2()
    println("-- for-in: shopping list --")
    task4_3()
    println("-- ranges --")
    task4_4()

    // ---- Section 5 ----
    println("\n========== SECTION 5 ==========")
    task5_2()
    task5_3()

    // ---- Section 6 ----
    println("\n========== SECTION 6 ==========")
    displayAllStudents()
    println("Average Score: ${"%.2f".format(getAverageScore())}")
    println("Top Student: ${findTopStudent()}")
    classifyStudents()

    // ---- Bonus ----
    // Uncomment the line below to run the interactive calculator
    // calculator()
}