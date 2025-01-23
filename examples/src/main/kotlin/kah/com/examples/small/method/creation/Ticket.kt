package kah.com.examples.small.method.creation

import java.time.Instant

data class Ticket(
    val name: String,
    val ticketPriceInCents: Int,
    val validFrom: Instant,
    val validUntil: Instant
)
