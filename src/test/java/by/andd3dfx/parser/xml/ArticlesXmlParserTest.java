package by.andd3dfx.parser.xml;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticlesXmlParserTest {

    private ArticlesXmlParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new ArticlesXmlParser();
    }

    @Test
    public void parse() {
        List<String> articles = parser.parse("./src/main/resources/233.xml");

        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0)).isEqualTo(
            "SC reserves judgement in Fodder scam case\n" +
                "New Delhi, April 20 -- The Supreme Court on Thursday reserved its judgement in the Fodder scam case and asked all parties concerned to give their submissions within a week.\n" +
                "Earlier this week, the apex court heard the plea filed by Rashtriya Janata Dal (RJD) supremo Lalu Prasad Yadav challenging his jail sentence in connection with the mid-1990s fodder scam case.\n" +
                "The fodder scam involved the embezzlement of about Rs. 9.4 billion from the government treasury of Bihar.\n" +
                "The CBI had filed a plea in the apex court against the dropping of a conspiracy charge against Yadav by the Jharkhand High Court in one of the fodder scam cases.\n" +
                "The probe agency then filed its latest appeal against the High Court order upholding the agency's plea to continue proceedings in the trial court against Prasad under two sections, while dropping other charges on grounds that a person could not be tried twice for the same offence.\n" +
                "The High Court had ordered that proceedings against Yadav be continued under IPC Sections 201 (causing disappearance of evidence of an offence committed or giving false information) and 511 (attempting to commit offences punishable with imprisonment for life or imprisonment, and in such attempt doing any act towards the commission of the offence).\n" +
                "The charges are in connection with the case pertaining to fraudulent withdrawal of Rs. 96 lakh during Yadav's chief ministerial tenure.\n" +
                "The fodder scam relates to fraudulent withdrawal of around Rs. 1,000 crore by the Animal Husbandry department from various districts when Lalu was the Bihar chief minister from 1990 to 1997.\n" +
                "Published by HT Digital Content Services with permission from Asian News International.\n" +
                "For any query with respect to this article or any other content requirement, please contact Editor at htsyndication@hindustantimes.com\n" +
                "Copyright 2017. ANI"
        );
    }
}
