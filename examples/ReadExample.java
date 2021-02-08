import com.ankoki.pastebinapi.Pastebin;

public class ReadExample {

    public static void main(String[] args) {
        Pastebin paste = new Pastebin("bpgexBcS");
        Response<String> response = paste.getPaste();
        if (response.hasError()) {
            System.out.println("There was an error getting this paste!");
            System.out.println(response.getError());
        } else {
            System.out.println(response.get());
        }
    }
}