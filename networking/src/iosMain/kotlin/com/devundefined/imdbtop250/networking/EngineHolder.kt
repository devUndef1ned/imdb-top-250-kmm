package com.devundefined.imdbtop250.networking

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual fun engine(): HttpClientEngine = Darwin.create()
