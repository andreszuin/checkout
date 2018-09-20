import java.io.IOException;

public class Main {
    //fredpolicarpo@zgsolucoes.com.br
    public static void main(String[] args) throws IOException {
        Bootstrap b = new Bootstrap();
        b.criar();
        Csvreader c = new Csvreader();
        c.read();
    }

}
