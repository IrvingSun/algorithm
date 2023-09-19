package cn.sunway.rsa256;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class AsymmetricEncryptionExample {

    public static void main(String[] args) {
        try {
            // 生成RSA密钥对，或者从其他地方获取已有的公钥和私钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPairGenerator.initialize(1, new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            
            // 要加密的数据
            String originalData = "Hello, world!";
            
            // 使用公钥进行加密
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedData = encryptCipher.doFinal(originalData.getBytes());
            
            // 使用私钥进行解密
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = decryptCipher.doFinal(encryptedData);
            
            String decryptedText = new String(decryptedData);
            
            System.out.println("原始数据: " + originalData);
            System.out.println("加密后的数据: " + new String(encryptedData));
            System.out.println("解密后的数据: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
