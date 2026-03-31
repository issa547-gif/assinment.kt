
var studentName = "Issa Lemah"
val studentId = 129608
var gpa = 4.89
val isEnrolled = true
val middleInitial = 'Y'

fun firstTask() {
    println("Student: $studentName $middleInitial. (ID: $studentId) has GPA $gpa and is enrolled: $isEnrolled")
}

fun secondTask() {
    var phoneNumber: String? = null
    // Safe access: prints "null" if phoneNumber is null
    println("Phone: ${phoneNumber ?: "null"}")
}


fun displayMenu() {
    println("=== MENU ===")
    println("1. View Profile")
    println("2. Edit Settings")
    println("3. Logout")
    println("============")
}

fun calculateDiscount(price: Double, discountPercent: Double): Double {
    return price - (price * discountPercent / 100)
}

fun getGrade(score: Int): String {
    return when {
        score in 80..100 -> "A"
        score in 65..79  -> "B"
        score in 50..64  -> "C"
        score in 35..49  -> "D"
        else             -> "F"
    }
}

fun isEven(number: Int): Boolean = number % 2 == 0


fun thirdTask() {
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

fun fourthTask() {
    val dayOfWeek = "Monday"
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("Weekend! Time to relax")
        "Monday"             -> println("Back to work")
        "Friday"             -> println("TGIF!")
        else                 -> println("Regular weekday")
    }
}

fun fifthTask() {
    val trafficLight = "RED"
    val trafficAction = when (trafficLight) {
        "RED"    -> "STOP"
        "YELLOW" -> "CAUTION"
        "GREEN"  -> "GO"
        else     -> "INVALID"
    }
    println("Traffic light is $trafficLight → $trafficAction") // ✅ FIXED
}

// ============================================================
// SECTION 4: Loops
// ============================================================
fun seventhTask() {  // while loop: 1 to 10
    var i = 1
    while (i <= 10) {
        println(i)
        i++
    }
}

fun eighthTask() {  // do-while: countdown
    var count = 5
    do {
        println("Countdown: $count")
        count--
    } while (count >= 1)
    println("Blast off!")
}

fun ninthTask() {  // for-in: shopping list
    val shoppingList = listOf("Milk", "Eggs", "Bread", "Butter", "Coffee")
    shoppingList.forEachIndexed { index, item ->
        println("[${index + 1}] $item")
    }
}

fun tenthTask() {  // ranges
    println("1 to 20 inclusive:")
    for (n in 1..20) print("$n ")
    println()

    println("1 to 20 excluding 20:")
    for (n in 1 until 20) print("$n ")
    println()

    println("Even numbers 2 to 20:")
    for (n in 2..20 step 2) print("$n ")
    println()

    println("Letters A to Z:")
    for (ch in 'A'..'Z') print("$ch ")
    println()
}

// ============================================================
// SECTION 5: Statements vs Expressions
// ============================================================
fun eleventhTask() {  // if-else as expression
    val age = 20
    val status = if (age >= 18) "Adult" else "Minor"
    println("Age $age → $status")
}

fun task5_3() {  // max of two numbers using expression
    val a = 42
    val b = 77
    val maxNumber = if (a > b) a else b
    println()
}

// ============================================================
// SECTION 6: Student Management System
// ============================================================
val students = listOf(
    "Musa"  to 85,
    "Phil"  to 42,  // ✅ IMPROVED: capitalised for consistency
    "Abdi"  to 67,
    "Issa"  to 91,
    "Lemah" to 38
)

fun displayAllStudents() {
    println("--- All Students ---")
    for ((name, score) in students) {
        println("$name: $score")
    }
}

fun getAverageScore(): Double {
    val total = students.sumOf { it.second }
    return total.toDouble() / students.size
}

fun findTopStudent(): String {
    return students.maxByOrNull { it.second }?.first ?: "No students"
}

fun classifyStudents() {
    println("--- Student Classifications ---")
    for ((name, score) in students) {
        val grade = getGrade(score)
        println("Name: $name, Score: $score, Grade: $grade")
    }
}

// ============================================================
// BONUS: Calculator
// ============================================================
fun calculator() {
    println()
    print("Enter first number: ")
    val a = readln().toDoubleOrNull() ?: run { println("Invalid number."); return }

    print("Enter second number: ")
    val b = readln().toDoubleOrNull() ?: run { println("Invalid number."); return }

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
        else -> { println("Error: Unknown operation '$op'."); return }
    }

    println("$a $op $b = $result")
}

// ============================================================
// MAIN
// ============================================================
fun main() {

    println("========== SECTION 1 ==========")
    firstTask()
    secondTask()

    println("\n========== SECTION 2 ==========")
    displayMenu()
    println("Discounted price: ${calculateDiscount(200.0, 15.0)}")
    println("Grade for 85: ${getGrade(85)}")
    println("Grade for 50: ${getGrade(50)}")
    println("Grade for 20: ${getGrade(20)}")
    println("Is 4 even? ${isEven(4)}")
    println("Is 7 even? ${isEven(7)}")

    println("\n========== SECTION 3 ==========")
    thirdTask()
    fourthTask()
    fifthTask()

    println("\n========== SECTION 4 ==========")
    println("-- while: 1 to 10 --")
    seventhTask()       // FIX 2: was sixthtask() — doesn't exist
    println("-- do-while: countdown --")
    eighthTask()        // FIX 3: was seventhtask() — wrong function
    println("-- for-in: shopping list --")
    ninthTask()         // FIX 4: was eighthtask() — wrong function
    println("-- ranges --")
    tenthTask()         // FIX 5: was ninethtask() — wrong function

    println("\n========== SECTION 5 ==========")
    eleventhTask()      // FIX 6: was tenthtask() — wrong function; also fixed typo eleventh() → eleventhTask()
    task5_3()           // FIX 7: was completely missing from main()

    println("\n========== SECTION 6 ==========")
    displayAllStudents()
    println("Average Score: ${"%.2f".format(getAverageScore())}")
    println("Top Student: ${findTopStudent()}")
    classifyStudents()

    // Uncomment to run interactive bonus calculator:
    // calculator()
}










