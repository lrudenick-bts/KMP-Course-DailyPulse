package com.lrudenick.dailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lrudenick.dailypulse.android.screens.composables.ErrorMessage
import com.lrudenick.dailypulse.android.screens.composables.Loader
import com.lrudenick.dailypulse.sources.application.Source
import com.lrudenick.dailypulse.sources.presentation.SourcesViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SourcesScreen(
    viewModel: SourcesViewModel = getViewModel(),
    onUpButtonClick: () -> Unit
) {

    val sourcesState = viewModel.sourcesState.collectAsState()

    Column {
        Toolbar(onUpButtonClick)

        if (sourcesState.value.sources.isEmpty())
            Loader()
        if (sourcesState.value.error != null)
            ErrorMessage(sourcesState.value.error!!)
        if (sourcesState.value.sources.isNotEmpty())
            SourcesListView(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    onUpButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Sources") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Up Button",
                )
            }
        }
    )
}

@Composable
private fun SourcesListView(viewModel: SourcesViewModel) {

    Box(
        Modifier
            .fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.sourcesState.value.sources) { source ->
                SourceItemView(source)
            }
        }
    }
}

@Composable
private fun SourceItemView(source: Source) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.locale,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}