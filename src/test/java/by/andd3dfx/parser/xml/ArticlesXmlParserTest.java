package by.andd3dfx.parser.xml;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticlesXmlParserTest {

    @Test
    public void parse() {
        List<String> articles = ArticlesXmlParser.parse("./src/main/resources/233.xml");

        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0)).isEqualTo("\n" +
                "\t\t\t\t\t\tSC reserves judgement in Fodder scam case\n" +
                "\n" +
                "\t\t\t\t\tNew Delhi, April 20 -- The Supreme Court on Thursday reserved its judgement in the Fodder scam case and asked all parties concerned to give their submissions within a week.\n" +
                "\t\t\t\t\tEarlier this week, the apex court heard the plea filed by Rashtriya Janata Dal (RJD) supremo Lalu Prasad Yadav challenging his jail sentence in connection with the mid-1990s fodder scam case.\n" +
                "\n" +
                "\t\t\t\tThe fodder scam involved the embezzlement of about Rs. 9.4 billion from the government treasury of Bihar.\n" +
                "\t\t\t\tThe CBI had filed a plea in the apex court against the dropping of a conspiracy charge against Yadav by the Jharkhand High Court in one of the fodder scam cases.\n" +
                "\t\t\t\tThe probe agency then filed its latest appeal against the High Court order upholding the agency's plea to continue proceedings in the trial court against Prasad under two sections, while dropping other charges on grounds that a person could not be tried twice for the same offence.\n" +
                "\t\t\t\tThe High Court had ordered that proceedings against Yadav be continued under IPC Sections 201 (causing disappearance of evidence of an offence committed or giving false information) and 511 (attempting to commit offences punishable with imprisonment for life or imprisonment, and in such attempt doing any act towards the commission of the offence).\n" +
                "\t\t\t\tThe charges are in connection with the case pertaining to fraudulent withdrawal of Rs. 96 lakh during Yadav's chief ministerial tenure.\n" +
                "\t\t\t\tThe fodder scam relates to fraudulent withdrawal of around Rs. 1,000 crore by the Animal Husbandry department from various districts when Lalu was the Bihar chief minister from 1990 to 1997.\n" +
                "\t\t\t\tPublished by HT Digital Content Services with permission from Asian News International.\n" +
                "\n" +
                "\t\t\tFor any query with respect to this article or any other content requirement, please contact Editor at htsyndication@hindustantimes.com \n" +
                "\n" +
                "\t\t\tCopyright 2017. ANI \n" +
                "\n");
    }
}
