//
//  MovieListViewModel.swift
//  iosApp
//
//  Created by Олег Кузьмин on 04/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import sharedFeature

extension MovieListContentView {
    class MovieListViewModel : ObservableObject {
        
        @Published private(set) var uiState: UiState = .initial
        
        let repository: DomainMovie250TopRepository
        
        init(repository: DomainMovie250TopRepository) {
            self.repository = repository
        }
        
        
        func loadData() {
            uiState = .loading
            
            Task.init {
                do {
                    try await repository.get250Top().onLeft { error in
                        self.uiState = .error(error)
                    }.onRight { data in
                        if let movies = data as? [Movie] {
                            self.uiState = .success(movies)
                        } else {
                            self.uiState = .error(CoreError(message: "UNKNOWN_ERROR"))
                        }
                    }
                } catch {
                    self.uiState = .error(CoreError(message: error.localizedDescription))
                }
            }
        }
    }
}

