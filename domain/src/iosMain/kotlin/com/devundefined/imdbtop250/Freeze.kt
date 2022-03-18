package com.devundefined.imdbtop250

import kotlin.native.concurrent.freeze

actual fun <T : Any?> T.freeze() = this.freeze()
