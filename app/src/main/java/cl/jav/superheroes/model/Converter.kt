package cl.jav.superheroes.model

import androidx.room.TypeConverter


class Converter {
    @TypeConverter
    fun list2String(list: List<String>): String {
        return list.joinToString()
    }
    @TypeConverter
    fun string2List(value: String): List<String> {
        return value.split(",").map {
            it.trim()
        }
    }
}