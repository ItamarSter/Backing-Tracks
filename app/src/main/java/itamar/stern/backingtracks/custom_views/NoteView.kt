package itamar.stern.backingtracks.custom_views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import itamar.stern.backingtracks.AddNotesMode
import itamar.stern.backingtracks.R
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import itamar.stern.backingtracks.media_player.Track

class NoteView(
    context: Context,
    attrs: AttributeSet? = null
) : TextView(
    context,
    attrs
) {

    private var mediaPlayer: MyMediaPlayer = MyMediaPlayer(context)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NoteView)
        val noteFile = typedArray.getResourceId(R.styleable.NoteView_noteFile, 0)
        typedArray.recycle()

        setOnClickListener {
            noteFile.apply {
                when(Track.addNotesMode) {
                    AddNotesMode.SINGLE -> {
                        Track.set.add(mutableListOf(this))
                    }
                    AddNotesMode.CHORD -> {
                        Track.set[Track.set.size - 1].add(this)
                    }
                }

                mediaPlayer.startAudio(this)
            }
        }

        setBackgroundColor(Color.parseColor("#eeeeee"))

    }
}