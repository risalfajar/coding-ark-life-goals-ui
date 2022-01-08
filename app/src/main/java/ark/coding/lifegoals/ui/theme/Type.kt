package ark.coding.lifegoals.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ark.coding.lifegoals.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_bold, weight = FontWeight.Bold)
)

val Typography = Typography(
    defaultFontFamily = Poppins
)