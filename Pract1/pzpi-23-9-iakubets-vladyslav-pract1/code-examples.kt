// Поганий приклад
fun c(a: Int, b: Int): Int {
    return a + b
}

// Гарний приклад
fun calculateSum(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}




// Поганий приклад
if (status == 0) println("Loading")
else if (status == 1) println("Success")
else if (status == 2) println("Error")
else println("Unknown")

// Гарний приклад
when (status) {
      0 -> println("Loading")
     1 -> println("Success")
     2 -> println("Error")
     else -> println("Unknown")
}




// Поганий приклад
fun calculateSalary(employee: Employee): Double {
    return employee.hoursWorked * employee.hourlyRate + employee.hoursWorked * 0.1
}

fun calculateBonus(employee: Employee): Double {
    return employee.hoursWorked * employee.hourlyRate + employee.hoursWorked * 0.1
}

// Гарний приклад
fun calculatePayment(employee: Employee): Double {
    return employee.hoursWorked * (employee.hourlyRate + 0.1)
}

fun calculateSalary(employee: Employee) = calculatePayment(employee)
fun calculateBonus(employee: Employee) = calculatePayment(employee)





// Поганий приклад
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = mutableListOf<Int>()
for (n in numbers) {
    if (n % 2 == 0) {
        evenNumbers.add(n)
    }
}

// Гарний приклад
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter { it % 2 == 0 }




// Поганий приклад
open class Result
class Success(val data: String) : Result()
class Error(val message: String) : Result()

fun handle(result: Result) {
    if (result is Success) println("Успіх: ${result.data}")
    else if (result is Error) println("Помилка: ${result.message}")
}
 
// Гарний приклад
sealed class Result
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()

fun handle(result: Result) = when (result) {
    is Success -> println("Успіх: ${result.data}")
    is Error -> println("Помилка: ${result.message}")
}




// Поганий приклад
for (user in users) {
    if (user.isActive) {
        if (user.balance > 0) {
            println("Активний користувач: ${user.name}")
        }
    }
}

// Гарний приклад
users.filter { it.isActive && it.balance > 0 }
    .forEach { println("Активний користувач: ${it.name}") }




// Поганий приклад
fun getUserInfo (id:Int):String{
val user=database.getUserById(id)
if(user!=null){
println("Ім'я:"+user.name)
println("Вік:"+user.age)}
else{
println("Користувача не знайдено")}
return "Кінець виконання"
}

// Гарний приклад
fun getUserInfo(id: Int): String {
    val user = database.getUserById(id)
    if (user != null) {
        println("Ім’я: ${user.name}")
        println("Вік: ${user.age}")
    } else {
        println("Користувача не знайдено")
    }
    return "Кінець виконання"
}




// Поганий приклад
val user: User? = database.findUserById(5)
println(user.name) // Runtime помилка!

// Гарний приклад
val user: User? = database.findUserById(5)
val name = user?.name ?: "Невідомо"
println("Ім’я користувача: $name")




// Поганий приклад
fun sum(arr: List<Int>) = arr.fold(0) { acc, i -> acc + (i shr 1 shl 1) } // заплутано

// Гарний приклад
fun sum(arr: List<Int>): Int {
    var total = 0
    for (i in arr) {
        total += i
    }
   return total
}




// Поганий приклад
// Додає 10 до значення
fun addTen(value: Int): Int {
    return value + 10
}

// Гарний приклад
// Додає стандартну премію до зарплати відповідно до політики компанії
fun addBonus(salary: Int): Int {
    val bonus = 10
    return salary + bonus
}




// Поганий приклад
fun addUser(user: User) = println("Додано користувача: ${user.name}")
fun calculateTax(order: Order) = println("Податок: ${order.total * 0.2}")
fun deleteUser(id: Int) = println("Видалено користувача з ID: $id")

// Гарний приклад
object UserService {
    fun add(user: User) = println("Додано користувача: ${user.name}")
    fun delete(id: Int) = println("Видалено користувача з ID: $id")
}




// Поганий приклад
try {
    val text = File("data.txt").readText()
} catch (e: Exception) {
    // Ігноруємо виняток — погана практика
}

// Гарний приклад
try {
    val text = File("data.txt").readText()
    println("Файл успішно прочитано!")
} catch (e: IOException) {
    println("Помилка читання файлу: ${e.message}")
}