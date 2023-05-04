package cat.urv.deim.asm.patinfly.views.scooters


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface ScooterDao {
    @androidx.room.Query("SELECT * FROM scooters")
    fun getAll(): List<Scooter>

    @Insert
    fun insertAll(scooters: List<Scooter>)


    @Delete
    fun deleteAll(scooter: Scooter)
    @Insert
    fun insertScooterList(scooters: List<Scooter>)

    @Update
    fun update(scooter: Scooter)
}