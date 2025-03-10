package com.andersonzero0.postup.ui.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andersonzero0.postup.R

@Composable
fun EditProfile() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(bottom = 40.dp)
            .imePadding()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Editar perfil",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.photo_camera_24dp),
                    contentDescription = "Camera",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .width(92.dp)
                    .height(92.dp),
                painter = painterResource(id = R.drawable.avatar),
                contentScale = ContentScale.Crop,
                contentDescription = "img_header"
            )

            Spacer(modifier = Modifier.width(20.dp))

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.photo_library_24dp),
                    contentDescription = "Gallery",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = { Text("Nome") },
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = { Text("Sobrenome") },
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = { Text("Nome de usuário") },
            placeholder = { Text("@") },
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "Salvar")
        }
    }

}

@Preview
@Composable
fun EditProfilePreview() {
    EditProfile()
}