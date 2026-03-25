package com.example.myapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycvcompose.R

// Warna tema CV
private val NavyBlue = Color(0xFF00366D)
private val TextGray = Color(0xFF666666)
private val White = Color.White

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ── FOTO PROFIL ──────────────────────────────────────────────
            Image(
                painter = painterResource(id = R.drawable.foto_fahmi),
                contentDescription = "Foto Profil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ── NAMA ─────────────────────────────────────────────────────
            Text(
                text = "FAHMI MUHAMMAD FAYID DHINANTA",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            // ── KONTAK ───────────────────────────────────────────────────
            Text(
                text = "Malang, Indonesia | 62895605878274 | NIM 245150700111018",
                fontSize = 9.sp,
                color = TextGray,
                textAlign = TextAlign.Center
            )
            Text(
                text = "fahmimuhammad2626@gmail.com",
                fontSize = 9.sp,
                color = TextGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ── SUMMARY ──────────────────────────────────────────────────
            CvSection(title = "SUMMARY") {
                Text(
                    text = "Information Technology undergraduate specializing in Data Science with hands-on experience in data analysis, MySQL querying, and Python-based data processing through academic projects. Strong foundation in statistics and analytical reasoning, with a focus on extracting insights.",
                    fontSize = 9.sp,
                    lineHeight = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ── EDUCATION ────────────────────────────────────────────────
            CvSection(title = "EDUCATION") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "University of Brawijaya | GPA 3,89 of 4,00",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "July 2024 - Jan 2028 (expected)",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Bachelor of Information Technology (Data Science Track)\n" +
                            "Relevant Coursework: Statistics & Probability, Data Science, SQL Programming, " +
                            "Linear Algebra, Discrete Mathematics, Calculus.",
                    fontSize = 9.sp,
                    lineHeight = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ── ORGANIZATIONAL EXPERIENCE ─────────────────────────────────
            CvSection(title = "ORGANIZATIONAL EXPERIENCE") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quadcopter Team | ROBOTIIK FILKOM Universitas Brawijaya",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "Oct 2024 - Present",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Motion Programmer\n" +
                            "Selected as programming support team member for KRTI 2025 (VTOL category); " +
                            "Team achieved Top 8 National ranking.\n" +
                            "Analyzed flight test and mission execution data by documenting timing delays, " +
                            "orientation tolerances, and system response behavior using Python and spreadsheets, " +
                            "identifying operational patterns to improve mission stability during competition trials.\n" +
                            "Documented troubleshooting processes and experimental findings in structured logs " +
                            "and shared spreadsheets, supporting clearer communication and faster decision making " +
                            "within programming and system teams.",
                    fontSize = 9.sp,
                    lineHeight = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ── SKILLS ───────────────────────────────────────────────────
            CvSection(title = "SKILLS") {
                Text(
                    text = "Data Analysis & Querying: SQL (MySQL), Google Sheets (VLOOKUP/XLOOKUP, Pivot Tables, Charting)\n" +
                            "Programming & Libraries: Python (Pandas, NumPy, Matplotlib)\n" +
                            "Data Visualization: Looker Studio\n" +
                            "Analytical Foundations: Statistical Analysis, Correlation Analysis, Data Interpretation\n" +
                            "Version Control & Environment: Git, Google Colab\n" +
                            "Languages: Indonesian (Native), English (Professional Working Proficiency)",
                    fontSize = 9.sp,
                    lineHeight = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}


// Reusable composable untuk setiap section di CV.
// Menampilkan judul berwarna navy, garis pemisah, lalu konten di bawahnya.
@Composable
fun CvSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = NavyBlue
        )
        Divider(
            color = NavyBlue,
            thickness = 2.dp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        content()
    }
}