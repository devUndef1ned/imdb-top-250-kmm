package com.devundefined.imdbtop250.monad

sealed class Either<A : Any, B : Any> {
    companion object {
        fun <A : Any, B : Any> left(left: A) = Left<A, B>(left)
        fun <A : Any, B : Any> right(right: B) = Right<A, B>(right)
    }

    fun onRight(rightSideEffect: (B) -> Unit): Either<A, B> = apply {
        when(this) {
            is Left -> Unit
            is Right -> rightSideEffect(right)
        }
    }

    fun onLeft(leftSideEffect: (A) -> Unit): Either<A, B> = apply {
        when(this) {
            is Left -> leftSideEffect(left)
            is Right -> Unit
        }
    }
}

data class Left<A : Any, B : Any>(val left: A) : Either<A, B>()

data class Right<A : Any, B : Any>(val right: B) : Either<A, B>()

fun <A : Any, B : Any, C : Any> Either<A, B>.map(mapFun: (B) -> C): Either<A, C> = when(this) {
    is Left -> Either.left(this.left)
    is Right -> Either.right(mapFun(this.right))
}
