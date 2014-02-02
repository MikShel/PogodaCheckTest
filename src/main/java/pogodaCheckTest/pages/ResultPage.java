package pogodaCheckTest.pages;

public interface ResultPage {

    void checkResults(String town);

    Boolean checkNotNullResults();

    void chooseTown(String town);

    void checkNullResults();
}
