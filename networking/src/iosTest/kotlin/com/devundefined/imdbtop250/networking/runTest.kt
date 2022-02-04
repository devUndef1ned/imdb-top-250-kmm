package com.devundefined.imdbtop250.networking

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun runTest(block: suspend () -> Unit) = runBlocking {
    block()
}