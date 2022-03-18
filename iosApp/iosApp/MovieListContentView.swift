import SwiftUI

struct MovieListContentView: View {
    @ObservedObject var viewModel: MovieListViewModel
    
	
    var body: some View {
        var isErrorShown = true
        func isErrorState() -> Bool {
            switch viewModel.uiState {
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
        
        switch viewModel.uiState {
        case .initial:
            return AnyView(ProgressView())
        case .loading:
            return AnyView(ProgressView())
        case .error(let coreError):
            
            return AnyView(
                Button("Retry") {
                    viewModel.loadData()
                }
                    .alert(isPresented: isErrorBinding) {
                        Alert(title: Text("Error while fetching data"), message: Text(coreError.message), dismissButton: .cancel {
                            isErrorShown = false
                        })
            })
        case .success(let content):
            return AnyView(
                List(content, id: \.self) { movie in
                    MovieRow(movie: movie)
                }.onAppear {
                    viewModel.loadData()
                }
            )
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		//ContentView(uiState: UiState.error(CoreError.init(message: "Achtung!!!")))
        //ContentView(uiState: .loading)
        AnyView(ProgressView())
    }
}
