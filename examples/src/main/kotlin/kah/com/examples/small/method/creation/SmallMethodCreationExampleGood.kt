package kah.com.examples.small.method.creation

import io.github.oshai.kotlinlogging.KotlinLogging
import java.time.Instant
import java.time.temporal.ChronoUnit

object SmallMethodCreationExampleGood {

    fun buyTicket(ticketId: String, ticketPriceInCents: Int): Ticket {
        validateParameters(ticketId, ticketPriceInCents)

        logger.debug { "Creating ticket for $ticketId" }
        val ticket = createTicketWith(ticketPriceInCents, ticketId)
        logger.debug { "Ticket has been created for $ticket" }

        return ticket
    }
}


private const val TICKET_FACTORY_ACCESS_ID = "test-code"
private const val DEFAULT_TICKET_NAME = "30-minutes ticket"

private val logger = KotlinLogging.logger {}


private fun validateParameters(ticketId: String, ticketPriceInCents: Int) {
    if (ticketId.isBlank()) {
        error("Blank ticket id $ticketId")
    }

    if (ticketPriceInCents <= 0) {
        error("Ticket price must be grater than 0. Defined ticket price in cents: $ticketPriceInCents")
    }

    if (ticketPriceInCents > 1000_00) {
        error("Ticket price is too high: $ticketPriceInCents")
    }
}

private fun createTicketWith(
    ticketPriceInCents: Int,
    ticketId: String
) = TicketFactory.createTicket(
    accessId = TICKET_FACTORY_ACCESS_ID,
    ticketName = DEFAULT_TICKET_NAME,
    ticketPriceInCents = ticketPriceInCents,
    ticketId = ticketId,
    validFrom = Instant.now(),
    validUntil = Instant.now().plus(1, ChronoUnit.DAYS)
)
