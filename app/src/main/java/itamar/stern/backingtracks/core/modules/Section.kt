package itamar.stern.backingtracks.core.modules

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Section(
    @PrimaryKey
    var id: Double = 0.0,
    var section: String,
    var name: String
)