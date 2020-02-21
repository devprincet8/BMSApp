package com.soarmorrow.bms.view.intro_screen

import com.soarmorrow.bms.R

enum class Model private constructor(val titleResId: Int, val layoutResId: Int) {
    INTRO1(R.string.one, R.layout.intro_screen1),
    INTRO2(R.string.two, R.layout.intro_screen2),
    INTRO3(R.string.three, R.layout.intro_screen3),
    INTRO4(R.string.four, R.layout.intro_screen4)

}