package com.davidtakac.userprofile.data

import kotlinx.coroutines.delay

class QuoteRemoteDataSource {
    suspend fun getQuotes(): List<String> {
        delay(1000)
        return listOf(
            "You have power over your mind – not outside events. Realize this, and you will find strength.",
            "It is not the man who has too little, but the man who craves more, that is poor.",
            "It's not what happens to you, but how you react to it that matters.",
            "The happiness of your life depends upon the quality of your thoughts.",
            "We suffer more often in imagination than in reality.",
            "Freedom is the only worthy goal in life. It is won by disregarding things that lie beyond our control.",
            "When you arise in the morning, think of what a precious privilege it is to be alive – to breathe, to think, to enjoy, to love.",
            "Begin at once to live, and count each separate day as a separate life.",
            "If you want to improve, be content to be thought foolish and stupid.",
            "Accept the things to which fate binds you, and love the people with whom fate brings you together, but do so with all your heart."
        )
    }
}