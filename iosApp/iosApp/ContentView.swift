import SwiftUI

struct ContentView: View {
    @State var uiState: UiState = .initial
    
	
    var body: some View {
        var isErrorShown = true
        func isErrorState() -> Bool {
            switch uiState {
            case .error:
                return true
            default:
                return false
            
    }
        }
            var isErrorBinding = Binding<Bool>(
                get: {
            return isErrorShown && isErrorState()
        },
            set: { _ in }
        )
        
        switch uiState {
        case .initial:
            return AnyView(ProgressView())
        case .loading:
            return AnyView(ProgressView())
        case .error(let coreError):
            
            return AnyView(
                Button("Retry") {
                    // TODO retry in VM
                }
                    .alert(isPresented: isErrorBinding) {
                        Alert(title: Text("Error while fetching data"), message: Text(coreError.message), dismissButton: .cancel {
                            isErrorShown = false
                        })
            })
        case .success(let content):
            return AnyView(
                List(content.movies, id: \.self) { movie in
                    MovieRow(movie: movie)
                }
            )
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView(uiState: UiState.error(CoreError.init(message: "Achtung!!!")))
        ContentView(uiState: .loading)
	}
}
