public class Formatter {
    public  static String getCorrectCaseOfRuble(int number) {
        String result = "";
        int beforeLastDigit = number % 100 / 10;
        if (beforeLastDigit == 1) {
            result = "рублей";
        } else {
            switch (number % 10) {
                case 1:
                    result = "рубль";
                    break;
                case 2:
                    result = "рубля";
                    break;
                case 3:
                    result = "рубля";
                    break;
                case 4:
                    result = "рубля";
                    break;
                default:
                    result = "рублей";
                    break;
            }
        }
        return result;
    }
}
