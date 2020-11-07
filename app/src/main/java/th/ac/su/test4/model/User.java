package th.ac.su.test4.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "users")
public class User {


    @PrimaryKey(autoGenerate = true)
    public final int id;

    @ColumnInfo(name = "first_name")
    public final String firstName;

    @ColumnInfo(name = "last_name")
    public final String lastName;




    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

