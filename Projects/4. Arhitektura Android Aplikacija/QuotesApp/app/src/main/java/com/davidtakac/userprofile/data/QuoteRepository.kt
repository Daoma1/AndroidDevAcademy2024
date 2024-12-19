package com.davidtakac.userprofile.data

class QuoteRepository(private val quoteRemoteDataSource: QuoteRemoteDataSource) {
    private var _quotes: List<String>? = null

    suspend fun getQuotes(): GetQuotesResult {
        val currQuotes = _quotes
        if (currQuotes != null) return GetQuotesResult.Success(currQuotes)
        return try {
            val newQuotes = quoteRemoteDataSource.getQuotes()
            _quotes = newQuotes
            GetQuotesResult.Success(newQuotes)
        } catch (_: Exception) {
            GetQuotesResult.Failure
        }
    }
}

sealed interface GetQuotesResult {
    data class Success(val quotes: List<String>) : GetQuotesResult
    data object Failure : GetQuotesResult
}