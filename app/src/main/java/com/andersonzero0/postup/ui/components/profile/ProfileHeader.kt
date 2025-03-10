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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andersonzero0.postup.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileHeader() {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true);
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

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
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .aspectRatio(ratio = 16f / 5f, matchHeightConstraintsFirst = true)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primaryContainer
                        ),
                    )
                )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .width(64.dp)
                        .height(64.dp),
                    painter = painterResource(id = R.drawable.avatar),
                    contentScale = ContentScale.Crop,
                    contentDescription = "img_header"
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                ) {

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

            IconButton(onClick = { showBottomSheet = true }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Editar perfil"
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
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader()
}