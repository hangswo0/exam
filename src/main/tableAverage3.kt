import java.io.File
import kotlin.math.pow
import kotlin.math.sqrt

fun tableAverage3(inputName: String, range: String): Double {
    val coordinates = range.split("-") // ["B3", "D3"]
    var stringNumber = 0
    val result = mutableListOf<Double>()
    for (line in File(inputName).readLines()) {
        stringNumber++
        if (stringNumber.toString() in coordinates[0]) {
            val listDigits = line.split(", ").map { it.toDouble() }
            val firstLetter = 'A'.toInt() //65 - 0
            val x1 = Regex("""\d""").replace(coordinates[0], "").first().toInt() % firstLetter
            val x2 = Regex("""\d""").replace(coordinates[1], "").first().toInt() % firstLetter
            result += listDigits.subList(x1, x2 + 1)
        }
    }
    //return (result.average() * 100.0).roundToInt() / 100.0
    return result.average()
}

fun tableAverage4(inputName: String, range: String): Double {
    val coordinates = range.split("-") // ["B1", "A2"]
    var stringNumber = 0
    val result = mutableListOf<Double>()
    val firstLetter = 'A'.toInt() //65
    val x1 = Regex("""\d""").replace(coordinates[0], "").first().toInt() % firstLetter
    val x2 = Regex("""\d""").replace(coordinates[1], "").first().toInt() % firstLetter
    val list = listOf(x1, x2).sorted()
    val y1 = Regex("""\D""").replace(coordinates[0], "").toInt()
    val y2 = Regex("""\D""").replace(coordinates[1], "").toInt()
    for (line in File(inputName).readLines()) {
        stringNumber++
        if (stringNumber in minOf(y1, y2)..maxOf(y1, y2)) {
            val listDigits = line.split(", ").map { it.toDouble() }
            result += listDigits.subList(list[0], list[1] + 1)
        }
    }
    return result.average()
}

fun tableAverage5(inputName: String, range: String): Double {
    if (!Regex("""\pL\d\-\pL\d""").matches(range)) throw IllegalArgumentException()
    val coordinates = range.split("-") // ["E1", "B2"]
    val first = 'A'.toInt() //65
    val x1 = Regex("""\d+""").replace(coordinates[0], "").first().toInt() % first
    val x2 = Regex("""\d+""").replace(coordinates[1], "").first().toInt() % first
    val y1 = Regex("""\D""").replace(coordinates[0], "").toInt()
    val y2 = Regex("""\D""").replace(coordinates[1], "").toInt()
    val result = mutableListOf<Double>()
    val line = File(inputName).readLines()
    for (i in minOf(y1, y2)..maxOf(y1, y2)) {
        if (line[i].contains(Regex("""[^\s\.,\d]"""))) throw java.lang.IllegalArgumentException()
        val listDigits = line[i].split(", ").map { it.toDouble() }
        if (listDigits.size > 26) throw IllegalArgumentException()
        when {
            listDigits.size - 1 > maxOf(x1, x2) -> result += listDigits.subList(minOf(x1, x2), maxOf(x1, x2) + 1)
            else -> result += listDigits.subList(minOf(x1, x2), listDigits.size)
        }
    }
    return result.average()
}

fun precipitation3(inputName: String, days: String): Int {
    val dates = Regex("""(\s|\.{2})""").split(days)
    val x1 = dates[1].toInt() - 1
    val x2 = dates[2].toInt() - 1
    var result = 0
    for (line in File(inputName).readLines()) {
        if (dates[0] in line) {
            val listDigits = Regex("""\s""").split(line.replace(dates[0] + " ", "")).map { it.toInt() }
            val period = listDigits.subList(x1, x2 + 1).sorted()
            result = period[period.size - 1]
        }
    }
    return result
}

fun precipitation4(inputName: String, days: String): Int {
    TODO()
}

