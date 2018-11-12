package com.mycompany.demo.subscription.resolvers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class StockPriceUpdate {
    private final String stockCode;
    private final String dateTime;
    private final BigDecimal stockPrice;
    private final BigDecimal stockPriceChange;
}
