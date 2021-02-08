import com.ankoki.pastebinapi.Pastebin;

public class ReadExample {

    public static void main(String[] args) {
        Pastebin paste = new Pastebin("bpgexBcS");
        System.out.println(paste.getPaste());
    }
}