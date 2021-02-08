import com.ankoki.pastebinapi.api.PasteBuilder;
import com.ankoki.pastebinapi.utils.Response;

public class PostExample {

    public static void main(String[] args) {
        PasteBuilder builder = new PasteBuilder();
        builder.setTitle("This is a test paste!");
        builder.setText("Check this out, a test paste :smirk_face:");
        builder.setDeveloperKey(DEVELOPER_KEY);
        Response<String> response = builder.createPaste();
        if (response.hasError()) {
            System.out.println(response.getError());
        } else {
            System.out.println(response.get());
        }
    }
}
