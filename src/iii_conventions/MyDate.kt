package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return (year.compareTo(other.year) * 100) + (month.compareTo(other.month) * 10) + dayOfMonth.compareTo(other.dayOfMonth)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(date: MyDate): Boolean {
        return start <= date && date <= endInclusive
    }

    operator fun iterator(): Iterator<MyDate> {
        return object :  Iterator<MyDate> {
            var current = start
            override fun next(): MyDate {
                if (!hasNext()) {
                    throw NoSuchElementException()
                }
                val next = current
                current = current.nextDay()
                return next
            }

            override fun hasNext(): Boolean {
                return current <= endInclusive
            }

        }
    }
}
