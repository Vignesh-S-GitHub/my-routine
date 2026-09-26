package com.vignesh.myroutine.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vignesh.myroutine.ui.theme.MyRoutineTheme

private data class RoutineItem(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val completed: Boolean = false,
    val progress: Float? = null
)

@Composable
fun MyRoutineApp() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomNav() }
    ) { innerPadding ->
        TodayScreen(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
private fun TodayScreen(modifier: Modifier = Modifier) {
    val routines = listOf(
        RoutineItem("Morning Routine", "5:30 – 7:30 AM · 4/5", Icons.Default.CheckCircle, completed = true, progress = 0.8f),
        RoutineItem("Breakfast", "7:00 – 9:00 AM", Icons.Default.LocalDining, completed = true),
        RoutineItem("Water", "3 / 8 glasses", Icons.Default.WaterDrop, progress = 0.375f),
        RoutineItem("Lunch", "12:30 – 2:00 PM", Icons.Default.LocalDining),
        RoutineItem("Movement", "Next reminder in 25 min", Icons.Default.DirectionsWalk),
        RoutineItem("Exercise", "6:00 – 7:30 PM", Icons.Default.DirectionsWalk),
        RoutineItem("Dinner", "7:30 – 9:00 PM", Icons.Default.LocalDining),
        RoutineItem("Night Routine", "9:30 – 10:30 PM", Icons.Default.Nightlight)
    )

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = 16.dp)
    ) {
        Text(
            text = "My Routine",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Small steps, every day.",
            color = Color(0xFF5D5D5D),
            fontSize = 16.sp
        )

        Spacer(Modifier.height(18.dp))

        ProgressCard()

        Spacer(Modifier.height(14.dp))

        routines.forEach {
            RoutineCard(item = it)
            Spacer(Modifier.height(10.dp))
        }
    }
}

@Composable
private fun ProgressCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF7C7))
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Today", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("5 of 8 routines on track", color = Color(0xFF5D5D5D))
            }

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(Color(0xFFE5F3E9)),
                contentAlignment = Alignment.Center
            ) {
                Text("62%", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }
}

@Composable
private fun RoutineCard(item: RoutineItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBF2))
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = if (item.completed) Color(0xFF2F7D4A) else MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(Modifier.size(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(item.title, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                    Text(item.subtitle, color = Color(0xFF6D6D6D), fontSize = 14.sp)
                }
                if (item.completed) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Completed",
                        tint = Color(0xFF2F7D4A)
                    )
                }
            }

            item.progress?.let { value ->
                Spacer(Modifier.height(12.dp))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(7.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFE5E2DA))
                ) {
                    Box(
                        Modifier
                            .fillMaxWidth(value)
                            .height(7.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
            }
        }
    }
}

@Composable
private fun BottomNav() {
    NavigationBar(
        containerColor = Color(0xFFFFFBF2)
    ) {
        val labels = listOf("Today", "Routines", "History", "Settings")
        labels.forEachIndexed { index, label ->
            NavigationBarItem(
                selected = index == 0,
                onClick = { },
                icon = {
                    Box(
                        Modifier
                            .size(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(if (index == 0) MaterialTheme.colorScheme.primary else Color.Transparent)
                    )
                },
                label = { Text(label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color(0xFF666666)
                )
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
private fun MyRoutinePreview() {
    MyRoutineTheme {
        MyRoutineApp()
    }
}
