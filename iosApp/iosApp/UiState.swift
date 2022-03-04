//
//  UiState.swift
//  iosApp
//
//  Created by Олег Кузьмин on 04/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import domain

typealias CoreError = domain.Error

enum UiState {
    
    struct Content {
        let movies: [Movie]
    }
    
    case initial
    case loading
    case error(CoreError)
    case success(Content)
}
