package pogodaCheckTest.pages;

public interface ResultPage {

    public void checkResults(String town);

    public Boolean checkNotNullResults();

    public void chooseTown();

    public void checkNullResults();
}
