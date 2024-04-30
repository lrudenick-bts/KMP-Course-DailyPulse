//
//  SourcesScreen.swift
//  iosApp
//
//  Created by Leopoldo Rudenick on 30/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SourcesScreen: View {
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack {
            SourcesListView(viewModel: .init())
                .navigationTitle("Sources")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
        }
    }
}

extension SourcesListView {
    
    @MainActor
    class SourcesViewModelWrapper: ObservableObject {
        let viewModel: SourcesViewModel
        
        
        init() {
            viewModel = SourcesInjector().sourcesViewModel
            sourcesState = viewModel.sourcesState.value
        }
        
        @Published var sourcesState: SourcesState
        
        func startObserving() {
            Task {
                for await sourcesS in viewModel.sourcesState {
                    self.sourcesState = sourcesS
                }
            }
        }
    }
}

struct SourcesListView: View {
    
    @ObservedObject private(set) var viewModel: SourcesViewModelWrapper
    
    var body: some View {
        VStack {
            if viewModel.sourcesState.loading {
                Loader()
            }
            
            if let error = viewModel.sourcesState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.sourcesState.sources.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.sourcesState.sources, id: \.self) {
                            source in
                            SourceItemView(
                                name: source.name,
                                desc: source.desc,
                                locale: source.locale
                            )
                        }
                    }
                }
            }
            
        }.onAppear{
            self.viewModel.startObserving()
        }
    }
}

struct SourceItemView: View {
    var name: String
    var desc: String
    var locale: String
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(name)
                .font(.title)
                .fontWeight(.bold)
            Text(desc)
            Text(locale).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}