fun match3(inputName: String): Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    for (line in File(inputName).readLines()) {
        val string = Regex("""\s-{2}""").replace(line, "")
        val list = Regex("""(\s|-)""").split(string)
        when {
            list[2].toInt() > list[3].toInt() -> {
                if (map[list[0]] == null) map[list[0]] = 3
                else map[list[0]] = map[list[0]]!! + 3
            }

            list[2].toInt() < list[3].toInt() -> {
                if (map[list[1]] == null) map[list[1]] = 3
                else map[list[1]] = map[list[1]]!! + 3
            }

            else -> {
                if (map[list[0]] == null) map[list[0]] = 1
                else map[list[0]] = map[list[0]]!! + 1
                if (map[list[1]] == null) map[list[1]] = 1
                else map[list[1]] = map[list[1]]!! + 1
            }
        }
    }
    return map
}

/* fun match4(inputName: String): Pair<String, List<Int>> {
    val points = mutableMapOf<String, Int>()
    val wins = mutableMapOf<String, Int>()
    val draws = mutableMapOf<String, Int>() //ничья
    val defeats = mutableMapOf<String, Int>() //поражение
    val goalsScored = mutableMapOf<String, Int>() // забитые мячи
    val concededGoals = mutableMapOf<String, Int>() // пропущенные мячи
    for (line in File(inputName).readLines()) {
        val string = Regex("""\s-{2}""").replace(line, "")
        val list = Regex("""(\s|-)""").split(line)
        val teamFirst = mutableListOf(0, 0, 0, 0, 0, 0) //points, wins, draws, defeats, goalsScored, concededGoals
        val teamSecond = mutableListOf(0, 0, 0, 0, 0, 0)
        when {
            }
        }
    }
} */

fun football3(inputName: String): Map<String, Pair<Int, Int>> {
    val goalsScored = mutableMapOf<String, Int>()
    val concededGoals = mutableMapOf<String, Int>()
    val map = mutableMapOf<String, Pair<Int, Int>>()
    val lines = File(inputName).readLines()
    val teams = mutableListOf<String>()
    lines.forEach {
        val name = Regex("""\s+""").split(it)
        val goals = name.subList(1, name.size).sumOf { n -> n.toInt() }
        teams += name[0]
        goalsScored[name[0]] = goals
        concededGoals[name[0]] = 0
    }
    for (i in 0 until teams.size) {
        for (j in 0 until teams.size) {
            val str = Regex("""\s+""").split(lines[i])
            val nums = str.subList(1, str.size).map { it.toInt() }
            concededGoals[teams[j]] = concededGoals[teams[j]]!! + nums[j]
        }
    }
    for ((key, value) in goalsScored) {
        map[key] = (value to concededGoals[key]) as Pair<Int, Int>
    }
    return map
}

fun triangles(inputName: String): String {
    var result = ""
    var minimal = 100000000.0
    for (line in File(inputName).readLines()) {
        val name = Regex("""[^\pL]""").replace(line, "")
        val coordinates = Regex("""\pL{3}\s""").replace(line, "").split(" ").map { it.toDouble() }
        val x = mutableListOf<Double>()
        val y = mutableListOf<Double>()
        for (i in coordinates.indices) {
            if (i % 2 == 0) x += coordinates[i]
            else y += coordinates[i]
        }
        val perimetr = sqrt((x[1] - x[2]).pow(2.0) + (y[1] - y[2]).pow(2.0)) + sqrt((x[0] - x[2]).pow(2.0) + (y[0] - y[2]).pow(2.0)) + sqrt((x[1] - x[0]).pow(2.0) + (y[1] - y[0]).pow(2.0))
        if (perimetr < minimal) {
            minimal = perimetr
            result = name
        }
    }
    return result
}

fun trainSchedule3(inputName: String, scr: String, dst: String, time: String): String {
    var result = 23.59
    for (line in File(inputName).readLines()) {
        if (scr in line) {
            val str = Regex(""":\s+""").replace(line.replace(scr, ""), "")
            val times = Regex(""":""").replace(str, ".").split(" ").map { it.toDouble() }
            val timeDouble = time.replace(":", ".").toDouble()
            for (t in times) {
                if (t in timeDouble..result) result = t
            }
        }
    }
    return result.toString().replace(".", ":")
}

