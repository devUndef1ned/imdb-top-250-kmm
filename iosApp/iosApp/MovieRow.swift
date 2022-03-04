//
//  MovieRow.swift
//  iosApp
//
//  Created by Олег Кузьмин on 04/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import domain
import SwiftUI

struct MovieRow: View {
    var movie: Movie
    
    var body: some View {
        ZStack {
            HStack {
                AsyncImage(
                    url: URL(string: movie.image),
                    content: { image in
                        image.resizable().aspectRatio(contentMode: .fit).frame(maxWidth: 100, maxHeight: 140).cornerRadius(10) },
                    placeholder: { ProgressView().frame(maxWidth: 100, maxHeight: 140) }
                )
                VStack(alignment: .leading) {
                    HStack {
                        Text(String(movie.rank)).font(.subheadline)
                        Text(movie.title).font(.headline)
                    }
                    Text(movie.crew).padding(.top, 8).font(.caption)
                    
                    HStack {
                        Text(String(format: "%.2f", movie.imDbRating))
                            .font(.subheadline).foregroundColor(Color.gray)
                    }.padding(.top, 8)
                }
                
                
            }
        }
        .frame(alignment: .center)
        .padding(.horizontal, 8)
        .padding(.vertical, 2)
        .background(Color("AccentLightColor"))
        .clipShape(RoundedRectangle(cornerRadius: 8.0))
    }
}

struct MoviewRow_Previews: PreviewProvider {
    static let movie = Movie(
        id: "tt0111161",
        rank: 1,
        title: "The Shawshank Redemption",
        fullTitle: "The Shawshank Redemption (1994)",
        year: "1994",
        image: "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg",
        crew: "Frank Darabont (dir.), Tim Robbins, Morgan Freeman",
        imDbRating: 9.2,
        imDbRatingCount: 2538931
    )
    
    static var previews: some View {
        MovieRow(movie: movie)
    }
}
