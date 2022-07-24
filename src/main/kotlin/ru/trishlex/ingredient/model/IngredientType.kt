package ru.trishlex.ingredient.model

import org.openapitools.model.IngredientTypeDTO

enum class IngredientType(val type: String) {
    GIN("Джин"),
    VODKA("Водка"),
    TEQUILA("Текила"),
    RUM("Ром"),
    WHISKEY("Виски"),
    BOURBON("Бурбон"),
    ABSINTHE("Абсент"),
    COGNAC("Коньяк"),
    PORT_WINE("Портвейн"),
    SHERRY("Херес"),
    APERITIF("Аперитив"),
    LIQUOR("Ликер"),
    VERMOUTH("Вермут"),
    BITTER("Биттер"),
    WINE("Вино"),
    BEER("Пиво"),
    SYRUP("Сироп"),
    NON_ALCOHOLIC("Безалкогольное"),
    HONEY("Мед"),
    DESSERT("Десерты"),
    ADDITIVE("Добавки"),
    GREENS("Зелень"),
    MISC("Разное"),
    JAM("Варенье"),
    JUICE("Сок"),
    SPICE("Специи"),
    DRIED_FRUIT("Сухофрукты"),
    DECORATION("Украшения"),
    FRUIT("Фрукты"),
    VEGETABLE("Овощи"),
    TEA("Чай"),
    NUT("Орехи"),
    BERRY("Ягоды"),
    ICE("Лед"),
    ;

    companion object {
        private val TYPE_MAPPING = HashMap<String, IngredientType>()
        init {
            for (ingredientType in IngredientType.values()) {
                TYPE_MAPPING[ingredientType.type] = ingredientType
            }
        }

        fun fromType(type: String): IngredientType {
            return TYPE_MAPPING[type]!!
        }
    }

    fun toDto(): IngredientTypeDTO {
        return when(this) {
            GIN -> IngredientTypeDTO(type, IngredientTypeDTO.Type.GIN)
            VODKA -> IngredientTypeDTO(type, IngredientTypeDTO.Type.VODKA)
            TEQUILA -> IngredientTypeDTO(type, IngredientTypeDTO.Type.TEQUILA)
            RUM -> IngredientTypeDTO(type, IngredientTypeDTO.Type.RUM)
            WHISKEY -> IngredientTypeDTO(type, IngredientTypeDTO.Type.WHISKEY)
            BOURBON -> IngredientTypeDTO(type, IngredientTypeDTO.Type.BOURBON)
            ABSINTHE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.ABSINTHE)
            COGNAC -> IngredientTypeDTO(type, IngredientTypeDTO.Type.COGNAC)
            PORT_WINE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.PORT_WINE)
            SHERRY -> IngredientTypeDTO(type, IngredientTypeDTO.Type.SHERRY)
            APERITIF -> IngredientTypeDTO(type, IngredientTypeDTO.Type.APERITIF)
            LIQUOR -> IngredientTypeDTO(type, IngredientTypeDTO.Type.LIQUOR)
            VERMOUTH -> IngredientTypeDTO(type, IngredientTypeDTO.Type.VERMOUTH)
            BITTER -> IngredientTypeDTO(type, IngredientTypeDTO.Type.BITTER)
            WINE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.WINE)
            BEER -> IngredientTypeDTO(type, IngredientTypeDTO.Type.BEER)
            SYRUP -> IngredientTypeDTO(type, IngredientTypeDTO.Type.SYRUP)
            NON_ALCOHOLIC -> IngredientTypeDTO(type, IngredientTypeDTO.Type.NON_ALCOHOLIC)
            HONEY -> IngredientTypeDTO(type, IngredientTypeDTO.Type.HONEY)
            DESSERT -> IngredientTypeDTO(type, IngredientTypeDTO.Type.DESSERT)
            ADDITIVE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.ADDITIVE)
            GREENS -> IngredientTypeDTO(type, IngredientTypeDTO.Type.GREENS)
            MISC -> IngredientTypeDTO(type, IngredientTypeDTO.Type.MISC)
            JAM -> IngredientTypeDTO(type, IngredientTypeDTO.Type.JAM)
            JUICE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.JUICE)
            SPICE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.SPICE)
            DRIED_FRUIT -> IngredientTypeDTO(type, IngredientTypeDTO.Type.DRIED_FRUIT)
            DECORATION -> IngredientTypeDTO(type, IngredientTypeDTO.Type.DECORATION)
            FRUIT -> IngredientTypeDTO(type, IngredientTypeDTO.Type.FRUIT)
            VEGETABLE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.VEGETABLE)
            TEA -> IngredientTypeDTO(type, IngredientTypeDTO.Type.TEA)
            NUT -> IngredientTypeDTO(type, IngredientTypeDTO.Type.NUT)
            BERRY -> IngredientTypeDTO(type, IngredientTypeDTO.Type.BERRY)
            ICE -> IngredientTypeDTO(type, IngredientTypeDTO.Type.ICE)
        }
    }
}