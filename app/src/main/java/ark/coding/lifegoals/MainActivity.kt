package ark.coding.lifegoals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ark.coding.lifegoals.ui.theme.Blue
import ark.coding.lifegoals.ui.theme.Cyan
import ark.coding.lifegoals.ui.theme.LifeGoalsTheme
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeGoalsTheme {
                Surface {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val horizontalPadding = 16.dp

    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = horizontalPadding, vertical = horizontalPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}, modifier = Modifier.background(Cyan, RoundedCornerShape(8.dp))
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
                Text(
                    text = "Don't Give Up",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = rememberImagePainter(data = "https://yt3.ggpht.com/moO_YchAIDE1V9JqkP3ZLazyi8xWb3Ns8d1T1lGKZON7xhFas5GqgoGO3jQeQX0VQRhXbVgsndU=s88-c-k-c0x00ffffff-no-rj") {
                        placeholder(R.drawable.ic_launcher_background)
                    },
                    contentDescription = "Profile",
                    Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = horizontalPadding)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "2 Big Challenges", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "Ambitious person aren't you?", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            Row(Modifier.fillMaxWidth()) {
                BigButton(
                    icon = Icons.Default.Timer,
                    iconTint = Color(0xff45BAC5),
                    title = "Life Style",
                    subtitle = "Become a morning person",
                    reminder = "Every Day",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { }
                )
                Spacer(modifier = Modifier.width(8.dp))
                BigButton(
                    icon = Icons.Default.Favorite,
                    iconTint = Color(0xffFA6569),
                    title = "Healthy Life",
                    subtitle = "Because your health is the most important",
                    reminder = "Every Day",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Today's Planning", fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
            Text(text = "You have 3 actions to do", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TaskItem(
                    icon = Icons.Outlined.Lightbulb,
                    title = "Learn new skill",
                    subtitle = "Complete programming course",
                    modifier = Modifier.clickable { })
                TaskItem(
                    icon = Icons.Outlined.WorkOutline,
                    title = "Create tutorial",
                    subtitle = "Create new YouTube tutorial",
                    modifier = Modifier.clickable { })
                TaskItem(
                    icon = Icons.Outlined.PlayArrow,
                    title = "Watch video",
                    subtitle = "Watch CodingArk new videos",
                    modifier = Modifier.clickable { })
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun BigButton(
    icon: ImageVector,
    iconTint: Color,
    title: String,
    subtitle: String,
    reminder: String,
    modifier: Modifier = Modifier
) {
    Card(backgroundColor = Cyan, elevation = 0.dp, modifier = modifier, contentColor = Color.Black) {
        Column(Modifier.padding(16.dp)) {
            Icon(imageVector = icon, contentDescription = "Icon", tint = iconTint, modifier = Modifier.size(52.dp))
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Text(text = subtitle, fontWeight = FontWeight.Medium, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Reminder", fontWeight = FontWeight.Light, fontSize = 10.sp, color = Color.Gray)
            Text(text = reminder, fontWeight = FontWeight.SemiBold, fontSize = 10.sp)
        }
    }
}

@Composable
fun TaskItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(modifier, backgroundColor = Cyan, elevation = 4.dp, contentColor = Color.Black) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                tint = Blue,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
            Column(
                Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(text = title)
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.Top)) {
                Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LifeGoalsTheme {
        MainApp()
    }
}