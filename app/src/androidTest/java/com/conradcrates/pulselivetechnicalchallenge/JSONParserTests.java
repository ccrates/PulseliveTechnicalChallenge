package com.conradcrates.pulselivetechnicalchallenge;

import com.conradcrates.pulselivetechnicalchallenge.backend.JSONParser;
import com.conradcrates.pulselivetechnicalchallenge.data.Article;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conrad on 03/10/2017.
 */

public class JSONParserTests {

    @Test
    public void parseArticleDetailsSuccessfully(){
        int id = 42;
        String title = "title test";
        String subtitle = "subtitle test";
        String body = "body test";

        String data = "{\"item\":{\"id\":" + id + ",\"title\":\"" + title + "\",\"subtitle\":\"" + subtitle + "\",\"body\":\"" + body + "\"}}";

        Article article = JSONParser.parseArticleDetails(data);

        Assert.assertEquals(id, article.getId());
        Assert.assertEquals(title, article.getTitle());
        Assert.assertEquals(subtitle, article.getSubtitle());
        Assert.assertEquals(body, article.getBody());
    }
}