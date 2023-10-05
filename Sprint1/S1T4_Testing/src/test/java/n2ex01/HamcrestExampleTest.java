package n2ex01;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HamcrestExampleTest {

    @Test
    public void lenString(){
        String testWord = "Mordor";
        assertThat(testWord, getLen(is(8)));
    }

    public static FeatureMatcher<String, Integer> getLen(Matcher<? super Integer> matcher){

        return new FeatureMatcher<>(matcher, "String of length", "Actual length") {
            @Override
            protected Integer featureValueOf(String word) {
                return word.length();
            }
        };
    }

}