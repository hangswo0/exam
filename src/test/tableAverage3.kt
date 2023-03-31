import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Tests {
    @Test
    fun tableAverage3() {
        assertEquals(
            2.2,
            tableAverage3("input/tableAverage3.txt", "B3-D3"), 1e-5
        )
        assertEquals(
            4.1,
            tableAverage3("input/tableAverage31.txt", "A1-C1"), 1e-5
        )
        assertEquals(
            0.3,
            tableAverage3("input/tableAverage31.txt", "C3-E3"), 1e-5
        )
    }

    @Test
    fun tableAverage4() {
        assertEquals(
            4.1175,
            tableAverage4("input/tableAverage3.txt", "B1-A2")
        )
        assertEquals(
            3.5625,
            tableAverage4("input/tableAverage31.txt", "E3-B2")
        )
    }

    @Test
    fun tableAverage5() {
        assertEquals(
            4.825,
            tableAverage5("input/tableAverage31.txt", "E2-B1")
        )
        assertEquals(
            4.1175,
            tableAverage5("input/tableAverage3.txt", "B1-A2")
        )
        assertEquals(
            3.5625,
            tableAverage5("input/tableAverage31.txt", "E3-B2")
        )
    }

    @Test
    fun precipitation3() {
        assertEquals(
            42,
            precipitation3("input/precipitation1.txt", "Апрель 9..15")
        )
        assertEquals(
            41,
            precipitation3("input/precipitation1.txt", "Март 5..12")
        )
        assertEquals(
            13,
            precipitation3("input/precipitation1.txt", "Май 10..20")
        )
    }

    @Test
    fun precipitation4() {
        assertEquals(
            42,
            precipitation4("input/precipitation1.txt", "Апрель 9..15")
        )
        assertEquals(
            48,
            precipitation4("input/precipitation1.txt", "Март 22..Май 8")
        )
    }

    @Test
    fun match3() {
        assertEquals(
            mapOf("Зенит" to 6, "Спартак" to 3, "Динамо" to 1, "ЦСКА" to 1),
            match3("input/match1.txt")
        )
        assertEquals(
            mapOf("Зенит" to 4, "Спартак" to 2, "ЦСКА" to 3, "Локомотив" to 4),
            match3("input/match2.txt")
        )
    }

    @Test
    fun football3() {
        assertEquals(
            mapOf("Арсенал" to (6 to 5), "Бавария" to (6 to 14), "Интер" to (3 to 3), "Барселона" to (11 to 4)),
            football3("input/football1.txt")
        )
        assertEquals(
            mapOf("Интел" to (15 to 14), "Бавария" to (13 to 15), "Барселона" to (22 to 16),
                "ЦСКА" to (15 to 22), "Локомотив" to (14 to 17), "Зенит" to (15 to 10)),
            football3("input/football2.txt")
        )
    }

    @Test
    fun triangles() {
        assertEquals("XYZ",
            triangles("input/triangles1.txt"))
    }

    @Test
    fun trainSchedule3() {
        assertEquals(
            "7:15",
            trainSchedule3("input/trainSchedule1.txt", "Санкт-Петербург", "Боровая", "6:53"))
        assertEquals(
            "6:39",
            trainSchedule3("input/trainSchedule1.txt", "Возд. Парк", "Купчино", "6:20"))
    }

    @Test
    fun trainSchedule4() {
        assertEquals(
            ("7:40" to "7:51"),
            trainSchedule4("input/trainSchedule2.txt", "Санкт-Петербург", "Пр. Славы", "7:25")
        )
        assertEquals(
            ("7:17" to "7:30"),
            trainSchedule4("input/trainSchedule2.txt", "Боровая", "Купчино", "7:02")
        )
    }

    @Test
    fun trainSchedule5() {
        assertEquals(
            (listOf("7:03", "7:27", "7:51") to listOf("7:07", "7:30", "7:54")),
            trainSchedule5("input/trainSchedule2.txt", "Пр. Славы", "Купчино", "6:42")
        )
        assertEquals(
            (listOf("6:55", "7:17") to listOf("6:58", "7:20")),
            trainSchedule5("input/trainSchedule2.txt", "Боровая", "Возд. Парк", "6:38")
        )
    }

    @Test
    fun intersectingRectangles() {
        assertEquals(
            "GREEN" to "BLUE",
            intersectingRectangles("input/intersectingRectangles1.txt")
        )
        assertEquals(
            "BLACK" to "YELLOW",
            intersectingRectangles("input/intersectingRectangles2.txt")
        )
        /*assertEquals(
            "BLUE" to "BROWN",
            intersectingRectangles("input/intersectingRectangles3.txt")
        ) */
        assertEquals(
            "VIOLET" to "WHITE",
            intersectingRectangles("input/intersectingRectangles4.txt")
        )
        assertEquals(
            "GREEN" to "BLACK",
            intersectingRectangles("input/intersectingRectangles5.txt")
        )
        assertEquals(
            "RED" to "WHITE",
            intersectingRectangles("input/intersectingRectangles6.txt")
        )
        assertEquals(
            "BROWN" to "YELLOW",
            intersectingRectangles("input/intersectingRectangles7.txt")
        )
    }

    @Test
    fun centerOfGravity() {
        assertEquals(
            "0.5 -3.3 M 0.15",
            centerOfGravity("input/centerOfGravity1.txt")
        )
    }

    @Test
    fun upcomingDates() {
        assertEquals(
            "29 апреля" to "5 мая",
            upcomingDates("input/upcomingDates1.txt")
        )
    }

    @Test
    fun triangle() {
        assertEquals(
            "BCD",
            triangle("input/triangle1.txt")
        )
    }

    @Test
    fun grandparentsAndGrandchildren1() {
        assertEquals(
            "Mike" to "Derek",
            grandparentsAndGrandchildren1("input/grandparentsAndGrandchildren1.txt")
        )
    }

    @Test
    fun grandparentsAndGrandchildren2() {
        assertEquals(
            mapOf("Mike" to listOf("Derek")),
            grandparentsAndGrandchildren2("input/grandparentsAndGrandchildren1.txt")
        )
        assertEquals(
            mapOf("Mike" to listOf("Andrew", "Levi", "Gilbert")),
            grandparentsAndGrandchildren2("input/grandparentsAndGrandchildren2.txt")
        )
    }

    @Test
    fun apartments3() {
        assertEquals(
            setOf("Школьная 12-14", "Садовая 19-1-55"),
            apartments3("input/apartments1.txt", "кухня 8")
        )
        assertEquals(
            setOf("Пионерская 9-17", "Школьная 12-14", "Садовая 19-1-55", "Железнодорожная 3-6"),
            apartments3("input/apartments1.txt", "комната 10")
        )
    }

    @Test
    fun apartments4() {
        assertEquals(
            listOf("Школьная 12-14", "Садовая 19-1-55"),
            apartments4("input/apartments1.txt", "кухня 8; комната 15")
        )
    }

    @Test
    fun apartments5() {
        assertEquals(
            listOf("Садовая 19-1-55"),
            apartments5("input/apartments1.txt", "кухня 8; комната 19; комната 12")
        )
    }

    @Test
    fun productsInStock3() {
        assertEquals(
            "яйца, достаточно, общая стоимость 1380 р",
            productsInStock3("input/productsInStock1.txt", "009724 15")
        )
        assertEquals(
            "свинина, недостаточно, общая стоимость 0 р",
            productsInStock3("input/productsInStock1.txt", "002762 48")
        )
        assertEquals(
            "такого товара нет",
            productsInStock3("input/productsInStock1.txt", "895647 3")
        )
    }

    @Test
    fun productsInStock4() {
        assertEquals(
            listOf("яблоки, достаточно, общая стоимость 2646 р", "молоко, достаточно, общая стоимость 5328 р"),
            productsInStock4("input/productsInStock1.txt", "* 35")
        )
        assertEquals(
            listOf("яйца, достаточно, общая стоимость 1380 р"),
            productsInStock4("input/productsInStock1.txt", "009724 15")
        )
        assertEquals(
            listOf("свинина, недостаточно, общая стоимость 0 р"),
            productsInStock4("input/productsInStock1.txt", "002762 48")
        )
        assertEquals(
            listOf("товара, подходящего под ваши условия, нет"),
            productsInStock4("input/productsInStock1.txt", "895647 3")
        )
    }

    @Test
    fun matrices() {
        assertEquals(
            listOf(listOf(4, 9, 8), listOf(6, 7, 7), listOf(11, 7, 4)),
            matrices(listOf(listOf(1, 2, 3), listOf(2, 4, 6), listOf(3, 5, 4)), listOf(listOf(3, 7, 5), listOf(4, 3, 1), listOf(8, 2, 0)))
        )
    }
}