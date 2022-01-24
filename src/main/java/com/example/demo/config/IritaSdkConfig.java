package com.example.demo.config;

import irita.sdk.client.IritaClient;
import irita.sdk.config.ClientConfig;
import irita.sdk.config.OpbConfig;
import irita.sdk.constant.ContractAddress;
import irita.sdk.key.Sm2KeyManager;
import irita.sdk.module.community_gov.CommunityGovClient;
import irita.sdk.module.wasm.WasmClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.InputStream;

@Configuration
@Data
@ConfigurationProperties(prefix = "irita.sdk")
public class IritaSdkConfig {
    private String mnemonic;
    private String password;
    private String opbUri;
    private String grpcAddr;
    private String projectId;
    private String projectKey;
    private String chainId;
    private int gas;
    private String amount;
    private String denom;

    @Bean
    public IritaClient iritaClient() {
        Sm2KeyManager km = new Sm2KeyManager();
        km.recover(mnemonic);
        ClientConfig cliCfg = new ClientConfig(opbUri, grpcAddr, chainId);
        OpbConfig opbCfg = new OpbConfig(projectId, projectKey, km.getCurrentKeyInfo().getAddress());
        opbCfg.setRequireTransportSecurity(true);
        return new IritaClient(cliCfg, opbCfg, km);
    }

    public String getAmount() {
        if (StringUtils.hasLength(amount)) {
            return amount;
        }
        return "200000";
    }

    public String getDenom() {
        if (StringUtils.hasLength(denom)) {
            return denom;
        }
        return "uirita";
    }

    public int getGas() {
        return gas != 0 ? gas : 10000000;
    }
}