fun trainSchedule4(inputName: String, scr: String, dst: String, time: String): Pair<String, String> {
    var dep = ""
    var ar = ""
    val departure = mutableListOf<String>()
    val arrival = mutableListOf<String>()
    for (line in File(inputName).readLines()) {
        if (scr in line) departure += Regex(""":\s+""").replace(line.replace(scr, ""), "").split(Regex("""\s+"""))
        if (dst in line) arrival += Regex(""":\s+""").replace(line.replace(dst, ""), "").split(Regex("""\s+"""))
    }
    for (i in departure.indices) {
        if (departure[i] != "---" && arrival[i] != "---" &&
            (departure[i]).replace(":", ".").toDouble() >= time.replace(":", ".").toDouble()) {
            dep = departure[i]
            ar = arrival[i]
        }
    }
    return (dep to ar)
}

fun trainSchedule5(inputName: String, scr: String, dst: String, time: String): Pair<List<String>, List<String>> {
    val dep = mutableListOf<String>()
    val ar = mutableListOf<String>()
    val departure = mutableListOf<String>()
    val arrival = mutableListOf<String>()
    for (line in File(inputName).readLines()) {
        if (scr in line) departure += Regex(""":\s+""").replace(line.replace(scr, ""), "").split(Regex("""\s+"""))
        if (dst in line) arrival += Regex(""":\s+""").replace(line.replace(dst, ""), "").split(Regex("""\s+"""))
    }
    for (i in departure.indices) {
        if (departure[i] != "---" && arrival[i] != "---" &&
            (departure[i]).replace(":", ".").toDouble() >= time.replace(":", ".").toDouble()) {
            dep += departure[i]
            ar += arrival[i]
        }
    }
    return (dep to ar)
}

fun intersectingRectangles(inputName: String): Pair<String, String> {
    var result = "" to ""
    val list = File(inputName).readLines()
    for (i in 0 until list.size - 1) {
        for (j in (i + 1) until list.size) {
            val firstRest = Regex("""[^\pL+]""").replace(list[i], "")
            val firstC = Regex("""\pL+\s""").replace(list[i], "").split(" ").map { it.toInt() }
            val secRest = Regex("""[^\pL+]""").replace(list[j], "")
            val secC = Regex("""\pL+\s""").replace(list[j], "").split(" ").map { it.toInt() }
            when {
                ((firstC[1] <= secC[1] && secC[1] < firstC[3]) &&
                ((firstC[0] <= secC[0] && secC[0] < firstC[2]) ||
                (firstC[0] < secC[2] && secC[2] <= firstC[2]))) -> result = firstRest to secRest

                ((firstC[1] < secC[3] && secC[3] <= firstC[3]) &&
                ((firstC[0] < secC[2] && secC[2] <= firstC[2]) ||
                (firstC[2] < secC[0] && secC[0] <= firstC[0]))) -> result = firstRest to secRest
            }
        }
    }
    return result
}

fun centerOfGravity(inputName: String): String {
    val x = mutableListOf<Double>()
    val y = mutableListOf<Double>()
    val m = mutableListOf<Double>()
    val lines = File(inputName).readLines()
    var numeratorX = 0.0
    var numeratorY = 0.0
    lines.forEach {
        val strings = it.split(" ")
        x += strings[0].toDouble()
        y += strings[1].toDouble()
        m += strings[3].toDouble()
        numeratorX += strings[0].toDouble() * strings[3].toDouble()
        numeratorY += strings[1].toDouble() * strings[3].toDouble()
    }
    val xCenter = numeratorX / m.sum()
    val yCenter = numeratorY / m.sum()

    var result = ""
    var max = 0.0
    for (i in x.indices) {
        val distance = sqrt((xCenter - x[i]).pow(2.0) + (yCenter - y[i]).pow(2.0))
        if (distance > max) {
            max = distance
            result = lines[i]
        }
    }
    return result
}

fun upcomingDates(inputName: String): Pair<String, String> {
    return "" to ""
}

