package com.andersonzero0.postup.ui.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.andersonzero0.postup.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileHeader() {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true);
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var primaryColor by remember { mutableStateOf(Color.Transparent) }
    var secondaryColor by remember { mutableStateOf(Color.Transparent) }

    val bitmap = ImageBitmap.imageResource(id = R.drawable.avatar)

    LaunchedEffect(Unit) {
        val palette = Palette.from(bitmap.asAndroidBitmap()).generate()
        primaryColor = Color(palette.getDominantColor(Color.Black.toArgb()))
        secondaryColor = Color(palette.getVibrantColor(Color.Gray.toArgb()))
    }

    Column {
//        Image(
//            modifier = Modifier
//                .clip(RoundedCornerShape(12.dp))
//                .fillMaxWidth()
//                .height(IntrinsicSize.Min)
//                .aspectRatio(ratio = 16f / 5f, matchHeightConstraintsFirst = true),
//            painter = painterResource(id = R.drawable.header),
//            contentScale = ContentScale.Crop,
//            contentDescription = "img_header"
//        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp))
                .fillMaxWidth()
                .aspectRatio(16f / 4f)
        ) {
            // Camada 1: Gradiente horizontal (primary → secondary)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(primaryColor.copy(alpha = 0.6f), secondaryColor.copy(alpha = 0.6f))
                        )
                    )
            )

            // Camada 2: Gradiente vertical para transparente
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.surface
                            ),
                            startY = 0.5f // Controla onde começa o fade
                        )
                    )
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-32).dp),
            horizontalAlignment = Alignment.CenterHorizontally
//                verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { showBottomSheet = true }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Compartilhar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .width(64.dp)
                        .height(64.dp),
                    painter = painterResource(id = R.drawable.avatar),
                    contentScale = ContentScale.Crop,
                    contentDescription = "img_avatar"
                )

                Spacer(modifier = Modifier.width(20.dp))

                IconButton(onClick = { showBottomSheet = true }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar perfil",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Anderson Viana",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "@andersonzero0",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }


    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            contentWindowInsets = { WindowInsets.ime },
        ) {
            EditProfile()
        }
    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader()
}