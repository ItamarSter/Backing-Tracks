package itamar.stern.backingtracks

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RawRes
import itamar.stern.backingtracks.databinding.ActivityMainBinding
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import java.sql.Time
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MyMediaPlayer
    private lateinit var binding: ActivityMainBinding
    val set = mutableListOf<Int>()
    private var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MyMediaPlayer(this)
        setViews()
    }

    private fun runSet() {
        var count = 0
        timer.cancel()
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                mediaPlayer.startAudio(set[count])
                if (count < set.size - 1) count++ else count = 0
            }
        }, 0, 300)
    }

    private fun setViews() {
        binding.apply {
            e1.setOnClickListener {
                R.raw.e1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            f1.setOnClickListener {
                R.raw.f1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            fs1.setOnClickListener {
                R.raw.fs1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            g1.setOnClickListener {
                R.raw.g1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            gs1.setOnClickListener {
                R.raw.gs1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            a1.setOnClickListener {
                R.raw.a1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            a12.setOnClickListener {
                R.raw.a1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            as1.setOnClickListener {
                R.raw.as1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            b1.setOnClickListener {
                R.raw.b1.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            c2.setOnClickListener {
                R.raw.c2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            cs2.setOnClickListener {
                R.raw.cs2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            d2.setOnClickListener {
                R.raw.d2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            d22.setOnClickListener {
                R.raw.d2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            ds2.setOnClickListener {
                R.raw.ds2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            e2.setOnClickListener {
                R.raw.e2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            f2.setOnClickListener {
                R.raw.f2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            fs2.setOnClickListener {
                R.raw.fs2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            g2.setOnClickListener {
                R.raw.g2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            g22.setOnClickListener {
                R.raw.g2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            gs2.setOnClickListener {
                R.raw.gs2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            a2.setOnClickListener {
                R.raw.a2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            as2.setOnClickListener {
                R.raw.as2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            b2.setOnClickListener {
                R.raw.b2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            c3.setOnClickListener {
                R.raw.c3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            b22.setOnClickListener {
                R.raw.b2.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            c32.setOnClickListener {
                R.raw.c3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            cs3.setOnClickListener {
                R.raw.cs3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            d3.setOnClickListener {
                R.raw.d3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            ds3.setOnClickListener {
                R.raw.ds3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            e3.setOnClickListener {
                R.raw.e3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            e32.setOnClickListener {
                R.raw.e3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            f3.setOnClickListener {
                R.raw.f3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            fs3.setOnClickListener {
                R.raw.fs3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            g3.setOnClickListener {
                R.raw.g3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            gs3.setOnClickListener {
                R.raw.gs3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }
            a3.setOnClickListener {
                R.raw.a3.apply {
                    set.add(this)
                    mediaPlayer.startAudio(this)
                }
            }

            btnStartSet.setOnClickListener {
                if(set.isNotEmpty()) runSet()
            }
            btnPauseSet.setOnClickListener {
                timer.cancel()
            }
            btnResetSet.setOnClickListener {
                timer.cancel()
                set.clear()
            }
            btnDeleteStep.setOnClickListener {
                timer.cancel()
                set.removeLast()
            }
        }
    }
}