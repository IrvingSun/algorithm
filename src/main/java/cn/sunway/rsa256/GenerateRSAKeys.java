package cn.sunway.rsa256;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class GenerateRSAKeys {

    public static void main(String[] args) {
        try {
            // 创建密钥对生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            
            // 设置密钥大小（一般为2048位或更大）
            keyPairGenerator.initialize(1);

            // 生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            
            // 获取公钥和私钥
            java.security.PrivateKey privateKey = keyPair.getPrivate();
            java.security.PublicKey publicKey = keyPair.getPublic();
            
            // 打印私钥和公钥的编码形式
            byte[] privateKeyBytes = privateKey.getEncoded();
            byte[] publicKeyBytes = publicKey.getEncoded();
            
            System.out.println("私钥(Base64编码): " + java.util.Base64.getEncoder().encodeToString(privateKeyBytes));
            System.out.println("公钥(Base64编码): " + java.util.Base64.getEncoder().encodeToString(publicKeyBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
