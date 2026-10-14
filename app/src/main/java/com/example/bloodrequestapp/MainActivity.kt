package com.example.bloodrequestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5F5)
                ) {
                    BloodRequestsScreen()
                }
            }
        }
    }
}

// ─────────────────────────────────────────────
// Main Screen
// ─────────────────────────────────────────────
@Composable
fun BloodRequestsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Blood Requests",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A2E),
            modifier = Modifier.padding(bottom = 30.dp)
        )

        // Card 1: O- Blood Needed
        BloodRequestCard(
            bloodType = "O-",
            units = 3,
            location = "Khulna City Medical College Hospital, KDA Ave..."
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Card 2: O+ Blood Needed
        BloodRequestCard(
            bloodType = "O+",
            units = 2,
            location = "Khulna City Medical College Hospital, KDA Ave..."
        )
    }
}

// ─────────────────────────────────────────────
// Single Blood Request Card
// ─────────────────────────────────────────────
@Composable
fun BloodRequestCard(
    bloodType: String,
    units: Int,
    location: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 5.dp,
                color = Color(0xFFC0392B),
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Top Row: URGENT badge + Units
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // URGENT Badge
                Text(
                    text = "URGENT",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC0392B),
                    modifier = Modifier
                        .background(
                            color = Color(0xFFFDECEA),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                )

                // Units
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🩸",
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$units Units",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF333333)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Blood Type Title
            Text(
                text = "$bloodType Blood Needed",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A2E)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Location
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📍",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = location,
                    fontSize = 14.sp,
                    color = Color(0xFF777777),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // View Details Button
            Button(
                onClick = { /* No functionality needed */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A1A2E)
                )
            ) {
                Text(
                    text = "View Details",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}