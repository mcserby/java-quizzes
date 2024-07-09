package org.training.diff;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiffTest {

    @Test
    void testCsvDiff1() {
        String leftCsv = """
             Movie,Rating,Topics
             Ex Machina,3.9,SF~AI
             The Transporter,4.1,Action
             """;

        String rightCsv = """
             Movie,Rating,Topics
             The Transporter,4.2,Cars
             Three Body Problem,4.9,SF
             """;
        String diff = DiffCalculator.diff(List.of("Movie"), leftCsv, rightCsv);
        assertEquals("""
                     Change,Movie,RatingLeft,RatingRight,RatingDelta,TopicsLeft,TopicsRight,TopicsDiff
                     Delete,Ex Machina,3.9,,100,SF~AI,5,
                     Change,The Transporter,4.1,4.2,10,Action,Cars,6
                     Insert,Three Body Problem,,4.9,100,,SF,2
                     """, diff);
    }

    @Test
    void testCsvDiff2() {
        String leftCsv = """
             TransactionRef,Name,Price
             10,USD,0.4
             20,EUR,105
             30,ETH,0.0005
             40,BTC,0.1
             """;

        String rightCsv = """
             TransactionRef;Name;Price
             10;USD;1.0
             20;EUR;105
             35;RON;1000
             40;BTC;0.3
             """;

        String diff = DiffCalculator.diff(List.of("TransactionRef"), leftCsv, rightCsv);
        assertEquals("""
                     Change,TransactionRef,NameLeft,NameRight,NameDiff,PriceLeft,PriceRight,PriceDelta
                     Change,10,USD,USD,0,0.4,1.0,150.0
                     None,20,EUR,EUR,0,105,105,0.0
                     Delete,30,ETH,,3,0.0005,,100.0
                     Insert,35,,RON,3,,1000,100.0
                     Change,40,BTC,BTC,0,0.1,0.3,200.0
                     """, diff);
    }

}