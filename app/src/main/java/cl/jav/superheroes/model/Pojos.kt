package cl.jav.superheroes.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="superhero")
 data class SuperHero(
    @PrimaryKey val id:Int,
    val name:String,
    val slug:String,
    @Embedded val powerstats:PowerStats,
    @Embedded val appearance:Appearence,
    @Embedded val biography:Biography,
    @Embedded val work:Work,
    @Embedded val connections:Connection,
    @Embedded val images:Image
)

data class Connection(val groupAffiliation:String, val relatives:String)

 data class Image(
    val xs:String,
    val sm:String,
    val md:String,
    val lg:String
)

data class Work(val occupation:String, val base:String)


 data class Biography(
    val fullName:String,
    val alterEgos:String,
    val aliases:List<String>,
    val placeOfBirth:String,
    val firstAppearance:String,
    val publisher:String?,
    val alignment:String
)

 data class Appearence (
    val gender:String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor:String,
    val hairColor:String
)

 data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

