//
//  UiState.swift
//  iosApp
//
//  Created by Олег Кузьмин on 04/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import sharedFeature

typealias CoreError = sharedFeature.DomainError
typealias Movie = sharedFeature.DomainMovie

enum UiState {
    case initial
    case loading
    case error(CoreError)
    case success([Movie])
}
