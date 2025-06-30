package banking.model;

import java.time.LocalDateTime;

    public record Transaction (
            String type,
            double amount,
            double balanceBefore,
            double balanceAfter,
            LocalDateTime timestamp
    ) {}

