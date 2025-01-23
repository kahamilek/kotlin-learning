package kah.com.examples.small.method.creation

import java.time.Instant

object TicketFactory {

    fun createTicket(
        accessId: String,
        ticketName: String,
        ticketPriceInCents: Int,
        ticketId: String,
        validFrom: Instant,
        validUntil: Instant,
    ): Ticket {
        return Ticket(
            name = ticketName,
            ticketPriceInCents = ticketPriceInCents,
            validFrom = validFrom,
            validUntil = validUntil
        )
    }
}