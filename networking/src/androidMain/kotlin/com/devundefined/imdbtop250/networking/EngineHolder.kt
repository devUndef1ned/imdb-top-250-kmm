package com.devundefined.imdbtop250.networking

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual fun engine(): HttpClientEngine = CIO.create()
