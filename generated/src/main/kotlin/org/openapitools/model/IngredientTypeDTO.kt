package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param name 
 * @param type 
 */
data class IngredientTypeDTO(

    @Schema(example = "null", description = "")
    @field:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("type") val type: IngredientTypeDTO.Type? = null
) {

    /**
    * 
    * Values: GIN,VODKA,TEQUILA,RUM,WHISKEY,BOURBON,ABSINTHE,COGNAC,PORT_WINE,SHERRY,APERITIF,LIQUOR,VERMOUTH,BITTER,WINE,BEER,SYRUP,NON_ALCOHOLIC,HONEY,DESSERT,ADDITIVE,GREENS,MISC,JAM,JUICE,SPICE,DRIED_FRUIT,DECORATION,FRUIT,VEGETABLE,TEA,NUT,BERRY,ICE
    */
    enum class Type(val value: kotlin.String) {

        @JsonProperty("GIN") GIN("GIN"),
        @JsonProperty("VODKA") VODKA("VODKA"),
        @JsonProperty("TEQUILA") TEQUILA("TEQUILA"),
        @JsonProperty("RUM") RUM("RUM"),
        @JsonProperty("WHISKEY") WHISKEY("WHISKEY"),
        @JsonProperty("BOURBON") BOURBON("BOURBON"),
        @JsonProperty("ABSINTHE") ABSINTHE("ABSINTHE"),
        @JsonProperty("COGNAC") COGNAC("COGNAC"),
        @JsonProperty("PORT_WINE") PORT_WINE("PORT_WINE"),
        @JsonProperty("SHERRY") SHERRY("SHERRY"),
        @JsonProperty("APERITIF") APERITIF("APERITIF"),
        @JsonProperty("LIQUOR") LIQUOR("LIQUOR"),
        @JsonProperty("VERMOUTH") VERMOUTH("VERMOUTH"),
        @JsonProperty("BITTER") BITTER("BITTER"),
        @JsonProperty("WINE") WINE("WINE"),
        @JsonProperty("BEER") BEER("BEER"),
        @JsonProperty("SYRUP") SYRUP("SYRUP"),
        @JsonProperty("NON_ALCOHOLIC") NON_ALCOHOLIC("NON_ALCOHOLIC"),
        @JsonProperty("HONEY") HONEY("HONEY"),
        @JsonProperty("DESSERT") DESSERT("DESSERT"),
        @JsonProperty("ADDITIVE") ADDITIVE("ADDITIVE"),
        @JsonProperty("GREENS") GREENS("GREENS"),
        @JsonProperty("MISC") MISC("MISC"),
        @JsonProperty("JAM") JAM("JAM"),
        @JsonProperty("JUICE") JUICE("JUICE"),
        @JsonProperty("SPICE") SPICE("SPICE"),
        @JsonProperty("DRIED_FRUIT") DRIED_FRUIT("DRIED_FRUIT"),
        @JsonProperty("DECORATION") DECORATION("DECORATION"),
        @JsonProperty("FRUIT") FRUIT("FRUIT"),
        @JsonProperty("VEGETABLE") VEGETABLE("VEGETABLE"),
        @JsonProperty("TEA") TEA("TEA"),
        @JsonProperty("NUT") NUT("NUT"),
        @JsonProperty("BERRY") BERRY("BERRY"),
        @JsonProperty("ICE") ICE("ICE")
    }

}

