import SwiftUI

@main
struct iOSApp: App {
    let appComponent = AppComponent()
    
    
	var body: some Scene {
		WindowGroup {
            MovieListContentView(viewModel: .init(repository: appComponent.provideRepository()))
		}
	}
}
