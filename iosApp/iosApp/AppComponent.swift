//
//  AppComponent.swift
//  iosApp
//
//  Created by Олег Кузьмин on 07/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import sharedFeature

class AppComponent {
    func provideRepository() -> DomainMovie250TopRepository {
        return FeatureComponent.shared.provideTop250Repository()
    }
}
