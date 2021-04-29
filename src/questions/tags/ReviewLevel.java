package questions.tags;

import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ReviewLevel {
    String A = "A";
    String B = "B";
    String C = "C";
    String D = "D";
    String E = "E";
    String F = "F";
    String S = "S";
}
