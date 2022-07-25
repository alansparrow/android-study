package com.trungtran.android.pokedex.pokemonlist

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.palette.graphics.Palette
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.trungtran.android.pokedex.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    fun calcDominantColor(drawable: Drawable, onFinished: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(
            Bitmap.Config.ARGB_8888, true
        )

        Palette.from(bmp).generate{
            it?.dominantSwatch?.rgb?.let { colorValue ->
                onFinished(Color(colorValue))
            }
        }
    }
}