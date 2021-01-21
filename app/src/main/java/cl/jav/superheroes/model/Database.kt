package cl.jav.superheroes.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import cl.jav.superheroes.view.BioFragment

@Dao
interface SuperDao{

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun loadAllSuper(heroList:List<SuperHero>)

    @Query("SELECT * FROM superhero")
    fun getAllSuper(): LiveData<List<SuperHero>>

    @Query("SELECT * FROM superhero WHERE id=:superId")
    fun getSuper(superId:Int):LiveData<SuperHero>

}

@Database(entities=[SuperHero::class], version=1)
@TypeConverters(Converter::class)
abstract class SuperDatabase: RoomDatabase() {
    abstract fun superDao():SuperDao
}

class SuperApplication: Application(){
    companion object{
        var superDatabase:SuperDatabase?=null

    }

    override fun onCreate(){
        super.onCreate()

        superDatabase=Room.databaseBuilder(this,SuperDatabase::class.java,"super_db").build()
    }
}