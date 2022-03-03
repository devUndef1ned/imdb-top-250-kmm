package com.devundefined.imdbtop250.android.presentation.composable

import android.icu.text.DecimalFormat
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transition.CrossfadeTransition
import coil.transition.Transition
import com.devundefined.imdbtop250.android.R
import com.devundefined.imdbtop250.domain.Movie
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun MovieRow(movie: Movie) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.colorAccentLight),
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.image,
                    builder = {
                        transition(CrossfadeTransition())
                        placeholder(R.drawable.ic_movie)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .padding(vertical = 10.dp)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = movie.rank.toString(),
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = movie.title,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = movie.crew,
                    style = MaterialTheme.typography.caption
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RatingBar(
                        modifier = Modifier
                            .padding(8.dp)
                            .wrapContentSize(),
                        config = RatingBarConfig()
                            .style(RatingBarStyle.HighLighted)
                            .isIndicator(true)
                            .numStars(5),
                        value = (movie.imDbRating * 5) / 10f,
                        onValueChange = {},
                        onRatingChanged = {})
                    Text(
                        text = DecimalFormat("#.##").format(movie.imDbRating),
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Gray
                    )
                }
            }
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