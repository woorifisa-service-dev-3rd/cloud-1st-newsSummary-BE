package com.dev.newssummury.service;

import com.dev.newssummury.domain.Article;
import com.dev.newssummury.domain.ResponseData;
import com.dev.newssummury.repository.ArticleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParserService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void processJson(String jsonData) {
        try {
            // ObjectMapper를 사용하여 JSON을 ApiResponse 객체로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseData apiResponse = objectMapper.readValue(jsonData, ResponseData.class);

            List<Article> articleList =
                    apiResponse.getItems().stream().map(item ->
                            Article.of(replaceHtml(item.getTitle()), replaceHtml(item.getDescription()))
                    ).toList();

            articleRepository.saveAll(articleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String replaceHtml(String html) {
        return html.replaceAll("<[^>]*>", "");
    }

    private final String test2 = "{\n" +
            "\"lastBuildDate\":\"Thu, 10 Oct 2024 14:23:23 +0900\",\n" +
            "\t\"total\":265515,\n" +
            "\t\"start\":1,\n" +
            "\t\"display\":10,\n" +
            "\t\"items\":[\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"Online Korean language <b>test<\\/b> sessions to double next year to meet growing .." +
            ".\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/en.yna.co.kr\\/view\\/AEN20241010004700315?input=2106m\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/n.news.naver.com\\/mnews\\/article\\/001\\/0014974980?sid=104\",\n" +
            "\t\t\t\"description\":\"Korean <b>test<\\/b>-education ministry Online Korean language <b>test<\\/b> " +
            "sessions to double next year to meet growing demand SEJONG, Oct. 10 (Yonhap) -- The online-based Korean " +
            "language proficiency <b>test<\\/b>... \",\n" +
            "\t\t\t\"pubDate\":\"Thu, 10 Oct 2024 13:49:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"A new <b>test<\\/b> of the president's diplomacy\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/koreajoongangdaily.joins" +
            ".com\\/news\\/2024-10-08\\/opinion\\/columns\\/A-new-test-of-the-presidents-diplomacy\\/2150724\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/n.news.naver.com\\/mnews\\/article\\/640\\/0000059899?sid=110\",\n" +
            "\t\t\t\"description\":\"The war in the Gaza Strip and the escalating crisis in the Mideast present " +
            "another diplomatic <b>test<\\/b> for the Yoon Suk Yeol administration on a crusade to make Korea a " +
            "global centerpiece country.... \",\n" +
            "\t\t\t\"pubDate\":\"Tue, 08 Oct 2024 19:30:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"The Education Crisis Neither Candidate Will Address\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/www.nytimes" +
            ".com\\/2024\\/10\\/09\\/opinion\\/covid-education-crisis-election.html?partner=naver\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/www.nytimes" +
            ".com\\/2024\\/10\\/09\\/opinion\\/covid-education-crisis-election.html?partner=naver\",\n" +
            "\t\t\t\"description\":\"<b>Test<\\/b> scores on core subjects are lower than they have been in decades, " +
            "and the achievement gap... recent <b>test<\\/b> results from National Assessment of Educational Progress" +
            " — which my colleague Dana... \",\n" +
            "\t\t\t\"pubDate\":\"Wed, 09 Oct 2024 22:02:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"Now Not to be Taken Lightly, Kia The New K8 [<b>Test<\\/b> Drive]\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/it.chosun.com\\/news\\/articleView.html?idxno=2023092124640\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/it.chosun.com\\/news\\/articleView.html?idxno=2023092124640\",\n" +
            "\t\t\t\"description\":\"the <b>test<\\/b> drive, the sensation remains unforgettable. The movement of " +
            "the New K8 was very... The <b>test<\\/b> car is equipped with a 2.5-liter (ℓ) inline 4-cylinder engine, " +
            "which is a naturally... \",\n" +
            "\t\t\t\"pubDate\":\"Mon, 07 Oct 2024 13:00:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"넥슨, '슈퍼바이브' 오픈 베타 테스트 사전 등록 시작\",\n" +
            "\t\t\t\"originallink\":\"http:\\/\\/www.edaily.co.kr\\/news\\/newspath.asp?newsid=02171366639051608\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/n.news.naver.com\\/mnews\\/article\\/018\\/0005854490?sid=105\",\n" +
            "\t\t\t\"description\":\"넥슨은 띠어리크래프트 게임즈(Theorycraft Games)에서 개발 중인 신작 PC 게임 '슈퍼바이브(SUPERVIVE)'의 오픈 베타 " +
            "테스트(Open Beta <b>Test<\\/b>) 사전 등록 참가자 모집을 9일 시작했다고 10일 밝혔다. 슈퍼바이브는 올해 말... \",\n" +
            "\t\t\t\"pubDate\":\"Thu, 10 Oct 2024 10:22:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"용인특례시의회, 용인 관광 수요응답형 버스 타바용 시승\",\n" +
            "\t\t\t\"originallink\":\"http:\\/\\/www.breaknews.com\\/1061681\",\n" +
            "\t\t\t\"link\":\"http:\\/\\/www.breaknews.com\\/1061681\",\n" +
            "\t\t\t\"description\":\"Council <b>test<\\/b>-drove the transportation (Demand Responsive Transit, DRT) " +
            "'Tabayong.' According to the city council, on the 7th, at the Yongin City Tourism Demand Responsive " +
            "<b>Test<\\/b> Drive, Chairman Yoo Jin-seon, along with... \",\n" +
            "\t\t\t\"pubDate\":\"Wed, 09 Oct 2024 08:38:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"넥슨 신작 '슈퍼바이브', OBT 사전등록 시작\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/www.inven.co.kr\\/webzine\\/news\\/?news=299881\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/m.sports.naver.com\\/esports\\/article\\/442\\/0000176404\",\n" +
            "\t\t\t\"description\":\"넥슨(공동 대표 강대현·김정욱)은 띠어리크래프트 게임즈(Theorycraft Games, 대표 조 텅)에서 개발 중인 신작 PC 게임 " +
            "'슈퍼바이브(SUPERVIVE)'의 오픈 베타 테스트(Open Beta <b>Test<\\/b>) 사전 등록 참가자 모집을 9일 시작했다고... \",\n" +
            "\t\t\t\"pubDate\":\"Thu, 10 Oct 2024 10:26:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"넥슨 신작'슈퍼바이브' 오픈 베타 테스트 사전 등록 시작\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/weekly.cnbnews.com\\/news\\/article.html?no=163937\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/weekly.cnbnews.com\\/news\\/article.html?no=163937\",\n" +
            "\t\t\t\"description\":\"Beta <b>Test<\\/b>) 사전 등록 참가자 모집을 시작했다. 사진=넥슨 ㈜넥슨(공동 대표 강대현·김정욱)은 9일 띠어리크래프트 " +
            "게임즈에서 개발 중인 신작 PC 게임 '슈퍼바이브(SUPERVIVE)'의 오픈 베타 테스트(Open Beta <b>Test<\\/b>) 사전... \",\n" +
            "\t\t\t\"pubDate\":\"Thu, 10 Oct 2024 11:10:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"[News Today] WILD PURSUIT OF DRUNK DRIVER\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/news.kbs.co.kr\\/news\\/pc\\/view\\/view.do?ncd=8076611&ref=A\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/n.news.naver.com\\/mnews\\/article\\/056\\/0011814515?sid=104\",\n" +
            "\t\t\t\"description\":\"The driver then adamantly refused a breathalyzer <b>test<\\/b>. In response, " +
            "police have revoked the driver's license and submitted the case to the prosecution for refusing the " +
            "sobriety <b>test<\\/b>. This car has... \",\n" +
            "\t\t\t\"pubDate\":\"Tue, 08 Oct 2024 16:15:00 +0900\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\":\"Can a Vegetarian Dine Well in New York? We Put Some Top Menus to the <b>Test<\\/b>.." +
            ".\",\n" +
            "\t\t\t\"originallink\":\"https:\\/\\/www.nytimes" +
            ".com\\/2024\\/10\\/07\\/dining\\/vegetarian-restaurants-nyc.html?partner=naver\",\n" +
            "\t\t\t\"link\":\"https:\\/\\/www.nytimes.com\\/2024\\/10\\/07\\/dining\\/vegetarian-restaurants-nyc" +
            ".html?partner=naver\",\n" +
            "\t\t\t\"description\":\"Even the city's best restaurants deal with meat-averse customers in a variety of" +
            " ways, from discouraging them to welcoming them. More times than I can count, I've heard the same " +
            "refrain from... \",\n" +
            "\t\t\t\"pubDate\":\"Mon, 07 Oct 2024 18:02:00 +0900\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";

    public void parseContentFromUrl(String url) throws IOException {
        processJson(test2);
    }
}
