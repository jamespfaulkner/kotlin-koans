package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
//        val yearComparison = year.compareTo(other.year)
//        return if (yearComparison == 0) {
//            val monthComparison = month.compareTo(other.month)
//            if (monthComparison == 0) {
//                dayOfMonth.compareTo(other.dayOfMonth)
//            } else {
//                monthComparison
//            }
//        } else {
//            yearComparison
//        }
//    }
        return (year.compareTo(other.year) * 100) + (month.compareTo(other.month) * 10) + dayOfMonth.compareTo(other.dayOfMonth)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(date: MyDate): Boolean {
        return date in start..endInclusive
    }
}
