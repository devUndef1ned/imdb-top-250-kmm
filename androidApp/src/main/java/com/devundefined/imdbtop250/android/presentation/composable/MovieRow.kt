package com.devundefined.imdbtop250.android.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.devundefined.imdbtop250.android.R
import com.devundefined.imdbtop250.domain.Movie

@Composable
fun MovieRow(movie: Movie) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Row(
            modifier = Modifier.background(
                color = colorResource(id = R.color.colorAccentLight),
                shape = RoundedCornerShape(8.dp)
            ).fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.image,
                    builder = {
                        transformations(CircleCropTransformation())
                        placeholder(R.drawable.ic_movie)
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 8.dp),
                text = movie.rank.toString(),
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview
@Composable
private fun MovieRowPreview() {
    MaterialTheme {
        val movie = Movie(
            id = "tt0111161",
            rank = 1,
            title = "The Shawshank Redemption",
            fullTitle = "The Shawshank Redemption (1994)",
            year = "1994",
            image = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg",
            crew = "Frank Darabont (dir.), Tim Robbins, Morgan Freeman",
            imDbRating = 9.2f,
            imDbRatingCount = 2538931
        )

        MovieRow(movie = movie)
    }
}