fun triangle(inputName: String): String {
    val point = mutableListOf<String>()
    val x = mutableListOf<Double>()
    val y = mutableListOf<Double>()
    var minimum = 9.999999999999999E22
    var result = ""
    val lines = File(inputName).readLines()
    lines.forEach {
        if (!Regex("""\pL\s\d+\.\d+\s\d+\.\d+""").matches(it)) throw IllegalArgumentException()
        val strings = it.split(" ")
        point += strings[0]
        x += strings[1].toDouble()
        y += strings[2].toDouble()
    }
    for (i in 0 until x.size - 2) {
        for (j in i + 1 until x.size - 1) {
            for (k in j + 1 until x.size) {
                val perimeter = sqrt((x[i] - x[j]).pow(2) + (y[i] - y[j]).pow(2)) +
                        sqrt((x[j] - x[k]).pow(2) + (y[j] - y[k]).pow(2)) +
                        sqrt((x[k] - x[i]).pow(2) + (y[k] - y[i]).pow(2))
                if (perimeter < minimum) {
                    minimum = perimeter
                    result = point[i] + point[j] + point[k]
                }
            }
        }
    }
    return result
}

fun grandparentsAndGrandchildren1(inputName: String): Pair<String, String> {
    val allNames = mutableSetOf<String>()
    val fathers = mutableListOf<String>()
    val sons = mutableListOf<String>()
    var result = "" to ""
    for (line in File(inputName).readLines()) {
        val strings = line.replace(" is a father of ", " ").split(" ")
        allNames += strings
        fathers += strings[0]
        sons += strings[1]
    }
    allNames.forEach {
        if (it in fathers && it in sons) {
            result = fathers[sons.indexOf(it)] to sons[fathers.indexOf(it)]
        }
    }
    return result
}

fun grandparentsAndGrandchildren2(inputName: String): Map<String, List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    val result = mutableMapOf<String, MutableList<String>>()
    for (line in File(inputName).readLines()) {
        if (" is a father of " !in line) throw IllegalArgumentException()
        val strings = line.replace(" is a father of ", " ").split(" ")
        if (map[strings[0]] == null) map[strings[0]] = mutableListOf(strings[1])
        else map[strings[0]]!! += strings[1]
    }
    for ((key, value) in map) {
        for (son in value) {
            if (map.containsKey(son)) {
                if (result[key] == null) result[key] = map[son]!!.toMutableList()
                else result[key]!! += map[son]!!.toMutableList()
            }
        }
    }
    return result
}

fun apartments3(inputName: String, query: String): Set<String> {
    val desiredRoom = query.split(" ")[0]
    val minSquare = query.split(" ")[1].toInt()
    val result = mutableSetOf<String>()
    for (line in File(inputName).readLines()) {
        val list = Regex("""(:\s|,\s)""").split(line)
        val apartments = list[0]
        for (i in 1 until list.size) {
            val room = list[i].split(" ")[0]
            val square = list[i].split(" ")[1].toInt()
            if (room == desiredRoom && square >= minSquare) result += apartments
        }
    }
    return result
}

fun apartments4(inputName: String, query: String): List<String> {
    val result = mutableListOf<String>()
    val possibleApartments = mutableMapOf<String, Int>()
    val desiredRooms = listOf(Regex("""(,\s|\s)""").split(query)[0], Regex("""(,\s|\s)""").split(query)[2])
    val minSquare = listOf(Regex("""(,\s|\s)""").split(query)[1].toInt(), Regex("""(,\s|\s)""").split(query)[3].toInt())
    for (line in File(inputName).readLines()) {
        val list = Regex("""(:\s|,\s)""").split(line)
        val apartment = list[0]
        for (i in 1 until list.size) {
            val room = list[i].split(" ")[0]
            val square = list[i].split(" ")[1].toInt()
            if (room in desiredRooms && square >= minSquare[desiredRooms.indexOf(room)]) {
                if (possibleApartments[apartment] == null) possibleApartments[apartment] = 1
                else possibleApartments[apartment] = possibleApartments[apartment]!! + 1
            }
        }
    }
    possibleApartments.forEach { (key, value) ->
        if (value >= desiredRooms.size) result += key
    }
    return result
}

