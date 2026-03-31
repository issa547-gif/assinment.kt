
// SECTION 1

var studentName = "Issa Lemah"          // mutable
val studentId = 129608                  // immutable
var gpa = 4.89                           // mutable
val isEnrolled = true                    // immutable
val middleInitial = 'Y'                  // immutable

fun task1_2() {
    println("Student: $studentName $middleInitial. (ID: $studentId) has GPA $gpa and is enrolled: $isEnrolled")
}

fun task1_3() {
    var phoneNumber: String? = null
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

fun task3_2() {
    val dayOfWeek = "Monday"
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("Weekend! Time to relax")
        "Monday"             -> println("Back to work")
        "Friday"             -> println("TGIF!")
        else                 -> println("Regular weekday")
    }
}

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



fun task4_1() {
    var i = 1
    while (i <= 10) {
        println(i)
        i++
    }
}


fun task4_2() {
    var count = 5
    do {
        println("Countdown: $count")
        count--
    } while (count >= 1)
    println("Blast off!")
}


fun task4_3() {
    val shoppingList = listOf("Milk", "Eggs", "Bread", "Butter", "Coffee")
   
    shoppingList.forEachIndexed { index, item ->
        println("[${index + 1}] $item")
    }
}


fun task4_4() {
   
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




fun task5_2() {
    val age = 20
    val status = if (age >= 18) "Adult" else "Minor"
    println("Age $age → $status")
}


fun task5_3() {
    val a = 42
    val b = 77
    val maxNumber = if (a > b) a else b
    println("Max of $a and $b is $maxNumber")
}




val students = listOf(
    "Musa"   to 85,
    "phil"     to 42,
    "Abdi" to 67,
    "Issa"   to 91,
    "Lemah"   to 38
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


fun main() {

    println("========== SECTION 1 ==========")
    task1_2()
    task1_3()

    println("\n========== SECTION 2 ==========")
    displayMenu()
    println("Discounted price: ${calculateDiscount(200.0, 15.0)}")
    println("Grade for 85: ${getGrade(85)}")
    println("Grade for 50: ${getGrade(50)}")
    println("Grade for 20: ${getGrade(20)}")
    println("Is 4 even? ${isEven(4)}")
    println("Is 7 even? ${isEven(7)}")

    println("\n========== SECTION 3 ==========")
    task3_1()
    task3_2()
    task3_3()

    println("\n========== SECTION 4 ==========")
    println("-- while: 1 to 10 --")
    task4_1()
    println("-- do-while: countdown --")
    task4_2()
    println("-- for-in: shopping list --")
    task4_3()
    println("-- ranges --")
    task4_4()

    println("\n========== SECTION 5 ==========")
    task5_2()
    task5_3()

    println("\n========== SECTION 6 ==========")
    displayAllStudents()
    println("Average Score: ${"%.2f".format(getAverageScore())}")
    println("Top Student: ${findTopStudent()}")
    classifyStudents()


}
