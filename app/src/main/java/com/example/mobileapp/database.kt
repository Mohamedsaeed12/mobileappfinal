import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "mobildev.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, email TEXT)")
        db.execSQL("CREATE TABLE IF NOT EXISTS users(userID int PRIMARY KEY, name char(100), userlogin char(100), userPass char(100))")
        db.execSQL("CREATE TABLE IF NOT EXISTS bookings (bookingID INTEGER PRIMARY KEY, userID INTEGER, roomID INTEGER, apptDate DATE, apptStartTime TIME, apptEndTime TIME, FOREIGN KEY(userID) REFERENCES users(id) ON DELETE SET NULL, FOREIGN KEY(roomID) REFERENCES room(roomID) ON DELETE SET NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    override fun getWritableDatabase(): SQLiteDatabase {
        return SQLiteDatabase.openOrCreateDatabase(context.getDatabasePath(DATABASE_NAME), null)
    }
}
