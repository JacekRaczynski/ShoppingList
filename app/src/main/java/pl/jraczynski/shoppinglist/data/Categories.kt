package pl.jraczynski.shoppinglist.data

enum class Categories {
    food,
    home_garden,
    sporting_goods,
    health_beauty,
    UKNOWN;

    companion object {
        fun byCategoryNameOrNull(input: String): Categories?{
            return values().firstOrNull(){ it.name.equals(input,true)}
        }
    }
}