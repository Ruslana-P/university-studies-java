import java.io.*;

public class CaesarCipher {
    
    // Власний фільтр для шифрування
    static class CaesarWriter extends FilterWriter {
        private final char key;
        protected CaesarWriter(Writer out, char key) { super(out); this.key = key; }

        @Override
        public void write(int c) throws IOException {
            super.write(c + key); // Шифрування: зміщення коду символу вгору
        }
    }

    // Власний фільтр для дешифрування
    static class CaesarReader extends FilterReader {
        private final char key;
        protected CaesarReader(Reader in, char key) { super(in); this.key = key; }

        @Override
        public int read() throws IOException {
            int c = super.read();
            return (c == -1) ? -1 : (c - key); // Дешифрування: зміщення коду вниз
        }
    }

    public static void main(String[] args) throws IOException {
        char key = 'B'; // Ключовий символ
        String originalText = "Hello Java Streams!";
        String fileName = "encrypted.txt";

        // а) Метод шифрування через FilterWriter
        try (CaesarWriter cw = new CaesarWriter(new FileWriter(fileName), key)) {
            cw.write(originalText);
        }

        // b) Метод дешифрування через FilterReader
        StringBuilder decrypted = new StringBuilder();
        try (CaesarReader cr = new CaesarReader(new FileReader(fileName), key)) {
            int data;
            while ((data = cr.read()) != -1) {
                decrypted.append((char) data);
            }
        }
        
        System.out.println("Оригінал: " + originalText);
        System.out.println("Відновлено: " + decrypted);
    }
}