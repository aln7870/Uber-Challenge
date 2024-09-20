package com.aln.email_service.infra.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {

    // Injeta o valor da chave de acesso AWS a partir do arquivo de propriedades
    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    // Injeta o valor da chave secreta AWS a partir do arquivo de propriedades
    @Value("${aws.secretKey}")
    private String secretKey;

    // Injeta o valor da região AWS a partir do arquivo de propriedades
    @Value("${aws.region}")
    private String region;

    // Define um bean para o serviço AmazonSimpleEmailService
    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        // Cria credenciais AWS básicas usando a chave de acesso e a chave secreta
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKey);

        // Constrói o cliente AmazonSimpleEmailService com a região e as credenciais fornecidas
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(region) // Define a região do serviço
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)) // Define as credenciais
                .build(); // Constrói o cliente
    }
}
