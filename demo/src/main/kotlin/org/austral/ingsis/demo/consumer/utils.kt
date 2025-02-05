package org.austral.ingsis.demo.consumer

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun stringToFlow(text: String): Flow<String> {
    return flow {
        emit(text)
    }
}