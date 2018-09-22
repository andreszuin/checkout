
import Startup.Bootstrap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bootstrap b = new Bootstrap();
        b.criarBd();
        b.criarTabelas();
        b.preencher();

    }

}
