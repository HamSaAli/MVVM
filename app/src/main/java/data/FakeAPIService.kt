package data

class FakeAPIService {
    private val wisdomList = listOf<Wisdom>(
        Wisdom("الشجرة المثمرة تتعرض لاكبر قدر من الحجارة","8/1/2012"),
        Wisdom("التغيير هو قانون الحياة","8/11/2020"),
        Wisdom("النجاح هو القدرة على الذهاب من فشل الى فشل بدون فقدان الحماس","4/12/2017"),
        Wisdom("لا تنتظر الفرص بل اصنعها","8/1/2012"),
    )

    fun getRandomWisdom(): Wisdom {
        val random = ((Math.random()) * wisdomList.size).toInt()
        return wisdomList[random]
    }

}