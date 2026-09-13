package br.com.fronteira.main;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class App {

    public static void main(String[] args) {
        String encryptedB64 = "U2FsdGVkX1/Jz86x4/Ydu3FZFw5pSo86xHG1MwpCFX/Dnn9uCMDd3xLNn61XZouvQy6G2FIhyQXAQwvTWn3/01JGIoIh5RN4NXgs+kdpcf6afHmSMvCZu0EiiiXlVpB2EQGIKDLIAU9c1aQx6bzEgQ==";
        encryptedB64 = encryptedB64.replaceAll("\s", "");

        byte[] all = Base64.getDecoder().decode(encryptedB64);
        byte[] salt = Arrays.copyOfRange(all, 8, 16);
        byte[] cipherText = Arrays.copyOfRange(all, 16, all.length);

        String charset = "abcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println("Iniciando ataque de forca bruta no link da NexusTech...");
        long startTime = System.currentTimeMillis();

        for (char c1 : charset.toCharArray()) {
            for (char c2 : charset.toCharArray()) {
                String testPass = "jav" + c1 + c2;
                try {
                    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                    PBEKeySpec spec = new PBEKeySpec(testPass.toCharArray(), salt, 1000, 48 * 8);
                    byte[] keyAndIv = factory.generateSecret(spec).getEncoded();

                    byte[] key = Arrays.copyOfRange(keyAndIv, 0, 32);
                    byte[] iv = Arrays.copyOfRange(keyAndIv, 32, 48);

                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));

                    String result = new String(cipher.doFinal(cipherText), StandardCharsets.ISO_8859_1);

                    if (result.contains("http")) {
                        String link = "";
                        int inicio = result.indexOf("http");
                        for (int i = inicio; i < result.length(); i++) {
                            char atual = result.charAt(i);
                            if (atual < 32 || atual > 126) {
                                break;
                            }
                            link = link + atual;
                        }
                        long endTime = System.currentTimeMillis();
                        System.out.println("\n SUCESSO! A criptografia foi quebrada!");
                        System.out.println("Senha encontrada: " + testPass);
                        System.out.println("Link revelado: " + link);
                        System.out.println("Tempo de execucao: " + (endTime - startTime) + "ms");
                        return;
                    }
                } catch (Exception e) {
                }
            }
        }
        System.out.println("\nForca bruta concluida. Senha nao encontrada.");
    }
}