fun apartments5(inputName: String, query: String): List<String> {
    val result = mutableListOf<String>()
    val possibleApartments = mutableMapOf<String, Int>()
    val queryList = query.split("; ")
    val queryMap = mutableMapOf<Int, MutableList<String>>()
    queryList.forEach {
        val room = it.split(" ")[0]
        val size = it.split(" ")[1].toInt()
        if (queryMap[size] == null) queryMap[size] = mutableListOf(room)
        else queryMap[size]!! += room
    }
    for (line in File(inputName).readLines()) {
        val list = Regex("""(:\s|,\s)""").split(line)
        val apartment = list[0]
        for (i in 1 until list.size) {
            val room = list[i].split(" ")[0]
            val size = list[i].split(" ")[1].toInt()
            queryMap.forEach { (key, value) ->
                if (size >= key && room in value) {
                    if (possibleApartments[apartment] == null) possibleApartments[apartment] = 1
                    else possibleApartments[apartment] = possibleApartments[apartment]!! + 1
                }
            }
        }
    }
    possibleApartments.forEach { (key, value) ->
        if (value == queryList.size) result += key
    }
    return result
}

fun productsInStock3(inputName: String, query: String): String {
    var result = "такого товара нет"
    val code = query.split(" ")[0]
    val amount = query.split(" ")[1].toInt()
    for (line in File(inputName).readLines()) {
        val list = Regex("""(-\s|,|\sр|\s(кг|шт|уп|г))""").replace(line, "").split(" ")
        val totalCost = list[2].toInt() * list[3].toInt()
        when {
            (list[0] == code && list[3].toInt() >= amount) -> result = list[1] + ", достаточно, общая стоимость " + totalCost + " р"

            (list[0] == code && list[3].toInt() < amount) -> result = list[1] + ", недостаточно, общая стоимость " + totalCost + " р"
        }
    }
    return result
}

fun productsInStock4(inputName: String, query: String): List<String> {
    val result = mutableListOf<String>()
    val code = query.split(" ")[0]
    val amount = query.split(" ")[1].toInt()
    for (line in File(inputName).readLines()) {
        val list = Regex("""(-\s|,|\sр|\s(кг|шт|уп|г))""").replace(line, "").split(" ")
        val totalCost = list[2].toInt() * list[3].toInt()
        when {
            (code == "*" && list[3].toInt() >= amount) -> result += list[1] + ", достаточно, общая стоимость " + totalCost + " р"
            (code == list[0] && list[3].toInt() >= amount) -> result += list[1] + ", достаточно, общая стоимость " + totalCost + " р"
            (code == list[0] && list[3].toInt() < amount) -> result += list[1] + ", недостаточно, общая стоимость " + totalCost + " р"
        }
    }
    if (result.isEmpty()) result += "товара, подходящего под ваши условия, нет"
    return result
}

fun matrices(matrix1: List<List<Int>>, matrix2: List<List<Int>>): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>() //%
    for (i in matrix1.indices) {
        //проверка корректности матриц
        //решение - %
        if (matrix1.size != matrix2.size && matrix1[i].size != matrix1.size && matrix2[i].size != matrix2.size)
            throw IllegalArgumentException()
        var j = 0
        val setColumn1 = mutableSetOf<Int>()
        val setColumn2 = mutableSetOf<Int>()
        val setLine1 = mutableSetOf<Int>()
        val setLine2 = mutableSetOf<Int>()
        val element = mutableListOf<Int>() //%
        while (j != matrix1.size) {
            setColumn1 += matrix1[i][j]
            setColumn2 += matrix1[i][j]
            setLine1 += matrix1[j][i]
            setLine2 += matrix2[j][i]
            element += matrix1[i][j] + matrix2[i][j] //%
            j++
        }
        if (setColumn1.size != matrix1.size && setColumn2.size != matrix2.size) throw IllegalArgumentException()
        if (setLine1.size != matrix1.size && setLine2.size != matrix2.size) throw IllegalArgumentException()
        result += element //%
    }
    return result
}